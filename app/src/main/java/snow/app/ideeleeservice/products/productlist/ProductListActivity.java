package snow.app.ideeleeservice.products.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.products.AddProduct;
import snow.app.ideeleeservice.products.productlist.adapter.ProductsAdapter;

public class ProductListActivity extends AppCompatActivity {
    @BindView(R.id.title) TextView title;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
   @BindView(R.id.add_product) Button add_product;
   @BindView(R.id.back)
   ImageView back;
    ProductsAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText(getString(R.string.product_list));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this, AddProduct.class));
            }
        });
        productsAdapter = new ProductsAdapter(this, new ArrayList<String>());
        recyclerView.setAdapter(productsAdapter);
        productsAdapter.notifyDataSetChanged();
    }
    }



