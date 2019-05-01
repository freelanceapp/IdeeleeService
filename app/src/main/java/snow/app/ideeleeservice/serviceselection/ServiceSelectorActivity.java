package snow.app.ideeleeservice.serviceselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.serviceselection.adapter.DeliveryServiceAdapter;
import snow.app.ideeleeservice.serviceselection.adapter.OnDemandAdapter;

public class ServiceSelectorActivity extends AppCompatActivity {
    RecyclerView ondemand_rv,delivery_rv;
    TextView more_delivery;
    TextView more_ondemand;
    TextView skip;
    OnDemandAdapter onDemandAdapter;
    DeliveryServiceAdapter deliveryServiceAdapter;
    List<String> productList= new ArrayList<>();
    List<String> del_list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_selector);
        ondemand_rv=findViewById(R.id.ondemand_rv);
        delivery_rv=findViewById(R.id.delivery_rv);
        more_delivery=findViewById(R.id.more_delivery);
        more_ondemand=findViewById(R.id.more_ondemand);
        skip=findViewById(R.id.skip);
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
    }
}
