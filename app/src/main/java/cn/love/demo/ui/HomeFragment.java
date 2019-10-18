package cn.love.demo.ui;

import cn.love.base.SimpleRecAdapter;
import cn.love.demo.adapter.HomeAdapter;
import cn.love.demo.model.GankResults;
import cn.love.widget.xrecyclerview.RecyclerItemCallback;
import cn.love.widget.xrecyclerview.XRecyclerView;

/**
 * Created by wanglei on 2016/12/31.
 */

public class HomeFragment extends BasePagerFragment {

    HomeAdapter adapter;

    @Override
    public SimpleRecAdapter getAdapter() {
        if (adapter == null) {
            adapter = new HomeAdapter(getContext());
            adapter.setRecItemClick(new RecyclerItemCallback<GankResults.Item, HomeAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GankResults.Item model, int tag, HomeAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    switch (tag) {
                        case HomeAdapter.TAG_VIEW:
                            WebActivity.launch(getActivity(), model.getUrl(), model.getDesc());
                            break;
                    }
                }
            });
        }
        return adapter;
    }

    @Override
    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.verticalLayoutManager(getContext());
    }

    @Override
    public String getType() {
        return "all";
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
