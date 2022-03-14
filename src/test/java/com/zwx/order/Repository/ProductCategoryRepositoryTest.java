package com.zwx.order.Repository;

import com.zwx.order.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

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
        ProductCategory productCategory = repository.findById(1).orElse(null);
        productCategory.setCategoryName("畅销bang");
        repository.save(productCategory);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("kk",66);
        productCategory.setCategoryName("hhh");
        productCategory.setCategoryType(11);
        ProductCategory res = repository.save(productCategory);
        Assert.assertNotNull(res);
    }
    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory("kk",66);
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findAll() {
        List<Integer> list = Arrays.asList(2,3,10);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result);
    }
}
