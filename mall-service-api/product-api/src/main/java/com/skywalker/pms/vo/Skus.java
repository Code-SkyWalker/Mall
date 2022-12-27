/**
  * Copyright 2022 json.cn 
  */
package com.skywalker.pms.vo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Skus {

    private List<AttrVo> attr;
    private String skuName;
    private BigDecimal price;
    private String skuTitle;
    private String skuSubtitle;
    private List<ImagesVo> images;
    private List<String> descar;
    private int fullCount;
    private BigDecimal discount; // 折扣
    private int countStatus;
    private BigDecimal fullPrice; // 满减满多少
    private BigDecimal reducePrice; // 满减减多少
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}