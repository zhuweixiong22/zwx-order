package com.zwx.order.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author novo
 * @date 2022/3/22-17:04
 */
@Getter
public enum ProductStatusEnum{
    ON_SALE(0, "在售"),

    OFF_SALE(1, "下架"),

    PRODUCT_NOT_EXIT(2, "商品不存在"),

    PRODUCT_STOCK_ERROR(3, "库存不足"),

    ;

    private Integer code;

    private String dec;

    ProductStatusEnum(Integer code, String dec) {
        this.code = code;
        this.dec = dec;
    }
}
