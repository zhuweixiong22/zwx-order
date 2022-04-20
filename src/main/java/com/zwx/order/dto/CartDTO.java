package com.zwx.order.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author novo
 * @date 2022/4/20-20:21
 */
@Data
public class CartDTO {
    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
