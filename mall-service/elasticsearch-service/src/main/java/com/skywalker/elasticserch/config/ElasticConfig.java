package com.skywalker.elasticserch.config;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Code SkyWalker
 * @Date 16:23 2023/1/10
 * @Classname ElasticConfig
 * @Description TODO
 */
@Configuration
@PropertySource(value = {"classpath:params.properties"})
public class ElasticConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    private RestClient restClient() {
        // Create the low-level client
        return RestClient.builder(
                new HttpHost(host, port)).build();
    }

    private ElasticsearchTransport transport() {
        // Create the transport with a Jackson mapper
        return new RestClientTransport(
                restClient(), new JacksonJsonpMapper());
    }

    /**
     * 同步阻塞 客户端
     * @return ElasticsearchClient
     */
    @Bean
    public ElasticsearchClient syncClient() {
        // And create the API client
        return new ElasticsearchClient(transport());
    }

    /**
     * 异步非阻塞 客户端
     * @return ElasticsearchAsyncClient
     */
    @Bean
    public ElasticsearchAsyncClient asyncClient() {
        return new ElasticsearchAsyncClient(transport());
    }
}
