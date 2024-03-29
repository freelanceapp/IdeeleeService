package snow.app.ideeleeservice.coupons;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.coupons.adapter.CouponCatAdapter;
import snow.app.ideeleeservice.home.accepted.adapter.AcceptedJobAdapter;

public class SelectCouponCat extends Activity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    @BindView(R.id.back)
    ImageView backbutton1;
    @BindView(R.id.notification)
    ImageView notification;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_coupon_cat);
        ButterKnife.bind(this);
        title.setText("Select Coupon Category");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        serviceproviderlist = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(SelectCouponCat.this, LinearLayoutManager.VERTICAL, false));
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
        serviceproviderlist.add("Education");
        serviceproviderlist.add("Lifestyle");
        serviceproviderlist.add("Vehicles");
        serviceproviderlist.add("Food");
        serviceproviderlist.add("Education");
        serviceproviderlist.add("Lifestyle");
        serviceproviderlist.add("Vehicles");
        serviceproviderlist.add("Food");
        serviceproviderlist.add("Education");
        serviceproviderlist.add("Lifestyle");
        serviceproviderlist.add("Vehicles");
        serviceproviderlist.add("Food");
        serviceproviderlist.add("Education");
        serviceproviderlist.add("Lifestyle");
        serviceproviderlist.add("Vehicles");
        serviceproviderlist.add("Food");

        CouponCatAdapter adapter = new CouponCatAdapter(SelectCouponCat.this, serviceproviderlist);
        recyclerView.setAdapter(adapter);

    }
}
