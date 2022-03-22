package com.zwx.order.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品（包含类目）
 * @author novo
 * @date 2022/3/22-17:49
 */
@Data
public class ProductVo {

    @JsonProperty("name")//对象序列化时返回名字name，但是后台为了辨识name 要改名
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
