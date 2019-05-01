package snow.app.ideeleeservice.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class OrderAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public OrderAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
//            case 0:
//                ActiveJobFragment tab1 = new ActiveJobFragment();
//                return tab1;
//            case 1:
//                CompletedJobFragment tab2 = new CompletedJobFragment();
//                return tab2;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}