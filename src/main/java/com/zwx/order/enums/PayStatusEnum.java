package com.zwx.order.enums;

import lombok.Getter;

/**
 * @author novo
 * @date 2022/3/23-20:17
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),

    PAY_SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String dec;

    PayStatusEnum(Integer code, String dec) {
        this.code = code;
        this.dec = dec;
    }
}
