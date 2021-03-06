package com.yanyuanquan.android.library.adapter.anno;

import android.annotation.TargetApi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by guider on 16/8/30.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemType {
}
