package snow.app.ideeleeservice.services;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.adapter.OrderAdapter;
import snow.app.ideeleeservice.services.adapter.ManageServicesAdapter;

public class Services extends AppCompatActivity {
    ManageServicesAdapter adapter;
    ViewPager viewPager;

    ImageView backbutton1;
    ImageView notification;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("On Demand Services"));
        tabLayout.addTab(tabLayout.newTab().setText("Delivery Services"));
        backbutton1=(ImageView)findViewById(R.id.back);
        notification=(ImageView)findViewById(R.id.notification);
        title=(TextView) findViewById(R.id.title);
        title.setText("Manage Services");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new ManageServicesAdapter
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
    }
}
