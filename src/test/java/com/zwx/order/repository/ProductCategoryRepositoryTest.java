package com.zwx.order.repository;

import com.zwx.order.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author novo
 * @date 2022/3/13-21:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    // 使用hibernate需要一个没有参数的构造方法 否则会报错
    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(4).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("kk",88);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);
    }
    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory("kk",66);
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("最爱");
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    @Test
    public void findAll() {
        Set<Integer> set = new HashSet<>(Arrays.asList(11,66,7));
        List<ProductCategory> result = repository.findByCategoryTypeIn(set);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result);
    }
}
