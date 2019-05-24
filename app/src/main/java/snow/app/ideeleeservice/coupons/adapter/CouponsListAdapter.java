package snow.app.ideeleeservice.coupons.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.coupons.CouponDetails;


public class CouponsListAdapter extends RecyclerView.Adapter<CouponsListAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public CouponsListAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.coupons_list_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position


    }


    @Override
    public int getItemCount() {
        return 10;
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.edit)
        LinearLayout edit;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCtx.startActivity(new Intent(mCtx, CouponDetails.class));

                }
            });


        }
    }
}