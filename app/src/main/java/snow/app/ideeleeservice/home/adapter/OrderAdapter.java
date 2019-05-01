package snow.app.ideeleeservice.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import snow.app.ideeleeservice.home.fragment.AcceptedOrderFragment;
import snow.app.ideeleeservice.home.fragment.InProgressOrderFragment;
import snow.app.ideeleeservice.home.fragment.NewOrderFragment;


public class OrderAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public OrderAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                NewOrderFragment tab1 = new NewOrderFragment();
                return tab1;
            case 1:
                AcceptedOrderFragment tab2 = new AcceptedOrderFragment();
                return tab2;
            case 2:
                InProgressOrderFragment tab3= new InProgressOrderFragment();
                return tab3;
            case 3:
                InProgressOrderFragment tab4= new InProgressOrderFragment();
                return tab4;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}