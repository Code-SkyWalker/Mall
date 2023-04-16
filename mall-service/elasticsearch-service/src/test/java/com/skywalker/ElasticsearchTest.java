package com.skywalker;

import com.skywalker.elasticsearch.pojo.Item;
import com.skywalker.elasticserch.SearchApplication;
import com.skywalker.elasticserch.dao.ItemRepository;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author Code SkyWalker
 * @Date 16:43 2023/1/10
 * @Classname ElasticsearchTest
 * @Description TODO
 */
@SpringBootTest(classes = {SearchApplication.class})
public class ElasticsearchTest {

    @Autowired
    ItemRepository itemRepository;

    /**
     * 使用spring-data-elasticsearch 创建索引
     */
    @Test
    public void esClientTest() {
        Item item = new Item();
        item.setId(2L);
        item.setPrice(0.2);
        item.setCategory("category2");
        item.setImages("http://localhost:8080/list2");
        item.setBrand("brand2");
        item.setTitle("title2");
        itemRepository.save(item);
    }

    @Test
    public void esRestClientTest() {
    }


}
