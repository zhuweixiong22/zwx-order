package com.zwx.order.repository;


import com.zwx.order.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author novo
 * @date 2022/3/26-21:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Resource
    private OrderMasterRepository repository;

    private final String OPENID = "222222";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1232317");
        orderMaster.setBuyerName("test3");
        orderMaster.setBuyerPhone("11211211211");
        orderMaster.setBuyerAddress("江门市");
        orderMaster.setBuyerOpenid("222222");
        orderMaster.setOrderAmount(BigDecimal.valueOf(1.5));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {
        // 分页对象从第0页开始
        PageRequest pageRequest = PageRequest.of(1,5);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(result.getContent());
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}
