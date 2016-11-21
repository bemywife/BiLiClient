package com.fightzhao.biliclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.fightzhao.biliclient.utils.ConstantUtils;
import com.fightzhao.biliclient.utils.PreferenceUtils;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setUpSplash();
    }

    private void setUpSplash() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .flatMap(new Func1<Long, Observable<String>>() {
                    @Override
                    public Observable<String> call(Long aLong) {
                        boolean isLogin = PreferenceUtils.getBoolean(ConstantUtils.KEY, false);
                        if (isLogin)
                            return Observable.just(ConstantUtils.GOTO_HOME);
                        else
                            return Observable.just(ConstantUtils.GOTO_LOGIN);
                    }
                })
                .subscribe(s -> {
                            if (s.equals(ConstantUtils.GOTO_HOME)) {
                                Toast.makeText(SplashActivity.this, "MainActivity", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(SplashActivity.this, "LoginActivity", Toast.LENGTH_LONG).show();

                            }
                        }
                );

    }
}
