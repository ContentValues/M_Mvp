package cn.love.demo.ui.jdfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.love.base.XRecAdapter;
import cn.love.demo.R;
import cn.love.imageloader.ILFactory;

/**
 * Author：created by SugarT
 * Time：2019/10/10 16
 */
public class IconListAdapter extends XRecAdapter<HomeIndex.ItemInfoListBean.ItemContentListBean, IconListAdapter.IconListHolder> {

    public IconListAdapter(Context context) {
        super(context);
    }

    @Override
    public IconListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IconListHolder(LayoutInflater.from(context).inflate(R.layout.homerecycle_item_icon_list, parent, false));
    }

    @Override
    public void onBindViewHolder(IconListHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    public class IconListHolder extends RecyclerView.ViewHolder {

        private final ImageView icon_list;
        private final TextView icon_list_title;

        public IconListHolder(View itemView) {
            super(itemView);

            icon_list = itemView.findViewById(R.id.icon_list);
            icon_list_title = itemView.findViewById(R.id.icon_list_title);
        }

        private void bindData(HomeIndex.ItemInfoListBean.ItemContentListBean item){
            ILFactory.getLoader().loadNet(icon_list,item.imageUrl,null);
            icon_list_title.setText(item.itemTitle);
        }
    }
}
