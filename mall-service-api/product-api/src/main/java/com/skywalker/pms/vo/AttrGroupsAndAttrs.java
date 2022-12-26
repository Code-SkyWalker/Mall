package com.skywalker.pms.vo;

import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrGroup;
import lombok.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Date 14:48 2022/12/26
 * @Classname AttrGroupsAndAttrs
 * @Description TODO
 */
@Getter
@Setter
@NoArgsConstructor
public class AttrGroupsAndAttrs extends PmsAttrGroup {

    private List<PmsAttr> attrs;
}
