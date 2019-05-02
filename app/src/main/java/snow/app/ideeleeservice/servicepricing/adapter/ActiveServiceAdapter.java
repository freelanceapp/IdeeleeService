package snow.app.ideeleeservice.servicepricing.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.serviceselection.MoreOnDemand;


public class ActiveServiceAdapter extends RecyclerView.Adapter<ActiveServiceAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public ActiveServiceAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.active_service_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.service_name.setText(productList.get(position));
        if (position==productList.size()-1){
            holder.add_btn.setVisibility(View.VISIBLE);
            holder.edit_btn.setVisibility(View.GONE);

        }else {
            holder.add_btn.setVisibility(View.GONE);
            holder.edit_btn.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView service_name;
    TextView add_btn;
    TextView edit_btn;
        public ProductViewHolder(View itemView) {
            super(itemView);
            service_name=itemView.findViewById(R.id.service_name);
            add_btn=itemView.findViewById(R.id.add_btn);
            edit_btn=itemView.findViewById(R.id.edit_btn);
            add_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(mCtx);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.service_pop);
                    Button submit=dialog.findViewById(R.id.submit);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    int width = (int)(mCtx.getResources().getDisplayMetrics().widthPixels*0.90);
                    int height = (int)(mCtx.getResources().getDisplayMetrics().heightPixels*.50);

                    dialog.getWindow().setLayout(width, height);
                    dialog.show();
                }
            });

        }
    }
}