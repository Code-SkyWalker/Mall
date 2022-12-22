package com.skywalker.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author Code SkyWalker
 * @Date 14:56 2022/12/14
 * @Classname NumberValid
 * @Description 自定义校验注解
 */
@Documented
@Constraint(validatedBy = { NumberValidConstraintValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberValid {

    String message() default "{com.skywalker.valid.ValidUpdate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] values() default {};
}
