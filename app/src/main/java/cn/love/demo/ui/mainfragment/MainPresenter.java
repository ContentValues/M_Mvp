package cn.love.demo.ui.mainfragment;
import android.util.Log;
import cn.love.demo.MainDataManager;
import cn.love.demo.model.GankResults;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author：created by SugarT
 * Time：2019/10/21 10
 */
public class MainPresenter implements MainContract.Presenter {

    MainDataManager mMainDataManager;
    MainContract.View mView;

    private final static String TAG = "MainPresenter";

    public MainPresenter(MainDataManager mMainDataManager, MainContract.View mView) {
        this.mMainDataManager = mMainDataManager;
        this.mView = mView;
    }

    @Override
    public void getMainData(String type, int pageSize, final int currentPage) {


        mMainDataManager.getMainData(type, pageSize, currentPage, null).subscribe(new Observer<GankResults>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"onSubscribe()");
            }

            @Override
            public void onNext(GankResults model) {
                Log.d(TAG,"onNext()");
                mView.setMainData(currentPage,model);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError()");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"onComplete()");
            }
        });

    }
}
