package snow.app.ideeleeservice.home.completed.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import snow.app.ideeleeservice.R;

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
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        if (position == 0) {
            holder.ordersummary_completed.setVisibility(View.GONE);
            holder.name.setText("PLUMBER - FOR 2 HOURS");
            holder.status_completed.setVisibility(View.VISIBLE);
            holder.txt_status_completed.setText("By:");

            holder.txt_status_value_completed.setText("Jack Harry");
            holder.txt_status_value_completed.setTextColor(ContextCompat.getColor(mCtx,R.color.colorPrimary));



        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView name,ordersummary_completed,status_completed,txt_status_completed,txt_status_value_completed;

        public ProductViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_completed);
            ordersummary_completed=itemView.findViewById(R.id.ordersummary_completed);
            status_completed=itemView.findViewById(R.id.status_completed);
            txt_status_completed=itemView.findViewById(R.id.txt_status_completed);
            txt_status_value_completed=itemView.findViewById(R.id.txt_status_value_completed);



        }
    }
}