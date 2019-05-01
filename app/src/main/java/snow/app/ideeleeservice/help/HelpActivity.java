package snow.app.ideeleeservice.help;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;


public class HelpActivity extends AppCompatActivity {

    ImageView backbutton1;
    ImageView notification;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        backbutton1=(ImageView)findViewById(R.id.backbutton1);
        notification=(ImageView)findViewById(R.id.notification);
        title=(TextView) findViewById(R.id.title_bookingappointement);
        title.setText("Help");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
