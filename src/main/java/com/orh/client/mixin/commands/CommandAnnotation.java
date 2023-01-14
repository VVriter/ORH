package com.orh.client.mixin.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandAnnotation {
    String name() default "";
    String description() default "Команда";
    String[] alies() default {};
    int min_args() default 0;
    int max_args() default 0;
}
