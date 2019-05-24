package snow.app.ideeleeservice.otp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.address.AddAddress;


public class OTP extends Activity {
@BindView(R.id.ux_btn_continue_otpPage) Button btn_continue_otpPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        btn_continue_otpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_continue=new Intent(OTP.this, AddAddress.class);
                startActivity(intent_continue);
            }
        });
    }

}
