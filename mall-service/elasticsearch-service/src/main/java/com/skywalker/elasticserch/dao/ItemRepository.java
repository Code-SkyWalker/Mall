package com.skywalker.elasticserch.dao;

import com.skywalker.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author Code SkyWalker
 * @Date 8:53 2023/1/13
 * @Classname UserRepository
 * @Description TODO
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

}
