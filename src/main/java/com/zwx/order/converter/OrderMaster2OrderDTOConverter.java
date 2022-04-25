package com.zwx.order.converter;

import com.zwx.order.dto.OrderDTO;
import com.zwx.order.pojo.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 写成转换器 代码复用
 * @author zwx
 * @date 2022/4/25-20:25
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream()
                .map(orderMaster -> convert(orderMaster))
                .collect(Collectors.toList());
    }
}
