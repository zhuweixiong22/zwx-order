package com.zwx.order.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author novo
 * @date 2022/3/13-21:50
 */
@Entity
@DynamicUpdate //时间动态更新 如果pojo类有时间属性，避免查询对象后再更新时间updateTime不会同步更新，因为查询出来的对象本来就有updateTime
@Data
public class ProductCategory {
    @Id
    // SpringBoot2.x版本要添加strategy参数
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
    //private Date createTime;

    //private Date updateTime;
}
