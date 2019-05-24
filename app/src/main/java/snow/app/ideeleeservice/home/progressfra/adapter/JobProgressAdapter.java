package snow.app.ideeleeservice.home.progressfra.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;

public class JobProgressAdapter extends RecyclerView.Adapter<JobProgressAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;
    private List<String> productList;
    public JobProgressAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.inprogress_orders_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        if (position == 0) {
            holder.ordersummary.setVisibility(View.GONE);
            holder.name.setText("PLUMBER - FOR 2 HOURS");
            holder.status_progress.setVisibility(View.VISIBLE);
            holder.txt_status_progress.setText("By:");

            holder.status_value_progress.setText("Jack Harry");
            holder.status_value_progress.setTextColor(ContextCompat.getColor(mCtx, R.color.colorPrimary));
            holder.btn_view.setVisibility(View.GONE);
            holder.complete_progress.setVisibility(View.GONE);
            holder.deliverto.setText("Job Location");


        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name_progress) TextView name;
        @BindView(R.id.ordersummary_progress) TextView ordersummary;
       @BindView(R.id.status_progress) TextView status_progress;
        @BindView(R.id.txt_status_progress) TextView txt_status_progress;
        @BindView(R.id.status_value_progress) TextView status_value_progress;
        @BindView(R.id.deliverto) TextView deliverto;
        @BindView(R.id.view_progress) Button btn_view;
        @BindView(R.id.complete_progress) Button complete_progress;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}