package io.fashionet.core.base.request.argument.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Flag {
    String value() default "";
}
