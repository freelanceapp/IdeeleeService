package snow.app.ideeleeservice.extrafiles;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import snow.app.ideeleeservice.R;

/*import android.widget.CalendarView;*/

public class BaseActivity extends Activity {
 //  CalendarPickerView  calendar;

    ProgressDialog dialog ;
    SessionManager sessionManager;
    String startDate, endDate,device_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(BaseActivity.this);
        sessionManager=new SessionManager(BaseActivity.this);
     //    dialog.setCancelable(false);


        dialog.getWindow()
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)
               );

        dialog.setContentView(R.layout.progressdialoglayout);
    }





    public void    createProgressDialog() {

        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
       // dialog.setCancelable(false);
        dialog.getWindow()
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.progressdialoglayout);

        dialog.setMessage("Please WAIT.....");

    }


    public void dismissProgressDialog(){


        try {
            dialog.dismiss();
        } catch (WindowManager.BadTokenException e) {

        }

        // dialog.setMessage(Message);


    }



    //getdevicetoken....

    public  String getDeviceToken(Context context){
        device_token = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        System.out.println("device toekn--" + device_token);


        return device_token;
    }

}