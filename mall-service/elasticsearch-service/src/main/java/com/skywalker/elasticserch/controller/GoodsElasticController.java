package com.skywalker.elasticserch.controller;

import com.skywalker.elasticsearch.pojo.Goods;
import com.skywalker.elasticserch.dao.GoodsRepository;
import com.skywalker.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 8:59 2023/1/12
 * @Classname elasticsearchController
 * @Description TODO
 */
@RestController
@RequestMapping("/elastic/goods")
public class GoodsElasticController {

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping("/pushAll")
    public Result pushAll(@RequestBody List<Goods> goods) {
        goodsRepository.saveAll(goods);
        return Result.ok();
    }

    @PostMapping("/push")
    public Result push(@RequestBody Goods goods) {
        goodsRepository.save(goods);
        return Result.ok();
    }


}
