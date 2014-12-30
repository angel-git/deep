package com.ags.deep.ui.annotation;

import java.lang.annotation.*;

/**
 * Annotation from http://blog.codeleak.pl/2013/11/thymeleaf-template-layouts-in-spring.html
 * Allows natural templating
 * Created by Gavalda on 12/30/2014.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Layout {
    String value() default "";
}