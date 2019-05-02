package snow.app.ideeleeservice.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import snow.app.ideeleeservice.home.accepted.AcceptedOrderFragment;
import snow.app.ideeleeservice.home.completed.CompletedOrderFragment;
import snow.app.ideeleeservice.home.progressfra.ProgressOrderFragment;
import snow.app.ideeleeservice.home.neworder.NewOrderFragment;


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
                ProgressOrderFragment tab3= new ProgressOrderFragment();
                return tab3;
            case 3:
                CompletedOrderFragment tab4= new CompletedOrderFragment();
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