package snow.app.ideeleeservice.payments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.payments.adapter.PaymentsAdapter;
import snow.app.ideeleeservice.services.adapter.ManageServicesAdapter;

public class Payments extends AppCompatActivity {
    PaymentsAdapter adapter;
    ViewPager viewPager;

    ImageView backbutton1;
    ImageView notification;
    TextView title;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
         tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Received"));
        tabLayout.addTab(tabLayout.newTab().setText("Withdrawl"));
        backbutton1=(ImageView)findViewById(R.id.back);
        notification=(ImageView)findViewById(R.id.notification);
        title=(TextView) findViewById(R.id.title);
        title.setText("Payments");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        viewPager = (ViewPager)findViewById(R.id.pager);
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
       // tabLayout.setupWithViewPager(viewPager);
       // setupTabIcons();
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
