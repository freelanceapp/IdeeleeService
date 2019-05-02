package snow.app.ideeleeservice.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;

public class AddProduct extends AppCompatActivity {
    ImageView backbutton1;
    ImageView notification;
    TextView title;
    Button btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        backbutton1=(ImageView)findViewById(R.id.backbutton1);
        notification=(ImageView)findViewById(R.id.notification);
        title=(TextView) findViewById(R.id.title_bookingappointement);
        title.setText("Add Product");
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
