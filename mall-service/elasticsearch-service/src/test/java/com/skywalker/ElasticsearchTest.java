package com.skywalker;

//import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.SearchResponse;
//import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.skywalker.elasticsearch.pojo.Item;
import com.skywalker.elasticserch.SearchApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;


/**
 * @Author Code SkyWalker
 * @Date 16:43 2023/1/10
 * @Classname ElasticsearchTest
 * @Description TODO
 */
@SpringBootTest(classes = {SearchApplication.class})
public class ElasticsearchTest {

    @Autowired
    ElasticsearchClient ElasticsearchClient;

    /**
     * 使用spring-data-elasticsearch 创建索引
     */
    @Test
    public void createIndex() {
        System.out.println("ElasticsearchClient = " + ElasticsearchClient);
    }
}
