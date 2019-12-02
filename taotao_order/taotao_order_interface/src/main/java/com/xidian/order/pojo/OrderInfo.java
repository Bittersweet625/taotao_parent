package com.xidian.order.pojo;

import java.io.Serializable;
import java.util.List;

import com.xidian.pojo.TbOrder;
import com.xidian.pojo.TbOrderItem;
import com.xidian.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder implements Serializable{
	
	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	

}
