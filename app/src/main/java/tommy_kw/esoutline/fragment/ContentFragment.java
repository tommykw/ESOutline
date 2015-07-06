package tommy_kw.esoutline.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tommy_kw.esoutline.R;
import tommy_kw.esoutline.view.ContentRecyclerView;

/**
 * Created by tomita on 15/07/01.
 */
public class ContentFragment extends Fragment {
    private static final String TAG = ContentFragment.class.getSimpleName();

    private int mPosition = 0;
    private String mUrl = null;
    private String mClassName = null;

    private ContentRecyclerView mListView;
    private SwipeRefreshLayout mRefresh;

    public static ContentFragment newInstance(int position, String url, String className ) {
        ContentFragment fragment = new ContentFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        b.putString("url", url);
        b.putString("className", className);
        fragment.setArguments(b);


        return fragment;
    }

    public ContentFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt("position");
            mUrl = getArguments().getString("url");
            mClassName = getArguments().getString("className");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        findView(view);
        setEvent();
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    public void findView(View v){
        //mListView = (ContentRecyclerView)v.findViewById(R.id.list);
        mRefresh = (SwipeRefreshLayout)v.findViewById(R.id.refresh);
    }
    public void setEvent(){
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // reload
            }
        });
//        mListView.setContentRecyclerViewListener(new ContentRecyclerView.CustomRecyclerViewListener() {
//            @Override
//            public void openWebPage(String url) {
//            }
//        });
    }
}
