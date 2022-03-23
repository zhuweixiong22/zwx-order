package com.zwx.order.pojo;

import com.zwx.order.enums.OrderStatusEnum;
import com.zwx.order.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author novo
 * @date 2022/3/23-20:10
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {
    @Id
    private String id;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /**订单状态 默认0-新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**支付状态 默认0-未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**订单需要根据时间排序*/
    private Date createTime;

    private Date updateTime;
}
