package com.zwx.order.repository;


import com.zwx.order.pojo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author novo
 * @date 2022/3/26-21:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Resource
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("1232317");
        orderDetail.setDetailId("1234568");
        orderDetail.setProductName("雪碧");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("66");
        orderDetail.setProductPrice(BigDecimal.valueOf(3.4));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("1232317");
        Assert.assertNotEquals(0,result.size());
    }
}
