package com.tomtop.services.impl.product.price;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.tomtop.dto.Currency;
import com.tomtop.dto.product.ProductBase;
import com.tomtop.mappers.product.ProductBaseMapper;
import com.tomtop.services.ICurrencyService;
import com.tomtop.valueobjects.product.price.Price;
import com.tomtop.valueobjects.product.price.PriceBuilder;
import com.tomtop.valueobjects.product.price.PriceCalculationContext;
import com.tomtop.valueobjects.product.spec.IProductSpec;

@Service
public class BasePriceCalculator {
	
	private static final Logger Logger = LoggerFactory.getLogger(BasePriceCalculator.class);
	
	@Autowired
	ProductBaseMapper productMapper;

	@Autowired
	ICurrencyService currencyService;

	public List<Price> getPrice(final List<IProductSpec> items,
			final PriceCalculationContext ctx) {
		if (items != null && items.size() > 0) {
			List<String> listingIDs = Lists.newArrayList(Sets.newHashSet(Lists
					.transform(items, i -> i.getListingID())));
			Logger.trace("Getting Basic Prices for Listings: {}", listingIDs);
			int storageId = ctx.getStorageId();
			List<ProductBase> productsWithPriceOnly = productMapper
					.getBasePriceForMultiStorage(listingIDs,storageId);
			final Map<String, ProductBase> productIndex = Maps.uniqueIndex(
					productsWithPriceOnly, p -> p.getClistingid());
			List<Price> relist = Lists
					.transform(
							items,
							i -> {
								ProductBase p = productIndex.get(i
										.getListingID());
								Currency ccy = currencyService
										.getCurrencyByCode(ctx.getCurrency());
								if (p != null) {
									double cost = p.getFprice();
									if (p.getFcostprice() != null) {
										cost = p.getFcostprice();
									} else {
										Logger.warn(
												"Listing {}: Unit Cost not set, setting cost to base price",
												i.getListingID());
									}
									return PriceBuilder
											.build(i, p.getFprice(), cost)
											.inCurrency(
													ctx.getCurrency(),
													ccy.getCsymbol(),
													currencyService.getRate(ctx
															.getCurrency()))
											.get();

								}
								return null;
							});
			relist.remove(null);
			return relist;
		}
		return Lists.newArrayList();
	}
}
