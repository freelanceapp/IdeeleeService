package snow.app.ideeleeservice.coupons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import snow.app.ideeleeservice.R;

public class SelectCouponLyout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_coupon_lyout);
        TextView btn = findViewById(R.id.btn);
        TextView tv=findViewById(R.id.title);
        tv.setText(getString(R.string.cpn_layout));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectCouponLyout.this, AddCustomCoupon.class));
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
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
