package snow.app.ideeleeservice.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;

public class AddProductDetails extends AppCompatActivity {
   @BindView
  (R.id.back) ImageView backbutton1;
   @BindView(R.id.notification) ImageView notification;
   @BindView(R.id.title) TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_details);
        ButterKnife.bind(this);
        title.setText(getString(R.string.pd_details));
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }
}
