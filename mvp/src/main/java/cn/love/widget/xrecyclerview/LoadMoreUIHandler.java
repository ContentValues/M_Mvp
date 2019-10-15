package cn.love.widget.xrecyclerview;

public interface LoadMoreUIHandler {
    void onLoading();

    void onLoadFinish(boolean hasMore);
}
