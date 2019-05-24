package snow.app.ideeleeservice.payments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.payments.adapter.PaymentsAdapter;
import snow.app.ideeleeservice.services.adapter.ManageServicesAdapter;

public class Payments extends AppCompatActivity {
    PaymentsAdapter adapter;
    @BindView(R.id.pager) ViewPager viewPager;

    @BindView(R.id.back) ImageView backbutton1;
    @BindView(R.id.notification) ImageView notification;
    @BindView(R.id.title) TextView title;
   @BindView(R.id.tab_layout) TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        ButterKnife.bind(this);
        tabLayout.addTab(tabLayout.newTab().setText("Received"));
        tabLayout.addTab(tabLayout.newTab().setText("Withdrawl"));
        title.setText("Payments");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        adapter = new PaymentsAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
      //  tabLayout.setupWithViewPager(viewPager);
      //  setupTabIcons();
    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(Payments.this).inflate(R.layout.tab_tv, null);
        tabOne.setText("Received");
        tabLayout.getTabAt(0).setCustomView(tabOne);
        TextView tabTwo = (TextView) LayoutInflater.from(Payments.this).inflate(R.layout.tab_tv, null);
        tabTwo.setText("Withdrawl");
        tabLayout.getTabAt(1).setCustomView(tabTwo);




    }

}
