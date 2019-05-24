package snow.app.ideeleeservice.stores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.accepted.adapter.AcceptedJobAdapter;
import snow.app.ideeleeservice.stores.adapter.StoreAdapter;

public class Stores extends AppCompatActivity {
    @BindView
            (R.id.recyclerView_store)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    @BindView(R.id.back)
    ImageView backbutton1;
    @BindView(R.id.notification)
    ImageView notification;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.addnew)
    Button addnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        ButterKnife.bind(this);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Stores.this, StoreDetails.class));
            }
        });
        title.setText("Stores");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        serviceproviderlist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(Stores.this, LinearLayoutManager.VERTICAL, false));
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "Pending", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "Online Payment"));
//
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "Accept", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "cash on delivery"));
//
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "On Going", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "Online payment"));
//        //
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");


        StoreAdapter adapter = new StoreAdapter(Stores.this, serviceproviderlist);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
