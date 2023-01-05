package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.skywalker.pms.service.PmsProductAttrValueService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsProductAttrValue")
public class PmsProductAttrValueController {

    @Autowired
    private PmsProductAttrValueService pmsProductAttrValueService;

    @GetMapping("/base/listForSpu/{spuId}")
    public Result findBaseAttr(@PathVariable(name = "spuId") Long spuId) {
        return Result.ok(this.pmsProductAttrValueService.findBaseAttrBySpuId(spuId));
    }

    @PostMapping("/update/{spuId}")
    public Result updateProductAttrBySpuId(@PathVariable(name = "spuId") Long spuId, @RequestBody List<PmsProductAttrValue> list) {
        this.pmsProductAttrValueService.update(list, spuId);
        return Result.ok();
    }
}
