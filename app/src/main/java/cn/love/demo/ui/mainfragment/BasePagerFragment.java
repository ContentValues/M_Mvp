package cn.love.demo.ui.mainfragment;

import android.view.View;
import android.widget.TextView;

import com.example.abshttp.simple4.OKhttpRequest;

import java.io.IOException;

import butterknife.BindView;
import cn.love.base.BaseFragment;
import cn.love.base.SimpleRecAdapter;
import cn.love.demo.MainDataManager;
import cn.love.demo.R;
import cn.love.demo.model.GankResults;
import cn.love.demo.net.Api;
import cn.love.net.ApiSubscriber;
import cn.love.net.NetError;
import cn.love.net.XApi;
import cn.love.widget.xrecyclerview.XRecyclerContentLayout;
import cn.love.widget.xrecyclerview.XRecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wanglei on 2016/12/31.
 */

public abstract class BasePagerFragment extends BaseFragment implements MainContract.View {

    @BindView(R.id.contentLayout)
    XRecyclerContentLayout contentLayout;

    @BindView(R.id.tv_error)
    TextView tv_error;

    protected static final int MAX_PAGE = 10;
    protected static final int PAGE_SIZE = 10;
    private MainPresenter mMainPresenter;


    @Override
    public void setMainData(int currentPage, GankResults model) {
        if (currentPage > 1) {
            getAdapter().addData(model.getResults());
        } else {
            getAdapter().setData(model.getResults());
        }
        contentLayout.getRecyclerView().setPage(currentPage, MAX_PAGE);
        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
    }

    @Override
    public void initView(View v) {
        initAdapter();
    }

    @Override
    public void initData() {
        super.initData();
        mMainPresenter = new MainPresenter(MainDataManager.getInstance(mDataManager), this);
        loadData(1);
    }

    private void initAdapter() {
        setLayoutManager(contentLayout.getRecyclerView());
        contentLayout.getRecyclerView()
                .setAdapter(getAdapter());
        contentLayout.getRecyclerView()
                .setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
                    @Override
                    public void onRefresh() {
                        loadData(1);
                    }

                    @Override
                    public void onLoadMore(int page) {
                        loadData(page);
                    }
                });
        contentLayout.getRecyclerView().useDefLoadMoreView();
    }

    public abstract SimpleRecAdapter getAdapter();

    public abstract void setLayoutManager(XRecyclerView recyclerView);

    public abstract String getType();


    public void loadData(final int page) {


        mMainPresenter.getMainData(getType(), PAGE_SIZE, page);


//        Observable<GankResults> observable = mDataManager.getService(MainApiService.class).getGankData(getType(), PAGE_SIZE, page);
//
//        observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(this.<GankResults>bindToLifecycle())
//                .subscribeWith(new Observer<GankResults>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe()");
//                    }
//
//                    @Override
//                    public void onNext(GankResults model) {
//                        Log.d(TAG, "onNext()");
//                        if (page > 1) {
//                            getAdapter().addData(model.getResults());
//                        } else {
//                            getAdapter().setData(model.getResults());
//                        }
//
//                        contentLayout.getRecyclerView().setPage(page, MAX_PAGE);
//
//                        if (getAdapter().getItemCount() < 1) {
//                            contentLayout.showEmpty();
//                            return;
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError()");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete()");
//                    }
//                });


//        Api.getGankService().getGankData(getType(), PAGE_SIZE, page)
//                .compose(XApi.<GankResults>getApiTransformer())
//                .compose(XApi.<GankResults>getScheduler())
//                .compose(this.<GankResults>bindToLifecycle())
//                .subscribe(new ApiSubscriber<GankResults>() {
//                    @Override
//                    protected void onFail(NetError error) {
//                        tv_error.setText(error.getMessage());
//                        contentLayout.showError();
//                    }
//
//                    @Override
//                    public void onNext(GankResults model) {
//                        if (page > 1) {
//                            getAdapter().addData(model.getResults());
//                        } else {
//                            getAdapter().setData(model.getResults());
//                        }
//
//                        contentLayout.getRecyclerView().setPage(page, MAX_PAGE);
//
//                        if (getAdapter().getItemCount() < 1) {
//                            contentLayout.showEmpty();
//                            return;
//                        }
//                    }
//                });

//        OkHttpClient client = new OkHttpClient();



    }


//    public void showError(NetError error) {
//        if (error != null) {
//            switch (error.getType()) {
//                case NetError.ParseError:
//                    errorView.setMsg("数据解析异常");
//                    break;
//
//                case NetError.AuthError:
//                    errorView.setMsg("身份验证异常");
//                    break;
//
//                case NetError.BusinessError:
//                    errorView.setMsg("业务异常");
//                    break;
//
//                case NetError.NoConnectError:
//                    errorView.setMsg("网络无连接");
//                    break;
//
//                case NetError.NoDataError:
//                    errorView.setMsg("数据为空");
//                    break;
//
//                case NetError.OtherError:
//                    errorView.setMsg("其他异常");
//                    break;
//            }
//            contentLayout.showError();
//        }
//    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_pager;
    }

}
