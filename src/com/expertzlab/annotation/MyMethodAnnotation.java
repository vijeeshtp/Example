package com.expertzlab.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by vijeesh on 10/08/17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface MyMethodAnnotation {
    public String name();
    public String value();
}

