package com.skywalker.elasticsearch.feign;

import com.skywalker.elasticsearch.to.SkuElasticModel;
import com.skywalker.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 16:47 2023/1/13
 * @Classname GoodsFeign
 * @Description TODO
 */
@FeignClient(name="elastic-service", contextId = "pmsAttr", path = "/elastic/goods")
public interface GoodsFeign {
    @PostMapping("/pushAll")
    Result pushAll(@RequestBody List<SkuElasticModel> goods);

    @PostMapping("/push")
    Result push(@RequestBody SkuElasticModel goods);
}
