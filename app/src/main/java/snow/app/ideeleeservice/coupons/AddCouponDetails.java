package snow.app.ideeleeservice.coupons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;

public class AddCouponDetails extends AppCompatActivity {

    @BindView(R.id.title) TextView tv;
    @BindView(R.id.back) ImageView backbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coupon_details);
        ButterKnife.bind(this);
        tv.setText(getString(R.string.add_cpn));
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
