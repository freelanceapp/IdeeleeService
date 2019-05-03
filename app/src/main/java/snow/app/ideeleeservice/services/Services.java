package snow.app.ideeleeservice.services;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.adapter.OrderAdapter;
import snow.app.ideeleeservice.services.adapter.ManageServicesAdapter;

public class Services extends AppCompatActivity {
    ManageServicesAdapter adapter;
    ViewPager viewPager;
TabLayout tabLayout;
    ImageView backbutton1;
    ImageView notification;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

         tabLayout = (TabLayout)findViewById(R.id.tab_layout);
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
       // tabLayout.setupWithViewPager(viewPager);

       // setupTabIcons();
    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(Services.this).inflate(R.layout.tab_tv, null);
        tabOne.setText("On Demand Services");
        tabOne.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.text_size_13sp));
        tabLayout.getTabAt(0).setCustomView(tabOne);


        TextView tabTwo = (TextView) LayoutInflater.from(Services.this).inflate(R.layout.tab_tv, null);
        tabTwo.setText("Delivery Services");
        tabTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.text_size_13sp));
        tabLayout.getTabAt(1).setCustomView(tabTwo);


    }
}
