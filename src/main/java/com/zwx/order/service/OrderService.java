package com.zwx.order.service;

import com.zwx.order.dto.OrderDTO;
import com.zwx.order.pojo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**
 * @author novo
 * @date 2022/4/20-19:21
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 根据主订单id查询详情
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 根据买家id查询所有订单
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);
}
