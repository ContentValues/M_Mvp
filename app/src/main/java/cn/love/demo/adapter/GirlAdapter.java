package cn.love.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import cn.love.base.SimpleRecAdapter;
import cn.love.demo.R;
import cn.love.demo.model.GankResults;
import cn.love.imageloader.ILFactory;
import cn.love.imageloader.ILoader;
import cn.love.kit.KnifeKit;

/**
 * Created by wanglei on 2016/12/10.
 */

public class GirlAdapter extends SimpleRecAdapter<GankResults.Item, GirlAdapter.ViewHolder> {


    public GirlAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_girl;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GankResults.Item item = data.get(position);

        //圆形
//        ILFactory.getLoader().loadCircle(item.getUrl(),holder.ivGirl, new ILoader.Options(R.mipmap.xdroid_logo_128, R.mipmap.xdroid_logo_128));
        //圆角
//        ILFactory.getLoader().loadCorner(item.getUrl(),holder.ivGirl, 50,new ILoader.Options(R.mipmap.xdroid_logo_128, R.mipmap.xdroid_logo_128));
        //正常
        ILFactory.getLoader().loadNet(holder.ivGirl, item.getUrl(), new ILoader.Options(R.mipmap.xdroid_logo_128, R.mipmap.xdroid_logo_128));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRecItemClick() != null) {

                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_girl)
        ImageView ivGirl;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this, itemView);
        }
    }
}
