package com.zwx.order.controller;

import com.zwx.order.converter.OrderForm2OrderDTOConverter;
import com.zwx.order.dto.OrderDTO;
import com.zwx.order.enums.ResultEnum;
import com.zwx.order.exception.SellException;
import com.zwx.order.form.OrderForm;
import com.zwx.order.service.OrderService;
import com.zwx.order.vo.ResultVo;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zwx
 * @date 2022-05-07 10:26
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Resource
    private OrderService orderService;
    // 创建订单
    @PostMapping("/create")
    // 前端如果不用json @Valid + 全局异常会捕获不到 要自己写BindingResult
    public ResultVo<Map<String, String>>  create(@Valid OrderForm orderForm){
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVo.success(map);
    }
    // 订单列表
    // 订单详情
    // 取消订单

}
