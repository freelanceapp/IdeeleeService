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

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.adapter.OrderAdapter;
import snow.app.ideeleeservice.services.adapter.ManageServicesAdapter;

public class Services extends AppCompatActivity {
    ManageServicesAdapter adapter;
   @BindView
  (R.id.pager) ViewPager viewPager;
@BindView(R.id.tab_layout) TabLayout tabLayout;
   @BindView(R.id.back) ImageView backbutton1;
    @BindView(R.id.notification) ImageView notification;
    @BindView(R.id.title) TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ButterKnife.bind(this);
        tabLayout.addTab(tabLayout.newTab().setText("On Demand Services"));
        tabLayout.addTab(tabLayout.newTab().setText("Delivery Services"));
        title.setText("Manage Services");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
