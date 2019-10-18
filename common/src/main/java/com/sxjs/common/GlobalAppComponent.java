package com.sxjs.common;
import android.content.Context;

/**
 * @author：admin on 2017/4/15 15:26.
 */

public class GlobalAppComponent {
    private volatile static AppComponent mAppComponent;

    /**
     * 初始化全局AppComponent
     *
     * @param context applicationContext
     */
    public static void init(Context context) {
        if (mAppComponent == null) {
            synchronized (GlobalAppComponent.class) {
                if (mAppComponent == null) {
                    mAppComponent = AppComponent.newInstance(context.getApplicationContext());
                }
            }
        }
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
        }
        return mAppComponent;
    }
}
