package cn.love.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.love.GlobalAppComponent;
import cn.love.kit.KnifeKit;
import cn.love.model.DataManager;

public abstract class BaseFragment extends LifecycleFragment {

    /**
     * 数据管理
     */
    protected DataManager mDataManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       View v = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
        KnifeKit.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();

        mDataManager = GlobalAppComponent.getAppComponent().getDataManager();
    }

    public abstract int getLayoutId();

    public abstract void initView(View v);

    public void initData() {

    }

}
