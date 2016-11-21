package com.fightzhao.biliclient.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * 作者 ：fightzhao on 2016/11/7 18:48.
 * 功能 :
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView,View.OnClickListener{
    /**
     * 将代理类通用行为抽取出来
     */
    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ButterKnife.bind(this);
    }

    protected abstract void initView();

    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showRequest() {

    }

    @Override
    public void onClick(View view) {

    }
}
