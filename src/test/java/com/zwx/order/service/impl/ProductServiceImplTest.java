package com.zwx.order.service.impl;


import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author novo
 * @date 2022/3/22-17:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceImplTest {
    @Resource
    private ProductServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("123456");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findOnSaleAll() {
        List<ProductInfo> productInfoList = productService.findOnSaleAll();
        System.out.println(productInfoList);
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        // page 第几页 size 每一页条数
        PageRequest request = PageRequest.of(0,5);
        Page<ProductInfo> productInfoList = productService.findAll(request);
        System.out.println(productInfoList.getContent());
        System.out.println(productInfoList.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123461");
        productInfo.setProductName("雪碧");
        // TODO 注意BigDecimal的精度问题 要用new BigDecimal("3.2")字符串构造器或BigDecimal.valueOf(3.2) 不要使用接收double的构造器
        productInfo.setProductPrice(BigDecimal.valueOf(1.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("so good");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.OFF_SALE.getCode());
        productInfo.setCategoryType(11);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}
