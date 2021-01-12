package xyz.wqf.dockerdemo.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnoAspect {
    /**
     * 数据类型
     * @return
     */
    String value() default "";
}
