package com.zwx.order.service.impl;

import com.zwx.order.pojo.ProductCategory;
import com.zwx.order.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author novo
 * @date 2022/3/22-15:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceImplTest {
    @Resource
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findById(4);
        Assert.assertEquals(new Integer(4),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        Set<Integer> set = new HashSet<>(Arrays.asList(11, 66, 67));
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(set);
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("测试类目", 69);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}
