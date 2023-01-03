package com.skywalker.wms.vo;

import lombok.Data;

/**
 * @Author Code SkyWalker
 * @Date 15:57 2023/1/3
 * @Classname PurchaseDetail
 * @Description TODO
 */

@Data
public class PurchaseDetail {

    private Long PurchaseDetailId;      // 需求Id
    private Integer status;             // 需求状态
    private String reason;              // 原因(失败)
}
