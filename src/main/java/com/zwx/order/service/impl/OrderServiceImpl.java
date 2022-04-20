package com.zwx.order.service.impl;

import com.zwx.order.dto.CartDTO;
import com.zwx.order.dto.OrderDTO;
import com.zwx.order.enums.ProductStatusEnum;
import com.zwx.order.exception.SellException;
import com.zwx.order.pojo.OrderDetail;
import com.zwx.order.pojo.OrderMaster;
import com.zwx.order.pojo.ProductInfo;
import com.zwx.order.repository.OrderDetailRepository;
import com.zwx.order.repository.OrderMasterRepository;
import com.zwx.order.service.OrderService;
import com.zwx.order.service.ProductService;
import com.zwx.order.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author novo
 * @date 2022/4/20-19:34
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ProductService productService;

    @Resource
    private OrderDetailRepository orderDetailRepository;

    @Resource
    private OrderMasterRepository orderMasterRepository;

    /**
     * 注意订单价格不能由前端传过来，必要要查数据库拿到信息
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1. 查询商品 （数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findById(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductStatusEnum.PRODUCT_NOT_EXIT);
            }
            //2. 计算总价 注意BigDecimal的运算
            orderAmount = productInfo.getProductPrice()
                    .multiply(BigDecimal.valueOf(orderDetail.getProductQuantity()))
                    .add(orderAmount); // 叠加
            // 订单详情入库 前端只传了detail的orderId和数量
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        //3. mater订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster); // 注意如果相同属性的值为null也会被拷贝，所以要注意先拷贝，后set其他属性
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        //4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(orderDetail -> new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity())) // map return一个cart
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
