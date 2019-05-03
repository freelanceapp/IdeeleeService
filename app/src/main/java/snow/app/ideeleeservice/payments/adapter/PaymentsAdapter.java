package snow.app.ideeleeservice.payments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import snow.app.ideeleeservice.payments.received.fragment.ReceivedFragment;
import snow.app.ideeleeservice.payments.withdrawl.fragment.WithdrawlFragement;
import snow.app.ideeleeservice.services.deliveryservices.fragments.DeliveryFragment;
import snow.app.ideeleeservice.services.ondemandservices.fragment.OnDemandFragment;


public class PaymentsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PaymentsAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ReceivedFragment tab1 = new ReceivedFragment();
                return tab1;
            case 1:
                WithdrawlFragement tab2 = new WithdrawlFragement();
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