package com.zwx.order.dto;

import com.zwx.order.enums.OrderStatusEnum;
import com.zwx.order.enums.PayStatusEnum;
import com.zwx.order.pojo.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * OrderDTO 比 OrderMaster 多了 List<OrderDetail>, 方便传输
 * @author novo
 * @date 2022/4/20-19:24
 */
@Data
public class OrderDTO {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 订单状态 默认0-新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态 默认0-未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 订单需要根据时间排序 */
    private Date createTime;

    private Date updateTime;

    /** 所有子订单 */
    private List<OrderDetail> orderDetailList;
}
