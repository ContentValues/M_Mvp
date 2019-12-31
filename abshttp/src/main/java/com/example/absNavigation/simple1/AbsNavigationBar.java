package com.example.absNavigation.simple1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author：created by SugarT
 * Time：2019/12/2 20
 */
public abstract class AbsNavigationBar<P extends AbsNavigationBar.Builder.NavigationParams>  {

    private P params;
    private View v;

    public AbsNavigationBar(P params) {
        this.params = params;
        createAndBind();
    }

    protected  void createAndBind(){
        if(params != null){
            throw new NullPointerException();
        }
        v = LayoutInflater.from(params.mContext).inflate(bindLayoutId(),params.parent,false);
        params.parent.addView(v,0);
        applyView();
    }

    protected abstract void applyView();

    protected abstract int bindLayoutId();


    /**
     * 通过ID得到View
     * @param viewId
     * @param <T>
     * @return
     */
    public  <T extends View> T findViewById(int viewId){
       return (T)v.findViewById(viewId);
    }



    public static abstract class Builder{
        
        
        abstract AbsNavigationBar create();
        
        
        public static class NavigationParams{
            
            public Context mContext;
            public ViewGroup parent;

            public NavigationParams(Context mContext, ViewGroup parent) {
                this.mContext = mContext;
                this.parent = parent;
            }
        }
        
        
    }
    
}
