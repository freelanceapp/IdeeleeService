package snow.app.ideeleeservice.servicepricing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.servicepricing.adapter.ActiveServiceAdapter;

public class ServicePricingActivity extends AppCompatActivity {
    RecyclerView service_rv;
    ActiveServiceAdapter activeServiceAdapter;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_pricing);
        service_rv = (RecyclerView) findViewById(R.id.service_rv);
        title = findViewById(R.id.title);
        service_rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> data = new ArrayList<String>();
        data.add("Car Repairing");
        data.add("Home Cleaning");
        data.add("Electrician");
        activeServiceAdapter = new ActiveServiceAdapter(this, data);
        service_rv.setAdapter(activeServiceAdapter);
        activeServiceAdapter.notifyDataSetChanged();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText(getString(R.string.service_pricing));


    }
}
