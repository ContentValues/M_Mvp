package cn.love.base;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import cn.love.XDroidConf;


/**
 * Created by zhangmin on 2018/6/19.
 */

public class LifecycleActivity extends RxAppCompatActivity {

    private long timestamp;

    private final static String TAG = LifecycleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            timestamp = SystemClock.elapsedRealtime();
            Log.d(TAG, "ActivityLifeCircle " + this.getClass().getSimpleName() + " onCreate");
        }
        super.onCreate(savedInstanceState);
        //topActivity = this;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "ActivityLifeCircle " + this.getClass().getSimpleName() + " onCreate 2");
        }
        super.onCreate(savedInstanceState, persistentState);

    }


    @Override
    protected void onStart() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "ActivityLifeCircle " + this.getClass().getSimpleName() + " onStart " + (SystemClock.elapsedRealtime() - timestamp));
        }
        super.onStart();
    }

    @Override
    protected void onResumeFragments() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "ActivityLifeCircle " + this.getClass().getSimpleName() + " onResumeFragments");
        }
        super.onResumeFragments();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "ActivityLifeCircle " + this.getClass().getSimpleName() + " onConfigurationChanged");
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onAttachedToWindow() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onAttachedToWindow");
        }
        super.onAttachedToWindow();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onSaveInstanceState");
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onSaveInstanceState 2");
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onStateNotSaved() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onStateNotSaved");
        }
        super.onStateNotSaved();
    }

    @Override
    public void onContentChanged() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onContentChanged");
        }
        super.onContentChanged();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onPostCreate");
        }
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onPostCreate 2");
        }
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onRestoreInstanceState");
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onRestoreInstanceState 2");
        }
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    protected void onPostResume() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onPostResume");
        }
        super.onPostResume();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onAttachFragment");
        }
        super.onAttachFragment(fragment);
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onAttachFragment app ");
        }
        super.onAttachFragment(fragment);
    }


    @Override
    protected void onRestart() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onRestart");
        }
        super.onRestart();

    }


    @Override
    public void onDetachedFromWindow() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onDetachedFromWindow");
        }
        super.onDetachedFromWindow();

    }

    @Override
    public void onVisibleBehindCanceled() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onVisibleBehindCanceled");
        }
        super.onVisibleBehindCanceled();

    }

    @Override
    public void onLowMemory() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onLowMemory");
        }
        super.onLowMemory();

    }

    @Override
    public void onTrimMemory(int level) {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onTrimMemory");
        }
        super.onTrimMemory(level);

    }

    @Override
    protected void onResume() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onResume " + (SystemClock.elapsedRealtime() - timestamp));
        }
        super.onResume();
        //topActivity = this;

    }

    @Override
    protected void onPause() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onPause");
        }
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onStop");
        }
    }

    @Override
    protected void onDestroy() {
        if (XDroidConf.DEV) {
            Log.d(TAG,"ActivityLifeCircle " + this.getClass().getSimpleName() + " onDestroy");
        }
        super.onDestroy();
    }
}
