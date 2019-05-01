package snow.app.ideeleeservice.otp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.address.AddAddress;


public class OTP extends Activity {
Button btn_continue_otpPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        btn_continue_otpPage=findViewById(R.id.ux_btn_continue_otpPage);
        btn_continue_otpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_continue=new Intent(OTP.this, AddAddress.class);
                startActivity(intent_continue);
            }
        });
    }

}
