package cn.love.demo;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import cn.love.GlobalAppComponent;
import cn.love.demo.dao.DaoMaster;
import cn.love.demo.dao.DaoSession;
import cn.love.net.NetError;
import cn.love.net.NetProvider;
import cn.love.net.RequestHandler;
import cn.love.net.XApi;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by wanglei on 2016/12/31.
 */

public class App extends Application {

    private static Context context;

    public static final String DB_NAME = "app.db";

    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        initGreenDao();
//        Stetho.initializeWithDefaults(this);

        XApi.registerProvider(new NetProvider() {

            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {

            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return 0;
            }

            @Override
            public long configReadTimeoutMills() {
                return 0;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }

            @Override
            public boolean dispatchProgressEnable() {
                return false;
            }
        });

        GlobalAppComponent.init(this);
    }

    public static Context getContext() {
        return context;
    }




    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
