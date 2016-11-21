package com.fightzhao.biliclient.app;

import android.app.Application;

/**
 * 作者 ：fightzhao on 2016/11/21 17:17.
 * 功能 :
 */

public class App extends Application {
    private static App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance() {

        return mInstance;
    }

}
