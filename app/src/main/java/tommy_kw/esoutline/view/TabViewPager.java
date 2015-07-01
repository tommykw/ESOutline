package tommy_kw.esoutline.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.List;

import tommy_kw.esoutline.DesingInfo;
import tommy_kw.esoutline.fragment.ContentFragment;

/**
 * Created by tomita on 15/07/01.
 */
public class TabViewPager extends ViewPager {
    private CustomFragmentPagerAdapter mAdapter;

    public TabViewPager(Context context) {
        super(context);
    }

    public TabViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public TabViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }

    public void uninitialize(){
        mAdapter = null;
    }

    public void setAdapter(FragmentManager fm, List<DesingInfo> list){
        mAdapter = new CustomFragmentPagerAdapter(fm, list);
        setAdapter(mAdapter);
    }

    public static class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<DesingInfo>  mList = null;
        public CustomFragmentPagerAdapter(FragmentManager fm, List<DesingInfo> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            if(mList == null ) return null;
            if( mList.size() <= position ) return null;
            DesingInfo item = mList.get(position);
            ContentFragment fragment = ContentFragment.newInstance(position, item.getApi(), item.getClassName());
            return fragment;
        }
        @Override
        public int getCount() {
            if( mList == null ){
                return 0;
            }
            return mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            DesingInfo item = mList.get(position);
            return item.getLabel();
        }
    }
}
