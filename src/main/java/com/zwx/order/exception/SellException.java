package com.zwx.order.exception;

import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.enums.ResultEnum;
import lombok.Getter;

/**
 * @author novo
 * @date 2022/4/20-19:39
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;


    public SellException(ProductStatusEnum productStatusEnum) {
        super(productStatusEnum.getDec());
        this.code = productStatusEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
