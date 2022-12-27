package com.skywalker.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuCouponTo {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount; // 折扣
    private int countStatus;
    private BigDecimal fullPrice; // 满减满多少
    private BigDecimal reducePrice; // 满减减多少
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}
