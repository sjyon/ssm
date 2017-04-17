package com.jayon.ssm.web.bind.annotation;


import java.lang.annotation.*;

import com.jayon.ssm.constants.Constants;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;

}
