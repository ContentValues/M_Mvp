package cn.love.demo.ui.jdfragment;

/**
 * Author：created by SugarT
 * Time：2019/10/18 13
 */
public interface JDContract {

    interface View {
        void setHomeIndexData(HomeIndex find);
        void setRecommendedWares(HomeIndex find);
        void setMoreRecommendedWares(HomeIndex find);
    }

    interface Presenter {
        void getHomeIndexData(int flag);
        void getRecommendedWares();
        void getMoreRecommendedWares();
    }

}
