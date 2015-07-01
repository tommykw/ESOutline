package tommy_kw.esoutline.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import tommy_kw.esoutline.DesingInfo;
import tommy_kw.esoutline.R;

import static tommy_kw.esoutline.R.*;

/**
 * Created by tomita on 15/07/01.
 */
public class ContentRecyclerView extends RecyclerView implements LoaderManager.LoaderCallbacks<List<DesingInfo>>{
    public interface ContentRecyclerViewListener {
        void openWebPage(String url);
    }

    private ContentRecyclerViewListener mListener;
    //private ContentRecyclerViewAdapter mAdapter;
    private SwipeRefreshLayout mRefresh;

    @Override
    public Loader<List<DesingInfo>> onCreateLoader(int id, Bundle args) {
        String url = args.getString("url");
        String className = args.getString("className");
    }

    @Override
    public void onLoadFinished(Loader<List<DesingInfo>> loader, List<DesingInfo> data) {
    }

    @Override
    public void onLoaderReset(Loader<List<DesingInfo>> loader) {
        if (mRefresh != null) mRefresh.setRefreshing(false);
    }

    public ContentRecyclerView(Context context) {
        super(context);
    }

    public ContentRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout refresh) {
        mRefresh = refresh;
    }

    public void setContentRecyclerViewListener(ContentRecyclerViewListener listener) {
        mListener = listener;
    }
}