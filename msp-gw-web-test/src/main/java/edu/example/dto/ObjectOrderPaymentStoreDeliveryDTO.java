package edu.example.dto;

public class ObjectOrderPaymentStoreDeliveryDTO {
	
	// payment
	String orderNum;
	String orderTime;
	String paymentCategory;
	String storeRequest;
	Integer orderTotalPrice;
	String memberNum;
	String orderStatus;
	String deliveryRequest;
	String progressStatus;
	
	// orderlist
	String objectNum;
	String memberId;
	Integer buyQty;
	
	// object
	String objectImage;
	String objectName;
	String objectContent;
	Integer objectPrice;
	Integer objectQty;
	String objectOrigin;
	String storeNum;
	String menuCategoryNum;
	
	// store
	String storeName;
	
	// delivery
	String deliveryNum;

	@Override
	public String toString() {
		return "ObjectOrderPaymentStoreDeliveryDTO [orderNum=" + orderNum + ", orderTime=" + orderTime
				+ ", paymentCategory=" + paymentCategory + ", storeRequest=" + storeRequest + ", orderTotalPrice="
				+ orderTotalPrice + ", memberNum=" + memberNum + ", orderStatus=" + orderStatus + ", deliveryRequest="
				+ deliveryRequest + ", progressStatus=" + progressStatus + ", objectNum=" + objectNum + ", memberId="
				+ memberId + ", buyQty=" + buyQty + ", objectImage=" + objectImage + ", objectName=" + objectName
				+ ", objectContent=" + objectContent + ", objectPrice=" + objectPrice + ", objectQty=" + objectQty
				+ ", objectOrigin=" + objectOrigin + ", storeNum=" + storeNum + ", menuCategoryNum=" + menuCategoryNum
				+ ", storeName=" + storeName + ", deliveryNum=" + deliveryNum + "]";
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPaymentCategory() {
		return paymentCategory;
	}

	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}

	public String getStoreRequest() {
		return storeRequest;
	}

	public void setStoreRequest(String storeRequest) {
		this.storeRequest = storeRequest;
	}

	public Integer getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Integer orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getDeliveryRequest() {
		return deliveryRequest;
	}

	public void setDeliveryRequest(String deliveryRequest) {
		this.deliveryRequest = deliveryRequest;
	}

	public String getProgressStatus() {
		return progressStatus;
	}

	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}

	public String getObjectNum() {
		return objectNum;
	}

	public void setObjectNum(String objectNum) {
		this.objectNum = objectNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getBuyQty() {
		return buyQty;
	}

	public void setBuyQty(Integer buyQty) {
		this.buyQty = buyQty;
	}

	public String getObjectImage() {
		return objectImage;
	}

	public void setObjectImage(String objectImage) {
		this.objectImage = objectImage;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectContent() {
		return objectContent;
	}

	public void setObjectContent(String objectContent) {
		this.objectContent = objectContent;
	}

	public Integer getObjectPrice() {
		return objectPrice;
	}

	public void setObjectPrice(Integer objectPrice) {
		this.objectPrice = objectPrice;
	}

	public Integer getObjectQty() {
		return objectQty;
	}

	public void setObjectQty(Integer objectQty) {
		this.objectQty = objectQty;
	}

	public String getObjectOrigin() {
		return objectOrigin;
	}

	public void setObjectOrigin(String objectOrigin) {
		this.objectOrigin = objectOrigin;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getMenuCategoryNum() {
		return menuCategoryNum;
	}

	public void setMenuCategoryNum(String menuCategoryNum) {
		this.menuCategoryNum = menuCategoryNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	
}
