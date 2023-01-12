package com.skywalker.elasticserch.controller;

import com.skywalker.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Code SkyWalker
 * @Date 8:59 2023/1/12
 * @Classname elasticsearchController
 * @Description TODO
 */
@RestController
@RequestMapping("/elastic")
public class elasticsearchController {

    @PostMapping("/push")
    public Result push() {
        return null;
    }
}
