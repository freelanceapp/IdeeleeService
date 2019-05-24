package snow.app.ideeleeservice.servicesnew;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.servicepackages.ServicePackages;
import snow.app.ideeleeservice.servicepackages.adapter.ServicePackagesAdapter;
import snow.app.ideeleeservice.serviceselection.DelieveryService;

public class OnDemandServices extends Activity {
    @BindView(R.id.ondemandservices)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    @BindView(R.id.back)
    ImageView backbutton1;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.select_cat)
    TextView select_cat;
    @BindView(R.id.select_subcat)
    TextView select_subcat;
    @BindView(R.id.request_now)
    TextView request_now;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_demand_services);
        ButterKnife.bind(this);
        title.setText("On Demand Services");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
        request_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(OnDemandServices.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.request_category_pop);
                Button submit = dialog.findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * .50);

                dialog.getWindow().setLayout(width, height);
                dialog.show();


            }
        });
    }

    private ArrayList<SampleSearchModel> createSampleData() {
        ArrayList<SampleSearchModel> items = new ArrayList<>();
        items.add(new SampleSearchModel("Vehicle Service"));
        items.add(new SampleSearchModel("Shopping & Delivery Services"));
        items.add(new SampleSearchModel("Vehicle Service"));
        items.add(new SampleSearchModel("Shopping & Delivery Services"));

        return items;
    }
}
