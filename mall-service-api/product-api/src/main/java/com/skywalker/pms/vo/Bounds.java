package com.skywalker.pms.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bounds {

    private BigDecimal buyBounds;  // 购买积分
    private BigDecimal growBounds; // 成长积分

}