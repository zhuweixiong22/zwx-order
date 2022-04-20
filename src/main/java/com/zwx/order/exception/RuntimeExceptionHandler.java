package com.zwx.order.exception;

import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.vo.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author novo
 * @date 2022/4/20-19:43
 */
public class RuntimeExceptionHandler {
    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ResultVo sellExceptionHandle(SellException e) {
        return ResultVo.error(e.getCode(), e.getMessage());
    }
}
