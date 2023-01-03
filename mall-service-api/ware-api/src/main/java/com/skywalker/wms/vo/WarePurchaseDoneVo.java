package com.skywalker.wms.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 15:56 2023/1/3
 * @Classname WarePurchaseDoneVo
 * @Description 采购单完成Vo
 */
@Data
@Builder
public class WarePurchaseDoneVo {
    private Long purchaseId;

    private List<PurchaseDetail> purchaseDetails;
}
