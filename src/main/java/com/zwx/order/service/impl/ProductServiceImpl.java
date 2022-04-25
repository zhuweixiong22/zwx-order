package com.zwx.order.service.impl;

import com.zwx.order.dto.CartDTO;
import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.exception.SellException;
import com.zwx.order.pojo.ProductInfo;
import com.zwx.order.repository.ProductInfoRepository;
import com.zwx.order.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = this.findById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductStatusEnum.PRODUCT_NOT_EXIT);
            }
            productInfo.setProductStock(productInfo.getProductStock() + cartDTO.getProductQuantity());
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    // TODO 超卖问题 使用redis的锁机制
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = this.findById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductStatusEnum.PRODUCT_NOT_EXIT);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ProductStatusEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
