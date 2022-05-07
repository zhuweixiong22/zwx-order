package com.zwx.order.exception;

import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.enums.ResultEnum;
import com.zwx.order.vo.ResultVo;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author novo
 * @date 2022/4/20-19:43
 */
@ControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ResultVo sellExceptionHandle(SellException e) {
        return ResultVo.error(e.getCode(), e.getMessage());
    }

    /**
     * 接口具体是抛出 MethodArgumentNotValidException 异常还是抛出 BindException 异常，取决于 @RequestBody，或者说是取决于对请求参数的解析方式。
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVo methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
        //getDefaultMessage()获取到的是@NotBlank的message值
        BindingResult bindingResult = e.getBindingResult();
        return ResultVo.error(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultVo bindingExceptionHandle(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResultVo.error(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }
}
