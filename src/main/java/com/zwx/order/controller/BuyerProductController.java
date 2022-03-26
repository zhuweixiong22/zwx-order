package com.zwx.order.controller;

import com.zwx.order.pojo.ProductCategory;
import com.zwx.order.pojo.ProductInfo;
import com.zwx.order.service.CategoryService;
import com.zwx.order.service.ProductService;
import com.zwx.order.vo.ProductInfoVo;
import com.zwx.order.vo.ProductVo;
import com.zwx.order.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author novo
 * @date 2022/3/22-17:40
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Resource
    private ProductService productService;

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {
        //1. 查询所有在售的商品
        List<ProductInfo> productInfoList = productService.findOnSaleAll();

        //2. 查询类目（一次查询）
        Set<Integer> categoryTypeSet = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toSet());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeSet);

        //3. 数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            // productVo为一个类目下所有的信息包含商品
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            // productInfoList 为foods相同类目那一层
            for (ProductInfo productInfo : productInfoList) {
                // 类目相等的放入同一个productInfoVoList
                if (productInfo.getCategoryType().equals(productVo.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVo.success(productVoList);
    }


}
