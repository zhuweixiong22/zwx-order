package com.zwx.order.service.impl;

import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.pojo.ProductInfo;
import com.zwx.order.repository.ProductInfoRepository;
import com.zwx.order.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author novo
 * @date 2022/3/22-17:01
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).orElse(null);
    }

    /**
     * 因为是微信小程序客户端的查询，一般不分页
     * @return
     */
    @Override
    public List<ProductInfo> findOnSaleAll() {
        return repository.findByProductStatus(ProductStatusEnum.ON_SALE.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
