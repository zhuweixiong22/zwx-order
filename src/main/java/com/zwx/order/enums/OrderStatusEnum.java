package com.zwx.order.enums;

import lombok.Getter;

/**
 * @author novo
 * @date 2022/3/23-20:14
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),

    FINISH(1,"完结"),

    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String dec;

    OrderStatusEnum(Integer code, String dec) {
        this.code = code;
        this.dec = dec;
    }
}
