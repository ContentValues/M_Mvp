package cn.love.demo.ui.mainfragment;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import java.util.List;
import cn.love.base.BaseFragment;
import cn.love.demo.App;
import cn.love.demo.R;
import cn.love.demo.dao.User;
import cn.love.demo.dao.UserDao;
import cn.love.demo.reflex.FromValue;
import cn.love.demo.reflex.InjectUtils;
import cn.love.util.TimeUtils;

/**
 * Author：created by SugarT
 * Time：2019/11/25 14
 */
public class DaoFragment extends BaseFragment implements View.OnClickListener {

    @FromValue(R.id.insert)
    private TextView insert;

    @FromValue(R.id.delete)
    private TextView delete;

    @FromValue(R.id.update)
    private TextView update;

    @FromValue(R.id.query)
    private TextView query;

    @FromValue(R.id.mTvContent)
    private TextView mTvContent;

    @Deprecated
    private UserDao userDao;


    public static DaoFragment newInstance() {
        return new DaoFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_dao;
    }

    @Override
    public void initView(View v) {
//        insert = v.findViewById(R.id.insert);
//        delete = v.findViewById(R.id.delete);
//        update = v.findViewById(R.id.update);
//        query = v.findViewById(R.id.query);
//        mTvContent = v.findViewById(R.id.mTvContent);

        InjectUtils.inject(this);




        userDao = App.getmDaoSession().getUserDao();
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);


//        new DefaultNavigation.Builder(getContext(), linearLayout)
//                .setLeft("左边")
//                .setLeftIcon(R.drawable.icon_new)
//                .setTitle("标题")
//                .setRight("右边")
//                .setLeftOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        System.out.println("点击左边");
//                    }
//                })
//                .setRightOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        System.out.println("点击右边");
//                    }
//                }).create();


    }


    private void doInsert() {
        User user = new User(null, "xyh", 120, "篮球1", TimeUtils.getNowString());
        User user2 = new User(null, "xyh", 120, "篮球2", TimeUtils.getNowString());
        User user3 = new User(null, "zhangmin", 121, "足球", TimeUtils.getNowString());

        User user0 = new User(Long.valueOf("1"), "xyh0", 120, "篮球1", TimeUtils.getNowString());
        User user00 = new User(Long.valueOf("1"), "xyh00", 120, "篮球1", TimeUtils.getNowString());
        userDao.insertOrReplace(user);
        userDao.insertOrReplace(user2);
        userDao.insertOrReplace(user3);

        userDao.insertOrReplace(user0);
        userDao.insertOrReplace(user00);
    }

    private void doDelete() {

    }

    private void doUpdate() {

//        userDao.update();
    }

    private void doQuery() {
        List<User> modules = userDao.loadAll();
        mTvContent.setText(JSON.toJSONString(modules));

        userDao.queryBuilder()
                .where(UserDao.Properties.Name.like("xyh8%"))
                .orderAsc(UserDao.Properties.Age)
                .list();
        userDao.queryRaw("", "");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                Toast.makeText(getContext(),"点击了insert",Toast.LENGTH_SHORT).show();
//                doInsert();
//                Log.d("hook","onClick insert");
//                printer.print1();
//                printer.print2();
//                printer.print3();

                break;
            case R.id.delete:
                Toast.makeText(getContext(),"点击了delete",Toast.LENGTH_SHORT).show();
//                doDelete();
//                Log.d("hook","onClick delete");
                break;
            case R.id.update:
//                doUpdate();
//                Log.d("hook","onClick update");
                break;
            case R.id.query:
//                doQuery();
//                Log.d("hook","onClick query");
                break;
            default:
                break;
        }
    }


}
