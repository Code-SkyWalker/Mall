package com.skywalker.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author Code SkyWalker
 * @Date 11:29 2023/1/12
 * @Classname Item
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item")
public class Item {

    @Id
    private Long id;

    @Field(name = "title", type = FieldType.Text)
    private String title; //标题

    @Field(value = "category", type = FieldType.Keyword, index = false)
    private String category;// 分类

    @Field(value = "brand", type = FieldType.Keyword, index = false)
    private String brand; // 品牌

    @Field(value = "price", type = FieldType.Double)
    private Double price; // 价格

    @Field(value = "images", type = FieldType.Keyword, index = false)
    private String images; // 图片地址
}
