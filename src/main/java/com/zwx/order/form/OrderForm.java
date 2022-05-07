package com.zwx.order.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zwx
 * @date 2022-05-07 10:32
 */
@Data
public class OrderForm {

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotBlank(message = "openid不能为空")
    private String openid;

    @NotBlank(message = "购物车不能为空")
    private String items;
}
