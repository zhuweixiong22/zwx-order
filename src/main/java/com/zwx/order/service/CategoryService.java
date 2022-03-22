package com.zwx.order.service;

import com.zwx.order.pojo.ProductCategory;

import java.util.List;
import java.util.Set;

/**
 * @author novo
 * @date 2022/3/14-23:26
 */
public interface CategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(Set<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
