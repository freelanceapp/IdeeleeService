package snow.app.ideeleeservice.coupons;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;

public class CouponDetails extends AppCompatActivity {
    ImageView backbutton1;
     TextView title_bookingappointement, coupondetail;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_details);
        backbutton1 = findViewById(R.id.back);
        title_bookingappointement = (TextView) findViewById(R.id.title);
        coupondetail = findViewById(R.id.coupondetails);
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

         title_bookingappointement.setText("Coupon Details");


        coupondetail.setText(Html.fromHtml("<p style=\"color: #5e9ca0;\"><span style=\"color: #000000;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</span></p>\n" +
                "<ul>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "<li><span style=\"color: #999999;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</span></li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>", Html.FROM_HTML_MODE_COMPACT));

    }
}
