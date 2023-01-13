package com.skywalker.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 16:21 2023/1/13
 * @Classname Goods
 * @Description TODO
 */
@Document(indexName = "goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    @Id
    private Long skuId; // 商品Id

    @Field(type = FieldType.Keyword, index = false)
    private String pic; // 商品默认图片

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; // 商品标题

    @Field(type = FieldType.Double)
    private String price; // 商品价格

    @Field(type = FieldType.Long)
    private Long sale; // 商品销量

    @Field(type = FieldType.Boolean)
    private Boolean store; // 商品是否有存货

    @Field(type = FieldType.Date)
    private LocalDateTime createTime; // 商品创建时间(是否是新商品)

    @Field(type = FieldType.Long)
    private Long brandId; // 商品所属品牌id

    @Field(type = FieldType.Keyword)
    private String brandName; // 商品所属品牌名称

    @Field(type = FieldType.Long)
    private Long categoryId; // 商品所属分类id

    @Field(type = FieldType.Keyword)
    private Long categoryName; // 商品所属分类名称

    @Field(type = FieldType.Nested)
    private List<SearchAttrValue> attrs; // 商品基本属性

    @Data
    public static class SearchAttrValue {

        @Field(type = FieldType.Long)
        private Long attrId;

        @Field(type = FieldType.Keyword)
        private String attrName;

        @Field(type = FieldType.Keyword)
        private String attrValue;
    }
}
