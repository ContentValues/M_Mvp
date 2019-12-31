package com.example.absNavigation.simple1;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abshttp.R;

/**
 * Author：created by SugarT
 * Time：2019/12/2 20
 */
public class DefaultAbsNavigationBar extends  AbsNavigationBar {

    public DefaultAbsNavigationBar(AbsNavigationBar.Builder.NavigationParams params) {
        super(params);
    }

    @Override
    protected void applyView() {

        TextView iv_left = (TextView) findViewById(R.id.left_tv);
        TextView title_tv = (TextView) findViewById(R.id.title_tv);
        TextView right_tv = (TextView) findViewById(R.id.right_tv);

        iv_left.setText("左");
        title_tv.setText("中");
        right_tv.setText("右");

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.navigation_default;
    }


   public static class Builder extends AbsNavigationBar.Builder{

       DefaultNavigationParams params;

       public Builder(Context context, ViewGroup parent) {
           this.params = new DefaultNavigationParams(context,parent);
       }

       public Builder setTitle(String title){
           params.leftTv = title;
           return this;
       }
       @Override
       DefaultAbsNavigationBar create() {
           return new DefaultAbsNavigationBar(params);
       }

       public static class DefaultNavigationParams extends AbsNavigationBar.Builder.NavigationParams{
           //标题
           public String title;
           public String leftTv;
           public String rightTv;


           public DefaultNavigationParams(Context mContext, ViewGroup parent) {
               super(mContext, parent);
           }
       }
   }
}
