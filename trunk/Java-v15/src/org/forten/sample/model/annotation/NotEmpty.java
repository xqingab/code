package org.forten.sample.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target声明了NotEmpty注解可以被标注在类中的方法上 
@Target({ ElementType.METHOD })
// @Retention声明了NotEmpty在程序的运行时起作用（会被识别）
@Retention(RetentionPolicy.RUNTIME)
// 声明注解的方式是使用@interface
public @interface NotEmpty {
	// 为注解声明属性，以增强注解的说明性
	// 如果使用default，可以为属性赋一个默认值
	// 如果不使用default，则在其它类中标注此注解时一定要为这个属性显式的分配一个值
	String msg() default "not empty";
}
