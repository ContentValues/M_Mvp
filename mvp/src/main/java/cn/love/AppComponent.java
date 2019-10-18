package cn.love;

import android.content.Context;

import cn.love.model.DataManager;
import cn.love.model.dao.DataBaseHelper;
import cn.love.model.http.HttpHelper;
import cn.love.model.sp.SharePreferenceHelper;


/**
 * Created by admin on 2017/3/10.
 */
public class AppComponent {

    public static AppComponent instance = null;

    private static Context mContext;
    private static DataManager mDataManager;

    private AppComponent() {
        mDataManager = new DataManager(mContext, new HttpHelper(mContext), new SharePreferenceHelper(mContext), new DataBaseHelper(mContext));

    }

    public static synchronized AppComponent newInstance(Context context) {
        mContext = context;
        if (instance == null) {
            instance = new AppComponent();
        }
        return instance;

    }

    public Context getContext() {
        return mContext;
    }


    public DataManager getDataManager() {
        return mDataManager;
    }


}
