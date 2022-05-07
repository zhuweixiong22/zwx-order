package com.zwx.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zwx.order.dto.OrderDTO;
import com.zwx.order.enums.ResultEnum;
import com.zwx.order.exception.SellException;
import com.zwx.order.form.OrderForm;
import com.zwx.order.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.description.method.MethodDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @date 2022-05-07 11:03
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        // 因为字段名不一致，所以不能用BeanUtil
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        // String 转成json格式
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
