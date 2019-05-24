package snow.app.ideeleeservice.serviceselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.serviceselection.adapter.DeliveryServiceAdapter;
import snow.app.ideeleeservice.serviceselection.adapter.OnDemandAdapter;

public class ServiceSelectorActivity extends AppCompatActivity {
    @BindView(R.id.ondemand_rv) RecyclerView ondemand_rv;
    @BindView(R.id.delivery_rv) RecyclerView delivery_rv;
    @BindView(R.id.more_delivery) TextView more_delivery;
    @BindView(R.id.more_ondemand) TextView more_ondemand;
    @BindView(R.id.skip) TextView skip;
    OnDemandAdapter onDemandAdapter;
    DeliveryServiceAdapter deliveryServiceAdapter;
    List<String> productList= new ArrayList<>();
    List<String> del_list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_selector);
        ButterKnife.bind(this);
        ondemand_rv.setLayoutManager(new LinearLayoutManager(this));
        delivery_rv.setLayoutManager(new LinearLayoutManager(this));
        productList.add("Home Cleaning");
        productList.add("Car Repairing");
        productList.add("Electrician");
        productList.add("Plumber");

        del_list.add("Food Delivery");
        del_list.add("Gift Delivery");
        del_list.add("Liquid Delivery");

        deliveryServiceAdapter= new DeliveryServiceAdapter(this,del_list);
        delivery_rv.setAdapter(deliveryServiceAdapter);

        onDemandAdapter= new OnDemandAdapter(this,productList);
        ondemand_rv.setAdapter(onDemandAdapter);
        onDemandAdapter.notifyDataSetChanged();
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceSelectorActivity.this, HomeNavigation.class));
            }
        });

        more_ondemand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceSelectorActivity.this, MoreOnDemand.class));
            }
        });

        more_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceSelectorActivity.this, DelieveryService.class));
            }
        });
    }
}
