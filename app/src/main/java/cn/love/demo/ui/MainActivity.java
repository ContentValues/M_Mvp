package cn.love.demo.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.absNavigation.DefaultNavigation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.love.base.BaseActivity;
import cn.love.base.XFragmentAdapter;
import cn.love.demo.R;
import cn.love.demo.ui.jdfragment.JDFragment;
import cn.love.demo.ui.mainfragment.DaoFragment;
import cn.love.demo.ui.mainfragment.GanhuoFragment;
import cn.love.demo.ui.mainfragment.GirlFragment;
import cn.love.demo.ui.mainfragment.HomeFragment;
import cn.love.demo.ui.mainfragment.HttpFragment;

/**
 * Created by wanglei on 2016/12/22.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"京东", "首页", "干货", "妹子","数据库","网络"};

    XFragmentAdapter adapter;

    @Override
    public void initView() {



        setSupportActionBar(toolbar);

        fragmentList.clear();
        fragmentList.add(JDFragment.newInstance());
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(GanhuoFragment.newInstance());
        fragmentList.add(GirlFragment.newInstance());
        fragmentList.add(DaoFragment.newInstance());
        fragmentList.add(HttpFragment.newInstance());


        if (adapter == null) {
            adapter = new XFragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        }
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_droid:
                AboutActivity.launch(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
