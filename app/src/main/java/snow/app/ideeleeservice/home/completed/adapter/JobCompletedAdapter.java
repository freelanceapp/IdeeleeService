package snow.app.ideeleeservice.home.completed.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.OrderDetails;
import snow.app.ideeleeservice.home.ServiceOrderDetails;

public class JobCompletedAdapter extends RecyclerView.Adapter<JobCompletedAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<String> productList;

    public JobCompletedAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.completed_orders_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {

        if (position == 0) {
            holder.ordersummary_completed.setVisibility(View.GONE);
            holder.name.setText("PLUMBER - FOR 2 HOURS");
            holder.status_completed.setVisibility(View.VISIBLE);
            holder.txt_status_completed.setText("By:");

            holder.txt_status_value_completed.setText("Jack Harry");
            holder.txt_status_value_completed.setTextColor(ContextCompat.getColor(mCtx, R.color.colorPrimary));


        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0) {
                    mCtx.startActivity(new Intent(mCtx, OrderDetails.class));
                } else {
                    mCtx.startActivity(new Intent(mCtx, ServiceOrderDetails.class));
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView
                (R.id.name_completed)
        TextView name;
        @BindView(R.id.ordersummary_completed)
        TextView ordersummary_completed;
        @BindView(R.id.status_completed)
        TextView status_completed;
        @BindView(R.id.txt_status_completed)
        TextView txt_status_completed;
        @BindView(R.id.txt_status_value_completed)
        TextView txt_status_value_completed;
        @BindView(R.id.parent)
        LinearLayout parent;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}