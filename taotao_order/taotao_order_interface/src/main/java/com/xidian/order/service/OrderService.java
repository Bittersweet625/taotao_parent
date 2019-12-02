package com.xidian.order.service;


import com.xidian.common.pojo.TaotaoResult;
import com.xidian.order.pojo.OrderInfo;

public interface OrderService {

	TaotaoResult createOrder(OrderInfo orderInfo);
}
