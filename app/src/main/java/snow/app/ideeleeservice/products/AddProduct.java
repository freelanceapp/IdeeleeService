package snow.app.ideeleeservice.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;

public class AddProduct extends AppCompatActivity {

   @BindView(R.id.title) TextView title;
   @BindView(R.id.continue_addproduct) Button continue_addproduct;
   @BindView(R.id.back) ImageView backbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
        title.setText(getString(R.string.add_product));
        backbutton1.setOnClickListener(new View.OnClickListener() {
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
