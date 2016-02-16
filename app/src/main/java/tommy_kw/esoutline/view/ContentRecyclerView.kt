package tommy_kw.esoutline.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

import java.util.ArrayList

import tommy_kw.esoutline.ContentLoader
import tommy_kw.esoutline.DesingInfo
import tommy_kw.esoutline.R
import tommy_kw.esoutline.adapter.ContentRecyclerViewAdapter

import tommy_kw.esoutline.R.*

/**
 * Created by tomita on 15/07/01.
 */
class ContentRecyclerView : RecyclerView, LoaderManager.LoaderCallbacks<List<DesingInfo>> {
    interface ContentRecyclerViewListener {
        fun openWebPage(url: String)
    }

    private var mListener: ContentRecyclerViewListener? = null
    private val mAdapter: ContentRecyclerViewAdapter? = null
    private var mRefresh: SwipeRefreshLayout? = null

    override fun onCreateLoader(id: Int, args: Bundle): Loader<List<DesingInfo>> {
        val url = args.getString("url")
        val className = args.getString("className")
        return ContentLoader(context, url, className)
    }

    override fun onLoadFinished(loader: Loader<List<DesingInfo>>, data: List<DesingInfo>) {
    }

    override fun onLoaderReset(loader: Loader<List<DesingInfo>>) {
        if (mRefresh != null) mRefresh!!.isRefreshing = false
    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    fun setSwipeRefreshLayout(refresh: SwipeRefreshLayout) {
        mRefresh = refresh
    }

    fun setContentRecyclerViewListener(listener: ContentRecyclerViewListener) {
        mListener = listener
    }
}