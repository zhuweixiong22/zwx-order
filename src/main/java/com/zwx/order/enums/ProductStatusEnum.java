package com.zwx.order.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author novo
 * @date 2022/3/22-17:04
 */
@Getter
public enum ProductStatusEnum {
    ON_SALE(0, "在售"),

    OFF_SALE(1, "下架")

    ;

    private Integer code;

    private String dec;

    ProductStatusEnum(Integer code, String dec) {
        this.code = code;
        this.dec = dec;
    }
}
