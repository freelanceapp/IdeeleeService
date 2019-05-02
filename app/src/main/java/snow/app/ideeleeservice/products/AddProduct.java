package snow.app.ideeleeservice.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import snow.app.ideeleeservice.R;

public class AddProduct extends AppCompatActivity {

    ImageView notification;
    TextView title;
    Button continue_addproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        title=(TextView) findViewById(R.id.title);
        continue_addproduct=(Button) findViewById(R.id.continue_addproduct);
        title.setText(getString(R.string.add_product));
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        continue_addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(AddProduct.this,AddProductDetails.class));
            }
        });

    }
}
