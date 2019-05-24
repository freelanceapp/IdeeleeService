package snow.app.ideeleeservice.servicepricing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.servicepricing.adapter.ActiveServiceAdapter;

public class ServicePricingActivity extends AppCompatActivity {
    @BindView(R.id.service_rv) RecyclerView service_rv;
    ActiveServiceAdapter activeServiceAdapter;
   @BindView(R.id.title) TextView title;
@BindView(R.id.back)
    ImageView backbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_pricing);
        ButterKnife.bind(this);
        service_rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> data = new ArrayList<String>();
        data.add("Car Repairing");
        data.add("Home Cleaning");
        data.add("Electrician");
        activeServiceAdapter = new ActiveServiceAdapter(this, data);
        service_rv.setAdapter(activeServiceAdapter);
        activeServiceAdapter.notifyDataSetChanged();

       backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText(getString(R.string.service_pricing));


    }
}
