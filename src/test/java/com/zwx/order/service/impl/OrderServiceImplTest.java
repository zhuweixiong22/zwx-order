package com.zwx.order.service.impl;


import com.zwx.order.dto.OrderDTO;
import com.zwx.order.pojo.OrderDetail;
import com.zwx.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}
