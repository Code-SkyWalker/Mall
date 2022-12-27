package com.skywalker.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Code SkyWalker
 * @Date 17:38 2022/12/27
 * @Classname MemberPrice
 * @Description TODO
 */
@Data
public class MemberPrice {
    private Long id;
    private String level;
    private BigDecimal price;
}
