package com.tomtop.services.impl.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tomtop.dto.Country;
import com.tomtop.dto.order.ShippingMethodDetail;
import com.tomtop.entity.order.ShippingMethodRequst;
import com.tomtop.enums.ProductLabelType;
import com.tomtop.services.ICurrencyService;
import com.tomtop.services.order.IFreightService;
import com.tomtop.services.product.IProductLabelService;
import com.tomtop.services.product.IProductService;
import com.tomtop.utils.DoubleCalculateUtils;
import com.tomtop.valueobjects.BundleCartItem;
import com.tomtop.valueobjects.CartItem;
import com.tomtop.valueobjects.order.ShippingMethodInformation;
import com.tomtop.valueobjects.product.Weight;

/**
 *
 * @ClassName: FreightService
 * @Description: 有关运费计算的服务 如果exchangeRate == null，则默认从foundationService
 *               currencyService 中取得当前货币汇率 重量单位为：克
 * @author luojiaheng
 * @date 2015年1月20日 上午10:03:58
 *
 */
@Service
public class FreightService implements IFreightService {

	private static final Logger Logger = LoggerFactory
			.getLogger(FreightService.class);

	@Autowired
	ICurrencyService currencyService;

	@Autowired
	IProductService productService;

	@Autowired
	ShippingMethodService shippingMethodService;

	@Autowired
	IProductLabelService productLabelService;

	private List<String> getFreeShipping(List<String> listingIds) {
		List<String> result = Lists.newArrayList();
		// ~ 全免邮
		List<String> freeLabelList = productLabelService
				.getListByListingIdsAndType(listingIds,
						ProductLabelType.FreeShipping.toString());
		if (freeLabelList != null && freeLabelList.size() > 0) {
			result.addAll(freeLabelList);
		}
		// ~ 全免邮
		List<String> freelist = productLabelService.getListByListingIdsAndType(
				listingIds, ProductLabelType.AllFreeShipping.toString());
		Logger.debug("free listingids -- >{} ", freelist.toString());
		if (freelist != null && freelist.size() > 0) {
			result.addAll(freelist);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.order.IFreightService#getTotalWeight(java.util.Map,
	 * java.lang.Boolean)
	 */
	@Override
	public Double getTotalWeight(Map<String, Integer> map,
			Boolean isNeedFreeShippingLabel) {
		List<String> listingIds = Lists.newArrayList(map.keySet());
		if (listingIds.isEmpty()) {
			return 0.0;
		}
		List<Weight> weights = productService.getWeightList(listingIds);
		Map<String, Weight> weightMap = Maps.uniqueIndex(weights,
				e -> e.getListingId());
		List<String> freeLabelList = Lists.newArrayList();
		if (isNeedFreeShippingLabel) {
			freeLabelList = this.getFreeShipping(listingIds);
		}
		DoubleCalculateUtils dcu = new DoubleCalculateUtils(0);
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			if (!freeLabelList.contains(entry.getKey())) {
				Double temp = weightMap.get(entry.getKey()).getWeight()
						* entry.getValue();
				dcu = dcu.add(temp);
			}
		}
		return dcu.doubleValue();
	}

