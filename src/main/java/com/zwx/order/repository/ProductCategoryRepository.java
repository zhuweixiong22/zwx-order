package com.zwx.order.repository;

import com.zwx.order.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author novo
 * @date 2022/3/13-21:53
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    // 使用jpa 需要无参的构造方法
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
