package tommy_kw.esoutline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import tommy_kw.esoutline.DesingInfo;
import tommy_kw.esoutline.fragment.ContentFragment;

/**
 * Created by tomita on 15/07/01.
 */
public class TabFragmentPagerAdapter  extends FragmentPagerAdapter {
    private List<DesingInfo> mList = null;

    public TabFragmentPagerAdapter(FragmentManager fm, List<DesingInfo> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        if(mList == null ) return null;
        if( mList.size() <= position ) return null;
        DesingInfo item = mList.get(position);
        ContentFragment fragment = new ContentFragment();
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
