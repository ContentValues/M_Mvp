package cn.love.base;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.love.GlobalAppComponent;
import cn.love.kit.KnifeKit;
import cn.love.model.DataManager;

public abstract class BaseActivity extends LifecycleActivity {

    /**
     * 数据管理
     */
    protected DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        KnifeKit.bind(this);
        initView();
        initData(savedInstanceState);

        mDataManager = GlobalAppComponent.getAppComponent().getDataManager();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public  void initData(Bundle savedInstanceState){}

}
