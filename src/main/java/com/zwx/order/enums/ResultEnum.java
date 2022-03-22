package com.zwx.order.enums;

import lombok.Getter;

/**
 * @author novo
 * @date 2022/3/22-20:45
 */
@Getter
public enum  ResultEnum {
    ERROR(-1, "服务端异常"),

    SUCCESS(0, "成功"),

    ;

    Integer code;

    String desc;

    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
