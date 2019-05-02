package snow.app.ideeleeservice.services.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import snow.app.ideeleeservice.home.accepted.AcceptedOrderFragment;
import snow.app.ideeleeservice.home.completed.CompletedOrderFragment;
import snow.app.ideeleeservice.home.neworder.NewOrderFragment;
import snow.app.ideeleeservice.home.progressfra.ProgressOrderFragment;
import snow.app.ideeleeservice.services.deliveryservices.fragments.DeliveryFragment;
import snow.app.ideeleeservice.services.ondemandservices.fragment.OnDemandFragment;


public class ManageServicesAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ManageServicesAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OnDemandFragment tab1 = new OnDemandFragment();
                return tab1;
            case 1:
                DeliveryFragment tab2 = new DeliveryFragment();
                return tab2;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}