package snow.app.ideeleeservice.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.login.Login;

public class Splash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
      /*  mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);
        */

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, 2500);
     /*   new Thread(new Runnable() {
            public void run() {
                doWork();


            }
        }).start();*/
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(100);
               // mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(Splash.this, Login.class);
        startActivity(intent);
        finish();
    }

}
