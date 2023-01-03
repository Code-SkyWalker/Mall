package com.skywalker.wms.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 8:56 2023/1/3
 * @Classname WarePurchaseMergeVo
 * @Description 采购单合并 vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarePurchaseMergeVo {

    List<Long> items; // 采购需求id
    Long purchaseId; // 采购单id
}
