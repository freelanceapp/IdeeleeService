package snow.app.ideeleeservice.servicesnew;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.servicepackages.ServicePackages;
import snow.app.ideeleeservice.servicepackages.adapter.ServicePackagesAdapter;

public class OnDemandServices extends Activity {
RecyclerView recyclerView;
ArrayList<String> serviceproviderlist;
    ImageView backbutton1;
    TextView title,select_cat,select_subcat,request_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_demand_services);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        backbutton1=(ImageView)findViewById(R.id.back);
        title=(TextView)findViewById(R.id.title);
        select_cat=(TextView)findViewById(R.id.select_cat);
        select_subcat=(TextView)findViewById(R.id.select_subcat);

        title.setText("On Demand Services");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.ondemandservices);
        serviceproviderlist = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager
                (OnDemandServices.this, LinearLayoutManager.VERTICAL, false));
        serviceproviderlist.add("Car Rental");
        serviceproviderlist.add("Convertible /Roadster");
        serviceproviderlist.add("Station Wagon");
        serviceproviderlist.add("Small Car");
        serviceproviderlist.add("Sports Car/Coupe");
        serviceproviderlist.add("Limousine");
        serviceproviderlist.add("SUV/off-road vehicle/pickup");
        serviceproviderlist.add("Van");
        OnDemandServiceAdapter adapter = new OnDemandServiceAdapter(OnDemandServices.this,
                serviceproviderlist);
        recyclerView.setAdapter(adapter);

        select_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleSearchDialogCompat(OnDemandServices.this, "Search...",
                        "What are you looking for...?", null, createSampleData(),
                        new SearchResultListener<SampleSearchModel>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat dialog,
                                                   SampleSearchModel item, int position) {
                                Toast.makeText(OnDemandServices.this, item.getTitle(),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                select_cat.setText(item.getTitle());

                                recyclerView.setVisibility(View.VISIBLE);
                                select_subcat.setVisibility(View.VISIBLE);
                            }
                        }).show();
            }
        });

    }

    private ArrayList<SampleSearchModel> createSampleData(){
        ArrayList<SampleSearchModel> items = new ArrayList<>();
        items.add(new SampleSearchModel("Vehicle Service"));
        items.add(new SampleSearchModel("Shopping & Delivery Services"));
        items.add(new SampleSearchModel("Vehicle Service"));
        items.add(new SampleSearchModel("Shopping & Delivery Services"));

        return items;
    }
}
