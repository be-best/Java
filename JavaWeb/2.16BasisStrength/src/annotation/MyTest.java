package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 * 自定义注解默认存在于源码阶段,需要让注解存在的时间更长.使用元注解:(只用于修饰其他的注解)
 * @author admin
 *
 */
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyTest {

}
