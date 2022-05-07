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

    ORDER_NOT_EXIST(11, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(12, "订单详情不存在"),

    ORDER_STATUS_ERROR(13, "订单状态不正确"),

    ORDER_UPDATE_FAIL(14, "订单状态修改失败"),

    ORDER_DETAIL_EMPTY(15, "订单中无商品详情"),

    ORDER_PAY_STATUS_ERROR(16, "支付状态异常"),

    ;

    Integer code;

    String desc;

    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
