package com.skywalker.elasticserch.dao;

import com.skywalker.elasticsearch.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author Code SkyWalker
 * @Date 16:36 2023/1/13
 * @Classname GoodsRepository
 * @Description TODO
 */

public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {

}
