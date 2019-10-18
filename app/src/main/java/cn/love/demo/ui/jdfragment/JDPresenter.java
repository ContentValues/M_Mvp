package cn.love.demo.ui.jdfragment;

import android.util.Log;

import cn.love.demo.MainDataManager;
import io.reactivex.observers.DisposableObserver;

/**
 * Author：created by SugarT
 * Time：2019/10/18 13
 */
public class JDPresenter implements JDContract.Presenter {


    private JDContract.View mJDView;
    private MainDataManager mDataManager;

    public JDPresenter(MainDataManager mDataManager, JDContract.View mJDView) {
        this.mDataManager = mDataManager;
        this.mJDView = mJDView;
    }


    /**
     * 默认数据
     *
     * @param flag
     */
    @Override
    public void getHomeIndexData(int flag) {

        mDataManager.getData(new DisposableObserver<HomeIndex>() {
            @Override
            public void onNext(HomeIndex homeIndex) {

                mJDView.setHomeIndexData(homeIndex);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "onError: " + e);
//                mJDView.setHomeIndexData(null);
            }

            @Override
            public void onComplete() {
            }
        }, HomeIndex.class, flag == 1 ? "homeindex.txt" : "homeindexevent.txt");
    }


    /**
     * 下拉刷新数据
     */
    @Override
    public void getRecommendedWares() {
        mDataManager.getData(new DisposableObserver<HomeIndex>() {
            @Override
            public void onNext(HomeIndex homeIndex) {
                mJDView.setRecommendedWares(homeIndex);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, HomeIndex.class, "recommend.txt");
    }


    /**
     * 加载更多数据
     */
    @Override
    public void getMoreRecommendedWares() {
        mDataManager.getData(new DisposableObserver<HomeIndex>() {
            @Override
            public void onNext(HomeIndex homeIndex) {
                mJDView.setMoreRecommendedWares(homeIndex);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, HomeIndex.class, "recommended.txt");
    }
}
