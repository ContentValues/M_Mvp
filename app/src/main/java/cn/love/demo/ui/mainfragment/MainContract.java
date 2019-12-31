package cn.love.demo.ui.mainfragment;

import cn.love.demo.model.GankResults;

/**
 * Author：created by SugarT
 * Time：2019/10/21 10
 */
public interface MainContract {

    interface View {

        void setMainData(int currentPage,GankResults model);


    }

    interface Presenter {

        void getMainData(String type,int pageSize,int currentPage);

    }

}
