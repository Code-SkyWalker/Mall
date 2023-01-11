package com.skywalker.wms.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author Code SkyWalker
 * @Date 15:48 2023/1/11
 * @Classname HasStockVo
 * @Description 远程查询 商品是否含有库存
 */
@Data
public class HasStockVo implements Serializable {
    @Column(name = "skuId")
    private Long skuId; // skuId

    @Column(name = "hasStock")
    private Boolean hasStock; // 是否含有库存
}
