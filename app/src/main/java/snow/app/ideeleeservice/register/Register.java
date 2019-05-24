package snow.app.ideeleeservice.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.login.Login;

public class Register extends Activity {
  @BindView
(R.id.ux_txt_loginnow_registerPage)  TextView txt_loginnow_registerPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        txt_loginnow_registerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login=new Intent(Register.this, Login.class);
                startActivity(intent_login);
            }
        });
    }

}
