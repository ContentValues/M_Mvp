package cn.love.demo.ui.jdfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.love.AppComponent;
import cn.love.base.BaseFragment;
import cn.love.demo.MainDataManager;
import cn.love.demo.R;


/**
 * Author：created by SugarT
 * Time：2019/10/10 13
 */
public class JDFragment extends BaseFragment implements JDContract.View {


    private JDAdapter jdAdapter;
    private JDPresenter mJDPresenter;

    public static JDFragment newInstance() {
        return new JDFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_jd_main;
    }

    @Override
    public void initView(View v) {
        RecyclerView mMainRecyclerView = v.findViewById(R.id.mMainRecyclerView);
        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        jdAdapter = new JDAdapter(getContext());
        mMainRecyclerView.setAdapter(jdAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mJDPresenter = new JDPresenter(MainDataManager.getInstance(mDataManager), this);
        //得到初始数据
        mJDPresenter.getHomeIndexData(1);

    }

    @Override
    public void setHomeIndexData(HomeIndex find) {

        jdAdapter.setData(find.itemInfoList);
    }

    @Override
    public void setRecommendedWares(HomeIndex find) {

    }

    @Override
    public void setMoreRecommendedWares(HomeIndex find) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (jdAdapter != null) {
            jdAdapter.cancelAllTimers();
        }
    }


}
