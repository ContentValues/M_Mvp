package cn.love.callback;

public abstract class ItemCallback<T> {

    public void onItemClick(int position, T model, int tag) {}

    public void onItemLongClick(int position, T model, int tag) {}
}
