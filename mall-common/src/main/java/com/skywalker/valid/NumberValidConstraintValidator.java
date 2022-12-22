package com.skywalker.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Code SkyWalker
 * @Date 15:12 2022/12/14
 * @Classname ConstraintValidatorImpl
 * @Description TODO
 */
public class NumberValidConstraintValidator implements ConstraintValidator<NumberValid, Integer> {

    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法, 可以从 NumberValid 注解中获取需要的信息
     * @param numberValid 注解
     */
    @Override
    public void initialize(NumberValid numberValid) {
        int[] values = numberValid.values();
        for (int value : values) set.add(value);

    }

    /**
     * 判断是否校验成功
     * @param integer 提交的, 需要校验的值
     * @param constraintValidatorContext /
     * @return boolean
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }
}