	@Override
	public Double getFinalFreight(Integer shippingMethodId, Double weight,
			Double shippingWeight, String curency, Integer lang,
			double grandTotal) {
		ShippingMethodDetail shippingMethod = shippingMethodService
				.getShippingMethodDetail(shippingMethodId, lang);
		if (null == shippingMethod) {
			Logger.info(
					"shippingMethod is null where shippingMethodId = {}, lang = {}",
					shippingMethodId, lang);
			return null;
		}
		return getFinalFreight(shippingMethod, weight, shippingWeight, curency,
				grandTotal, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.order.IFreightService#getFinalFreight(dto.ShippingMethodDetail,
	 * java.lang.Double, java.lang.Double, java.lang.String, double)
	 */
	@Override
	public Double getFinalFreight(ShippingMethodDetail shippingMethod,
			Double weight, Double shippingWeight, String currency,
			double grandTotal, boolean hasAllFreeShipping) {
		Double actualWeight = weight;
		// 如果是免邮的，则取去掉了免邮产品之后的重量
		Logger.debug("hasAllFreeShipping:{}", hasAllFreeShipping);
		if (shippingMethod.getBexistfree() || hasAllFreeShipping) {
			actualWeight = shippingWeight;
		}
		Double freight = 0.0;
		// ~ 全免邮
		if (hasAllFreeShipping == false || actualWeight > 0) {
			freight = getFreight(shippingMethod, actualWeight, currency);
		}
		Logger.debug("************** freight: {} **************{}--{}",
				freight, shippingWeight, actualWeight);
		if (null == freight) {
			return null;// 这里返回null是因为后面需要null值来进行一些判断
		}
		return freight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.order.IFreightService#getFreight(dto.ShippingMethodDetail,
	 * java.lang.Double, java.lang.String)
	 */
	@Override
	public Double getFreight(ShippingMethodDetail shippingMethod,
			Double weight, String currency) {
		Double p = getFirstFreight(shippingMethod, weight);
		if (null == p) {
			return null;
		}
		HashMap<String, String> subs = Maps.newHashMap();
		subs.put("\\$p", p.toString());
		subs.put("\\$w", weight.toString());
		subs.put("\\$cg", Double
				.valueOf(currencyService.exchange("GBP", "CNY")).toString());
		subs.put("\\$cu", Double
				.valueOf(currencyService.exchange("USD", "CNY")).toString());
		subs.put("\\$ce", Double
				.valueOf(currencyService.exchange("EUR", "CNY")).toString());
		Double temp = runJS(subs, shippingMethod.getCsuperrule());
		Double freight = currencyService.exchange(temp, "CNY", currency);
		if ("JPY".equals(currency)) {
			BigDecimal b1 = new BigDecimal(freight);
			b1.setScale(0, RoundingMode.HALF_UP);
			return new Double(b1.intValue());
		}
		return new DoubleCalculateUtils(freight).doubleValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.order.IFreightService#getFirstFreight(dto.ShippingMethodDetail,
	 * java.lang.Double)
	 */
	@Override
	public Double getFirstFreight(ShippingMethodDetail shippingMethod,
			Double weight) {
		String value = shippingMethod.getCrule(); // 要运算的公式,包含变量
		// 哈希, key为要代替公式中变量的正则，value为为要代替公式中变量的实际值
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		HashMap<String, String> subs = new HashMap<String, String>();
		subs.put("\\$w", weight.toString());
		return runJS(subs, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.order.IFreightService#runJS(java.util.HashMap,
	 * java.lang.String)
	 */
	@Override
	public Double runJS(HashMap<String, String> subs, String ruleValue) {
		ScriptEngineManager manager = new ScriptEngineManager(
				ClassLoader.getSystemClassLoader());
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			subs.put("ceil", "Math.ceil");
			subs.put("floor", "Math.floor");
			for (String subKey : subs.keySet()) {
				ruleValue = ruleValue.replaceAll(subKey, subs.get(subKey));
			}
			Double cost = new Double(String.valueOf(engine.eval(ruleValue)));
			DoubleCalculateUtils duti = new DoubleCalculateUtils(cost);
			return duti.doubleValue();
		} catch (Exception e) {
			Logger.error("****************************************************************");
			Logger.error("* Run Js Error !");
			Logger.error("* Rule: " + ruleValue);
			Logger.error("****************************************************************");
			Logger.error("runJS Exception Details", e);
			return null;
		}
	}

	@Override
	public Double getTotalWeight(List<CartItem> items) {
		return this.getTotalWeight(items, false);
	}

	/**
	 * 获取总重量
	 * 
	 * @author lijun
	 * @param items
	 * @param ship
	 *            是否是计算ship总量
	 * @return
	 */
	private Double getTotalWeight(List<CartItem> items,
			boolean isExcludeFreeshipingWeight) {
		if (items == null) {
			throw new NullPointerException("items is null");
		}
		if (items.size() == 0) {
			return 0.0;
		}
		LinkedList<String> listingIds = Lists.newLinkedList();
		FluentIterable.from(items).forEach(item -> {
			if (item instanceof BundleCartItem) {
				listingIds.addAll(((BundleCartItem) item).getAllListingId());
			} else {
				listingIds.add(item.getClistingid());
			}
		});

		List<Weight> weights = productService.getWeightList(listingIds);
		Map<String, Weight> weightMap = Maps.uniqueIndex(weights,
				e -> e.getListingId());
		// 看产品是否是免邮
		List<String> freeLabelList = Lists.newArrayList();
		if (isExcludeFreeshipingWeight) {
			freeLabelList = this.getFreeShipping(listingIds);
		}

		DoubleCalculateUtils dcu = new DoubleCalculateUtils(0);
		for (CartItem i : items) {
			if (freeLabelList == null
					|| !freeLabelList.contains(i.getClistingid())) {
				Double temp = weightMap.get(i.getClistingid()).getWeight()
						* i.getIqty();
				dcu = dcu.add(temp);
			}
		}
		return dcu.doubleValue();
	}

	@Override
	public Double getTotalShipWeight(List<CartItem> items) {
		return this.getTotalWeight(items, true);
	}

	/**
	 * 获取总重量
	 * 
	 * @author lijun
	 * @param items
	 * @param ship
	 *            是否是计算ship总量
	 * @return
	 */
	private Double getWeightV2(List<CartItem> items,
			boolean isExcludeFreeshipingWeight) {
		if (items == null) {
			throw new NullPointerException("items is null");
		}
		if (items.size() == 0) {
			return 0.0;
		}
		List<CartItem> allItems = Lists.newLinkedList();
		LinkedList<String> listingIds = Lists.newLinkedList();
		FluentIterable.from(items).forEach(
				item -> {
					if (item instanceof BundleCartItem) {
						listingIds.addAll(((BundleCartItem) item)
								.getAllListingId());
						allItems.addAll(((BundleCartItem) item).getAllItems());
					} else {
						listingIds.add(item.getClistingid());
						allItems.add(item);
					}
				});

		List<Weight> weights = productService.getWeightList(listingIds);
		Map<String, Weight> weightMap = Maps.uniqueIndex(weights,
				e -> e.getListingId());
		// 看产品是否是免邮
		List<String> freeLabelList = Lists.newArrayList();
		if (isExcludeFreeshipingWeight) {
			freeLabelList = this.getFreeShipping(listingIds);
		}

		DoubleCalculateUtils dcu = new DoubleCalculateUtils(0);
		for (CartItem i : allItems) {
			if (freeLabelList == null
					|| !freeLabelList.contains(i.getClistingid())) {
				Double temp = weightMap.get(i.getClistingid()).getWeight()
						* i.getIqty();
				dcu = dcu.add(temp);
			}
		}
		return dcu.doubleValue();
	}

	@Override
	public Double getTotalWeightV2(List<CartItem> items) {
		return getWeightV2(items, false);
	}

	@Override
	public Double getTotalShipWeightV2(List<CartItem> items) {
		return getWeightV2(items, true);
	}

	/**
	 * @author lijun
	 * @param weight
	 * @param shippingWeight
	 * @param shippingMethod
	 * @param country
	 * @param baseTotal
	 * @param currency
	 * @param websiteId
	 * @param listingIDs
	 * @return
	 */
	public Double getDoubleFreight(Double weight, Double shippingWeight,
			ShippingMethodDetail shippingMethod, Country country,
			double baseTotal, String currency, int websiteId,
			List<String> listingIDs) {
		boolean hasAllFreeShipping = this.hasAllFreeShipping(listingIDs);
		Double freight = this.getFinalFreight(shippingMethod, weight,
				shippingWeight, currency, baseTotal, hasAllFreeShipping);
		if (null == freight) {
			return null;
		}
		String shippingContext = shippingMethod.getCcontent();
		ShippingMethodInformation smi = new ShippingMethodInformation(
				shippingMethod, shippingContext, freight);
		ShippingMethodRequst requst = new ShippingMethodRequst(
				shippingMethod.getIstorageid(), country.getCshortname(),
				weight, shippingWeight, null, baseTotal, listingIDs,
				shippingMethod.getBisspecial(), currency, websiteId,
				hasAllFreeShipping);
		List<ShippingMethodInformation> smiList = Lists.newArrayList(smi);
		smiList = shippingMethodService.processingInPlugin(smiList, requst);
		return smiList.isEmpty() ? null : smiList.get(0).getFreight();
	}

	/**
	 * 所有免邮
	 * 
	 * @return
	 */
	private boolean hasAllFreeShipping(List<String> listingids) {
		// ~ 所有免邮
		List<String> allfp = productLabelService.getListByListingIdsAndType(
				listingids, ProductLabelType.AllFreeShipping.toString());
		return (allfp != null && allfp.size() > 0);
	}

}
