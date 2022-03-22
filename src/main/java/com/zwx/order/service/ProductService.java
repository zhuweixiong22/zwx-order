package com.zwx.order.service;

import com.zwx.order.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author novo
 * @date 2022/3/22-16:57
 */
public interface ProductService {
    ProductInfo findById(String productId);

    /**
     * 客户端查询所有在架商品
     * @return
     */
    List<ProductInfo> findOnSaleAll();

    /**
     * 管理端分页查询所有商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
}
