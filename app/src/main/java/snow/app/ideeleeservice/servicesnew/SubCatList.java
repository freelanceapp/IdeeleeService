package snow.app.ideeleeservice.servicesnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.serviceselection.adapter.DeliveryServiceAdapter;

public class SubCatList extends AppCompatActivity {
    RecyclerView rv;
    SubCatListAdapter onDemandAdapter;
    TextView title;
    Button addservice;
    TextView request_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_cat_list);
        rv = (RecyclerView) findViewById(R.id.subcatlist);
        title =  findViewById(R.id.title);
        request_now =  findViewById(R.id.request_now);
        addservice =  findViewById(R.id.addservice);
        title.setText("Car Rental");
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> del_list = new ArrayList<>();
        del_list.add("Car Rental");
        del_list.add("Convertible /Roadster");
        del_list.add("Station Wagon");
        del_list.add("Small Car");
        del_list.add("Sports Car/Coupe");
        del_list.add("Limousine");
        del_list.add("SUV/off-road vehicle/pickup");
        del_list.add("Van");

        onDemandAdapter = new SubCatListAdapter(this, del_list);
        rv.setAdapter(onDemandAdapter);
        onDemandAdapter.notifyDataSetChanged();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        addservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubCatList.this, HomeNavigation.class);
                startActivity(intent);
            }
        });
    }
}
