package com.zwx.order.service.impl;


import com.zwx.order.dto.OrderDTO;
import com.zwx.order.enums.OrderStatusEnum;
import com.zwx.order.enums.PayStatusEnum;
import com.zwx.order.pojo.OrderDetail;
import com.zwx.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author novo
 * @date 2022/4/20-20:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1650465493176110490";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("北京");
        orderDTO.setBuyerName("zwx");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("1111111111");
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123460");
        orderDetail1.setProductQuantity(30);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123458");
        orderDetail2.setProductQuantity(24);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> result = orderService.findList(BUYER_OPENID, request);
        log.info("【查询订单列表】result={}",result.getContent());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}
