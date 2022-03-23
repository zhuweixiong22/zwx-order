package com.zwx.order.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author novo
 * @date 2022/3/23-20:22
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;

    private String orderId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

}
