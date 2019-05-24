package snow.app.ideeleeservice.coupons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;

public class SelectCouponLyout extends AppCompatActivity {
    @BindView(R.id.btn)
    TextView btn;
    @BindView(R.id.title)
    TextView tv;
    @BindView(R.id.back)
    ImageView backbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_coupon_lyout);
        ButterKnife.bind(this);
        tv.setText(getString(R.string.cpn_layout));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectCouponLyout.this, AddCustomCoupon.class));
            }
        });

        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void handleBannerClick(View view) {
        startActivity(new Intent(SelectCouponLyout.this, AddCouponDetails.class));
    }
}
