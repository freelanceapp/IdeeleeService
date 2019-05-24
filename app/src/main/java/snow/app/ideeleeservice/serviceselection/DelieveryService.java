package snow.app.ideeleeservice.serviceselection;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.serviceselection.adapter.DeliveryServiceAdapter;
import snow.app.ideeleeservice.serviceselection.adapter.OnDemandAdapter;

public class DelieveryService extends AppCompatActivity {
    @BindView(R.id.rv)
    RecyclerView rv;
    DeliveryServiceAdapter onDemandAdapter;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.proceed)
    TextView proceed;
    @BindView(R.id.request_now)
    TextView request_now;
    @BindView(R.id.back)
    ImageView backbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delievery_service);
        ButterKnife.bind(this);
        title.setText(getString(R.string.delivery_services));
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> del_list = new ArrayList<>();
        del_list.add("Food Delivery");
        del_list.add("Gift Delivery");
        del_list.add("Liquid Delivery");

        onDemandAdapter = new DeliveryServiceAdapter(this, del_list);
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
                final Dialog dialog = new Dialog(DelieveryService.this);
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
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DelieveryService.this, HomeNavigation.class));
            }
        });
    }
}
