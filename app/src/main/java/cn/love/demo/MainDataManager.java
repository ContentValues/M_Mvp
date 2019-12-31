package cn.love.demo;

import com.google.gson.Gson;

import java.io.InputStream;

import cn.love.demo.model.GankResults;
import cn.love.model.BaseDataManager;
import cn.love.model.DataManager;
import cn.love.util.FillUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Author：created by SugarT
 * Time：2019/10/18 13
 */
public class MainDataManager extends BaseDataManager {
    public MainDataManager(DataManager mDataManager) {
        super(mDataManager);
    }

    public static MainDataManager getInstance(DataManager dataManager) {
        return new MainDataManager(dataManager);
    }


    /*
     *验证短信验证码注册/登陆 （只做示例，无数据返回）
     */
    public Disposable login(DisposableObserver<ResponseBody> consumer, String mobile, String verifyCode) {

        Observable<ResponseBody> observable = getService(MainApiService.class).login(mobile, verifyCode);

        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
//        return changeIOToMainThread(getService(MainApiService.class).login(mobile,verifyCode), consumer);
    }


//    public Disposable getMainData(int start, int count, DisposableObserver<ResponseBody> consumer) {
//        Map<String, Object> map = new HashMap<>(2);
//        map.put("start", start);
//        map.put("count", count);
//
//        Observable<ResponseBody> observable = getService(BaseApiService.class).executeGet("http://www.baidu.com", map);
//
//        return observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(consumer);
//    }


    /**
     * 获取主页数据
     *
     * @param type     请求类型
     * @param pageSize 一页最大的数据
     * @param pageNum  当前是第几页
     * @param consumer
     * @return
     */
    public Observable getMainData(String type, int pageSize, int pageNum
            , DisposableObserver<ResponseBody> consumer) {
        Observable<GankResults> observable = getService(MainApiService.class).getGankData(type, pageSize, pageNum);
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public <S> Disposable getData(DisposableObserver<S> consumer, final Class<S> clazz, final String fillName) {

        return Observable.create(new ObservableOnSubscribe<S>() {
            @Override
            public void subscribe(ObservableEmitter<S> e) throws Exception {
                InputStream is = getContext().getAssets().open(fillName);
                String text = FillUtil.readTextFromFile(is);
                Gson gson = new Gson();
                e.onNext(gson.fromJson(text, clazz));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

}
