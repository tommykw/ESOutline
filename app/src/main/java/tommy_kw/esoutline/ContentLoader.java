package tommy_kw.esoutline;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by tomita on 15/07/06.
 */
public class ContentLoader extends AsyncTaskLoader<List<DesingInfo>> {
    private static final String TAG = ContentLoader.class.getSimpleName();
    private List<DesingInfo> mList;
    private String mUrl;
    private String mClassName;

    public ContentLoader(Context context, String url, String className) {
        super(context);
        mUrl = url;
        mClassName = className;
    }

    @Override
    public List<DesingInfo> loadInBackground() {
        return null;
    }

    @Override
    protected void onStartLoading() {
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        cancelLoad();
    }

    @Override
    public void deliverResult(List<DesingInfo> data) {
        if (isReset()) {
            return;
        }
        if (mList != null) mList = null;
        mList = data;
        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mList != null) {
            mList.clear();
            mList = null;
        }
    }
}
