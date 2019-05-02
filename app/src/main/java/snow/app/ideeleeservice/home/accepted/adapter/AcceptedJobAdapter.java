package snow.app.ideeleeservice.home.accepted.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import snow.app.ideeleeservice.R;


public class AcceptedJobAdapter extends RecyclerView.Adapter<AcceptedJobAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public AcceptedJobAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.accepted_orders_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position

        if (position == 0) {
            holder.ordersummary.setVisibility(View.VISIBLE);
            holder.title.setText("Jack Harry");
            holder.by.setText("Status:");
            holder.name.setText("Pending");
            holder.name.setTextColor(ContextCompat.getColor(mCtx, R.color.orange));
            holder.txt_callnow.setText("View");
            holder.time.setVisibility(View.GONE);
            holder.txt_callnow.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            holder.txt_callnow.setGravity(Gravity.CENTER);
            holder.viewdetails.setText("Dispatched");
            holder.viewdetails.setBackground(ContextCompat.getDrawable(mCtx,R.drawable.round_corner_green_solid));

        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView ordersummary, title, by, time, txt_callnow, name, viewdetails;


        public ProductViewHolder(View itemView) {
            super(itemView);
            ordersummary = itemView.findViewById(R.id.ordersummary_accepted);
            title = itemView.findViewById(R.id.time_accepted);
            by = itemView.findViewById(R.id.txt_by);
            name = itemView.findViewById(R.id.name);
            viewdetails = itemView.findViewById(R.id.viewdetails_accepted);
            txt_callnow = itemView.findViewById(R.id.callnow_accepted);
            time = itemView.findViewById(R.id.time_accepted);


        }
    }
}