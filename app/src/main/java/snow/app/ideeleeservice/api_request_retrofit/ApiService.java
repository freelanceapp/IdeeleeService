package snow.app.ideeleeservice.api_request_retrofit;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import snow.app.ideeleeservice.responses.confirmotpresponse.ConfirmOtpRes;
import snow.app.ideeleeservice.responses.forgotpassword.ForgotPassRes;

import snow.app.ideeleeservice.responses.loginres.LoginRes;
import snow.app.ideeleeservice.responses.logoutres.LogoutRes;
import snow.app.ideeleeservice.responses.registerres.RegisterRes;

import static snow.app.ideeleeservice.extrafiles.AppConstants.*;


public interface ApiService {


    //register api
    @POST(REGISTER)
    @FormUrlEncoded
    Observable<RegisterRes> registerUser(@FieldMap HashMap<String, String> params);

    //otp api
    @POST(CONFIRM_OTP)
    @FormUrlEncoded
    Observable<ConfirmOtpRes> confirmOtp(@FieldMap HashMap<String, String> params);


    //login api
    @POST(LOGIN)
    @FormUrlEncoded
    Observable<LoginRes> loginUser(@FieldMap HashMap<String, String> params);


    //logout api
    @POST(LOGOUT)
    @FormUrlEncoded
    Observable<LogoutRes> logoutUser(@FieldMap HashMap<String, String> params);


    //forgot password api
    @POST(FORGOT_PASSWORD)
    @FormUrlEncoded
    Observable<ForgotPassRes> forgotpass(@FieldMap HashMap<String, String> params);



}