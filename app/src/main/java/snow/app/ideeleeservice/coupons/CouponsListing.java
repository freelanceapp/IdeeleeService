package snow.app.ideeleeservice.coupons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import java.util.ArrayList;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.coupons.adapter.CouponsListAdapter;
import snow.app.ideeleeservice.products.AddProduct;
import snow.app.ideeleeservice.products.productlist.ProductListActivity;
import snow.app.ideeleeservice.products.productlist.adapter.ProductsAdapter;

public class CouponsListing extends AppCompatActivity {
    TextView title;
    RecyclerView recyclerView;
    Button add_product;
    CouponsListAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons_listing);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title = findViewById(R.id.title);
        add_product = findViewById(R.id.add_product);
        recyclerView = findViewById(R.id.recyclerView);
        title.setText(getString(R.string.product_list));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CouponsListing.this, SelectCouponLyout.class));
            }
        });
        productsAdapter = new CouponsListAdapter(this, new ArrayList<String>());
        recyclerView.setAdapter(productsAdapter);
        productsAdapter.notifyDataSetChanged();
    }
}
