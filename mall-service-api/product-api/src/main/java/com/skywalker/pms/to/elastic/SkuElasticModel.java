package com.skywalker.pms.to.elastic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 11:44 2023/1/11
 * @Classname Goods
 * @Description 商品上架 skuTo 对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuElasticModel implements Serializable {

    private Long skuId; // skuId

    private Long spuId; // spuId

    private String skuTitle; // sku标题

    private BigDecimal skuPrice; // sku价格

    private String skuImg; // sku 图片

    private Long saleCount; // 销量

    private Boolean hasStock; // 是否还有库存

    private Long hotScore; // 点击热度

    private Long categoryId; // 分类Id

    private String categoryName; // 分类名称

    private Long brandId; // 品牌Id

    private String brandName; // 品牌名称

    private String brandImg; // 品牌图片

    private List<Attr> attrs; // sku 属性值

    @Data
    public static class Attr implements Serializable {
        private Long attrId; // 属性Id

        private String attrName; // 属性名称

        private String attrValue; // 属性值
    }
}
