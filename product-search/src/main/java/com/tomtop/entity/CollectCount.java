package com.tomtop.entity;

/**
 * 收藏数
 * 
 *
 */
public class CollectCount extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String listingId;
	private Integer collectCount;
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	public Integer getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
}