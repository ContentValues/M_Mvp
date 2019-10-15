package cn.love.demo.present;

import cn.love.demo.model.GankResults;
import cn.love.demo.net.Api;
import cn.love.demo.ui.BasePagerFragment;
import cn.love.mvp.XPresent;
import cn.love.net.ApiSubscriber;
import cn.love.net.NetError;
import cn.love.net.XApi;

/**
 * Created by wanglei on 2016/12/31.
 */

public class PBasePager extends XPresent<BasePagerFragment> {
    protected static final int PAGE_SIZE = 10;


    public void loadData(String type, final int page) {
        Api.getGankService().getGankData(type, PAGE_SIZE, page)
                .compose(XApi.<GankResults>getApiTransformer())
                .compose(XApi.<GankResults>getScheduler())
                .compose(getV().<GankResults>bindToLifecycle())
                .subscribe(new ApiSubscriber<GankResults>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(GankResults gankResults) {
                        getV().showData(page, gankResults);
                    }
                });
    }
}
