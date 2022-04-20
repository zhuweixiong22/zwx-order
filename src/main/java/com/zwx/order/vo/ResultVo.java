package com.zwx.order.vo;

import com.zwx.order.enums.ResultEnum;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author novo
 * @date 2022/3/22-17:44
 */
@Data
public class ResultVo<T> {
    private Integer code;

    private String msg;

    private T data;

    public ResultVo(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResultVo<T> success(T data) {
        return new ResultVo<>(ResultEnum.SUCCESS.getCode(),data);
    }

    public static <T> ResultVo<T> error(ResultEnum resultEnum) {
        return new ResultVo<>(resultEnum.getCode(), resultEnum.getDesc());
    }

    public static <T> ResultVo<T> error(Integer code, String desc) {
        return new ResultVo<>(code, desc);
    }
}
