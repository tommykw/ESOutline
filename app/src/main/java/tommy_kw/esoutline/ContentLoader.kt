package tommy_kw.esoutline

import android.content.Context
import android.support.v4.content.AsyncTaskLoader

/**
 * Created by tomita on 15/07/06.
 */
class ContentLoader(context: Context,
                    val mUrl: String,
                    val mClassName: String) : AsyncTaskLoader<List<DesingInfo>>(context) {
    private var mList: List<DesingInfo>? = null

    override fun loadInBackground(): List<DesingInfo>? {
        return null
    }

    override fun onStartLoading() {
    }

    override fun onStopLoading() {
        super.onStopLoading()
        cancelLoad()
    }

    override fun deliverResult(data: List<DesingInfo>) {
        if (isReset) {
            return
        }
        if (mList != null) mList = null
        mList = data
        if (isStarted) {
            super.deliverResult(data)
        }
    }

    override fun onReset() {
        super.onReset()
        onStopLoading()
        if (mList != null) {
            mList = null
        }
    }

    companion object {
        private val TAG = ContentLoader::class.simpleName
    }
}
