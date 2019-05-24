package snow.app.ideeleeservice.serviceselection;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.serviceselection.adapter.OnDemandAdapter;
import snow.app.ideeleeservice.servicesnew.SubCatList;

public class MoreOnDemand extends AppCompatActivity {
    @BindView
            (R.id.rv)
    RecyclerView rv;
    OnDemandAdapter onDemandAdapter;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.txt_continue)
    TextView txt_continue;
    @BindView(R.id.request_now)
    TextView request_now;
@BindView(R.id.back)
    ImageView backbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_on_demand);
        ButterKnife.bind(this);
        //title.setText(getString(R.string.on_demand));
        title.setText("Car Rental");
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> productList = new ArrayList<>();
//        productList.add("Home Cleaning");
//        productList.add("Car Repairing");
//        productList.add("Electrician");
//        productList.add("Plumber");
//        productList.add("Home Cleaning");
//        productList.add("Car Repairing");
//        productList.add("Electrician");
//        productList.add("Plumber");

        productList.add("Car Rental");
        productList.add("Convertible /Roadster");
        productList.add("Station Wagon");
        productList.add("Small Car");
        productList.add("Sports Car/Coupe");
        productList.add("Limousine");
        productList.add("SUV/off-road vehicle/pickup");
        productList.add("Van");


        txt_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreOnDemand.this, SubCatList.class));
            }
        });
        onDemandAdapter = new OnDemandAdapter(this, productList);
        rv.setAdapter(onDemandAdapter);
        onDemandAdapter.notifyDataSetChanged();
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        request_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MoreOnDemand.this);
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
}
