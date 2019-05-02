package snow.app.ideeleeservice.servicepackages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;

public class MyPackageDetails extends AppCompatActivity {
    ImageView backbutton1;
    ImageView notification;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_package_details);
        backbutton1=(ImageView)findViewById(R.id.back);
        notification=(ImageView)findViewById(R.id.notification);
        title=(TextView) findViewById(R.id.title);
        title.setText("My Package");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
