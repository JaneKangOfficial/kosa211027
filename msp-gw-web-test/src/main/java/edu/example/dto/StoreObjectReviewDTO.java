package edu.example.dto;

public class StoreObjectReviewDTO {
	
	String storeName;
	String objectName;
	String deliveryStatus;
	String pickupStatus;
	String leastPrice;
	String deliveryPrice;
	String StoreCategoryNum;
	String reviewScore;
	String orderNum;
	@Override
	public String toString() {
		return "StoreObjectReviewDTO [storeName=" + storeName + ", objectName=" + objectName + ", deliveryStatus="
				+ deliveryStatus + ", pickupStatus=" + pickupStatus + ", leastPrice=" + leastPrice + ", deliveryPrice="
				+ deliveryPrice + ", StoreCategoryNum=" + StoreCategoryNum + ", reviewScore=" + reviewScore
				+ ", orderNum=" + orderNum + "]";
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getPickupStatus() {
		return pickupStatus;
	}
	public void setPickupStatus(String pickupStatus) {
		this.pickupStatus = pickupStatus;
	}
	public String getLeastPrice() {
		return leastPrice;
	}
	public void setLeastPrice(String leastPrice) {
		this.leastPrice = leastPrice;
	}
	public String getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(String deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public String getStoreCategoryNum() {
		return StoreCategoryNum;
	}
	public void setStoreCategoryNum(String storeCategoryNum) {
		StoreCategoryNum = storeCategoryNum;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
}
