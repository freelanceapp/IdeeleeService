package snow.app.ideeleeservice.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.otp.OTP;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.register.Register;
import snow.app.ideeleeservice.forgot.ForgotPassword;

public class Login extends Activity {


    @BindView(R.id.ux_txt_registernow_loginPage)
    TextView txt_registernow_loginPage;
    @BindView(R.id.ux_btn_continue_loginPage)
    Button btn_continue_loginPage;
    @BindView(R.id.forgot)
    TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        txt_registernow_loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register = new Intent(Login.this, Register.class);
                startActivity(intent_register);
            }
        });
        btn_continue_loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_continue = new Intent(Login.this, OTP.class);
                startActivity(intent_continue);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_continue = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent_continue);
            }
        });
    }

}
