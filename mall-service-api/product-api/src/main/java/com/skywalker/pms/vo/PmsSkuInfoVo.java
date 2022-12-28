package com.skywalker.pms.vo;

import com.skywalker.pms.pojo.PmsSkuInfo;
import lombok.Data;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 14:04 2022/12/28
 * @Classname PmsSkuInfoVo
 * @Description TODO
 */
@Data
public class PmsSkuInfoVo extends PmsSkuInfo {

    private List<Integer> priceRange;
}
