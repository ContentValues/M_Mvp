package cn.love.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import cn.love.XDroidConf;
/**
 * Created by zhangmin on 2018/6/19.
 */

public class LifecycleFragment extends RxFragment {

    private long timestamp;

    public String TAG = this.getClass().getName();

    @Override
    public void onAttach(Context context) {
        if (XDroidConf.DEV) {
            timestamp = SystemClock.elapsedRealtime();
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onAttach " + timestamp);
        }
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onCreate " + (SystemClock.elapsedRealtime() - timestamp));
        }
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onCreateView " + (SystemClock.elapsedRealtime() - timestamp));
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onViewCreated " + (SystemClock.elapsedRealtime() - timestamp));
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onHiddenChanged " + hidden);
        }
        super.onHiddenChanged(hidden);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onViewStateRestored");
        }
        super.onViewStateRestored(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onViewStateRestored");
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onViewStateRestored");
        }
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onInflate");
        }
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onAttachFragment childFragment " + childFragment);
        }
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onStart() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onStart");
        }
        super.onStart();

    }

    @Override
    public void onResume() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onResume " + (SystemClock.elapsedRealtime() - timestamp));
        }
        super.onResume();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onSaveInstanceState");
        }
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onPause() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onPause");
        }
        super.onPause();

    }


    @Override
    public void onStop() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onStop");
        }
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onDestroyView");
        }
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onDestroy");
        }
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        if (XDroidConf.DEV) {
            Log.d(TAG, "FragmentLifeCircle " + this.getClass().getSimpleName() + " onDetach");
        }
        super.onDetach();

    }
}
