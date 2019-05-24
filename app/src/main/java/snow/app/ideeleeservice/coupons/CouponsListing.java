package snow.app.ideeleeservice.coupons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.coupons.adapter.CouponsListAdapter;
import snow.app.ideeleeservice.products.AddProduct;
import snow.app.ideeleeservice.products.productlist.ProductListActivity;
import snow.app.ideeleeservice.products.productlist.adapter.ProductsAdapter;

public class CouponsListing extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.add_product)
    Button add_product;
    @BindView(R.id.back)
    ImageView backbutton1;
    CouponsListAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons_listing);
        ButterKnife.bind(this);
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText(getString(R.string.coupons));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CouponsListing.this, SelectCouponCat.class));
            }
        });
        productsAdapter = new CouponsListAdapter(this, new ArrayList<String>());
        recyclerView.setAdapter(productsAdapter);
        productsAdapter.notifyDataSetChanged();
    }
}
