package snow.app.ideeleeservice.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import snow.app.ideeleeservice.api_request_retrofit.ApiService;
import snow.app.ideeleeservice.api_request_retrofit.retrofit_client.ApiClient;
import snow.app.ideeleeservice.extrafiles.AppConstants;
import snow.app.ideeleeservice.extrafiles.BaseActivity;
import snow.app.ideeleeservice.extrafiles.OneTimeLogin;
import snow.app.ideeleeservice.extrafiles.SessionManager;
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.otp.OTP;
import snow.app.ideeleeservice.R;

import snow.app.ideeleeservice.forgot.ForgotPassword;

import snow.app.ideeleeservice.register.Register;
import snow.app.ideeleeservice.responses.loginres.LoginRes;

public class Login extends BaseActivity {


    @BindView(R.id.ux_txt_registernow_loginPage)
    TextView txt_registernow_loginPage;
    @BindView(R.id.ux_btn_continue_loginPage)
    Button btn_continue_loginPage;
    @BindView(R.id.forgot)
    TextView forgot;
    @BindView(R.id.fblogin)
    Button fblogin;
    @BindView(R.id.login_button)
    LoginButton loginButton;

    @BindView(R.id.email)
    EditText et_email;
    @BindView(R.id.password)
    EditText et_pass;
    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    ApiService apiService;
    String device_token;
    HashMap<String, String> map;
    OneTimeLogin oneTimeLogin;
SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        oneTimeLogin=new OneTimeLogin(Login.this);
        apiService = ApiClient.getClient(getApplicationContext())
                .create(ApiService.class);

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


                //Toast.makeText(Login.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent_continue = new Intent(Login.this, HomeNavigation.class);
                startActivity(intent_continue);
                finish();
              //  handleLogin();

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_continue = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent_continue);
            }
        });

        if (!oneTimeLogin.isFirstTimeLaunch()) {
            Intent intent_continue = new Intent(Login.this, HomeNavigation.class);
            startActivity(intent_continue);
            finish();
        }
        /**
         * facebook login
         */

        FacebookSdk.sdkInitialize(getApplicationContext());
        // AppEventsLogger.activateApp(MainActivity.this);
        callbackManager = CallbackManager.Factory.create();





        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Intent intent_continue = new Intent(Login.this, OTP.class);
                startActivity(intent_continue);

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

/**
 * facebook login
 */


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void onClick(View v) {
        if (v == fblogin) {
            loginButton.performClick();
        }
    }

    // login  api service provider

    public void loginUser(HashMap<String, String> map) {
        createProgressDialog();

        Observer<LoginRes> observer = apiService.loginUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<LoginRes>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginRes res) {


                        Toast.makeText(Login.this, "apiii", Toast.LENGTH_SHORT).show();

                        if (res.getStatus()) {

                            if (res.getMessage().equals("User is not active")) {
                                AppConstants.LoginProcess.mUserIdForActivationAccountAfterOTPVerification =
                                        String.valueOf(res.getUserdata().getId());
                                AppConstants.LoginProcess.mMobileNumber = "+" + res.getUserdata().getContactNo();

                                // after successfull  register then hit otp confirmation mobile verification
                                openActivity(AppConstants.LoginProcess.mMobileNumber, AppConstants.OTPVerification.INTENT_METHOD);

                            } else {

                                SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                editor.putString("userid", res.getUserdata().getId());
                                editor.putString("token", res.getUserdata().getToken());
                                editor.commit();

                                oneTimeLogin.setFirstTimeLaunch(false);

//                                sessionManager.createLoginSession(res.getUserdata().getName(),
//                                        res.getUserdata().getEmail(), res.getUserdata().getPassword(), res.getUserdata().getContactNo(), res.getUserdata().getId(),
//                                        res.getUserdata().getStatus(), res.getUserdata().getAddress(), res.getUserdata().getProfileImage(),
//                                        res.getUserdata().getType(), res.getUserdata().getToken());
//

                                Toast.makeText(Login.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                                Intent intent_continue = new Intent(Login.this, HomeNavigation.class);
                                startActivity(intent_continue);
                                finish();

                            }

                        }
                        else {
                            Toast.makeText(Login.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissProgressDialog();

                    }

                    @Override
                    public void onComplete() {
                        dismissProgressDialog();

                    }
                });


    }

    private void openActivity(String phoneNumber, String method) {
        Intent verification = new Intent(this, OTP.class);
        verification.putExtra(AppConstants.OTPVerification.INTENT_PHONENUMBER, phoneNumber);
        verification.putExtra(AppConstants.OTPVerification.INTENT_METHOD, method);
        startActivity(verification);
    }

    private void handleLogin() {
        String email = et_email.getText().toString();
        //  String l_name = edt_last_name.getText().toString();


        String pass = et_pass.getText().toString();
        if (email.isEmpty()) {
            et_email.setError("Enter email");
        } else if (pass.isEmpty()) {
            et_pass.setError("Enter password");
        } else {


            createProgressDialog();
            map = new HashMap<>();
            map.put("email", et_email.getText().toString());
            map.put("password", et_pass.getText().toString());
            map.put("device_type", "Android");
            map.put("device_token", device_token);
            map.put("usertype", "2");

            Log.e("params login", et_email.getText().toString() + et_pass.getText().toString() + device_token);
            loginUser(map);
        }
    }






}
