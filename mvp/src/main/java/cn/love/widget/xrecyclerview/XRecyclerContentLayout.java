package cn.love.widget.xrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import cn.love.R;
import cn.love.widget.XStateController;


public class XRecyclerContentLayout extends XStateController implements XRecyclerView.StateCallback, SwipeRefreshLayout.OnRefreshListener {

    private int padding;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    private int scrollbarStyle;
    private int backgroundColor;
    private boolean clipToPadding;
    private boolean scrollbarNone = false;

    SwipeRefreshLayout swipeRefreshLayout;
    XRecyclerView recyclerView;


    public XRecyclerContentLayout(Context context) {
        this(context, null);
    }

    public XRecyclerContentLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerContentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setupAttrs(context, attrs);
        inflateView(context);
    }

    private void setupAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XRecyclerContentLayout);

        backgroundColor = typedArray.getColor(R.styleable.XRecyclerContentLayout_recyclerBackgroundColor, Color.WHITE);
        padding = (int) typedArray.getDimension(R.styleable.XRecyclerContentLayout_recyclerPadding, -1.0f);
        paddingLeft = (int) typedArray.getDimension(R.styleable.XRecyclerContentLayout_recyclerPaddingLeft, 0.0f);
        paddingRight = (int) typedArray.getDimension(R.styleable.XRecyclerContentLayout_recyclerPaddingRight, 0.0f);
        paddingTop = (int) typedArray.getDimension(R.styleable.XRecyclerContentLayout_recyclerPaddingTop, 0.0f);
        paddingBottom = (int) typedArray.getDimension(R.styleable.XRecyclerContentLayout_recyclerPaddingBottom, 0.0f);
        scrollbarStyle = typedArray.getInt(R.styleable.XRecyclerContentLayout_recyclerScrollbarStyle, 2);
        clipToPadding = typedArray.getBoolean(R.styleable.XRecyclerContentLayout_recyclerClipToPadding, false);
        scrollbarNone = typedArray.getBoolean(R.styleable.XRecyclerContentLayout_recyclerScrollbarNone, false);

        typedArray.recycle();
    }

    private void inflateView(Context context) {
        inflate(context, R.layout.x_view_recycler_content_layout, this);
    }


    @Override
    protected void onFinishInflate() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (XRecyclerView) findViewById(R.id.recyclerView);

        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.x_red,
                R.color.x_blue,
                R.color.x_yellow,
                R.color.x_green
        );


        //todo 有内存泄漏问题
        //swipeRefreshLayout.setOnRefreshListener(new SwipRefreshOnListener(recyclerView));
        swipeRefreshLayout.setOnRefreshListener(this);
        if (padding != -1) {
            recyclerView.setPadding(padding, padding, padding, padding);
        } else {
            recyclerView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        recyclerView.setClipToPadding(clipToPadding);

        if (scrollbarNone) {
            recyclerView.setVerticalScrollBarEnabled(false);
            recyclerView.setHorizontalScrollBarEnabled(false);
        } else {
            recyclerView.setScrollBarStyle(scrollbarStyle);
        }

        recyclerView.setBackgroundColor(backgroundColor);

        recyclerView.stateCallback(this);

        super.onFinishInflate();
    }

   /* @Override
    public void setDisplayState(int displayState) {
        if(swipeRefreshLayout.isRefreshing()){
            refreshState(false);
        }
        XRecyclerAdapter adapter = recyclerView.getAdapter();
        if (adapter != null && adapter.getItemCount() > 0) {
            super.setDisplayState(STATE_CONTENT);
            return;
        }
        super.setDisplayState(displayState);
    }

    public void setDisplayState(int state, boolean isForce) {
        if (isForce) {
            super.setDisplayState(state);
            return;
        }
        setDisplayState(state);
    }*/

   /* @Override
    public void showEmpty() {
        setDisplayState(STATE_EMPTY, true);
    }*/

   /* @Override
    public void showError() {
        setDisplayState(STATE_ERROR, true);
    }*/

   /* @Override
    public void showLoading() {
        setDisplayState(STATE_LOADING, true);
    }*/

    @Override
    public void notifyEmpty() {
        showEmpty();
    }

    @Override
    public void notifyContent() {
        showContent();
    }

    @Override
    public void refreshState(boolean isRefresh) {
        //true：加载进度条；false：关闭进度条
        swipeRefreshLayout.setRefreshing(isRefresh);
    }

    @Override
    public void refreshEnabled(boolean isEnabled) {
        //true：可以下拉；false：不可下拉
        swipeRefreshLayout.setEnabled(isEnabled);
    }


    @Override
    public void onRefresh() {
        recyclerView.onRefresh();
    }

    public XRecyclerView getRecyclerView() {
        return recyclerView;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }


   /* @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.log("FragmentLifeCircle " + this.getClass().getSimpleName() + " onDetachedFromWindow " + DateUtil.getCurrentTime());
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(null);
        }
    }*/

    /**
     * todo 注意点 解决swipeRefreshLayout.setOnRefreshListener 内存泄漏的问题
     * <p>
     * swipeRefreshLayout.mListener 持有了XRecyclerContentLayout对象 导致内存泄漏
     */
    /*static class SwipRefreshOnListener implements SwipeRefreshLayout.OnRefreshListener {

        WeakReference<XRecyclerView> weakReference;

        public SwipRefreshOnListener(XRecyclerView xRecyclerView) {
            weakReference = new WeakReference<XRecyclerView>(xRecyclerView);
        }

        @Override
        public void onRefresh() {
            if (weakReference != null) {
                weakReference.get().onRefresh();
            }
        }
    }*/
}
