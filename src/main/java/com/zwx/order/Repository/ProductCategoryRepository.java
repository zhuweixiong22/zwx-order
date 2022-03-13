package com.zwx.order.Repository;

import com.zwx.order.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author novo
 * @date 2022/3/13-21:53
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

}
