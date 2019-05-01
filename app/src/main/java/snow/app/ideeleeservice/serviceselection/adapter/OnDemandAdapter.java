package snow.app.ideeleeservice.serviceselection.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;

import snow.app.ideeleeservice.R;


public class OnDemandAdapter extends RecyclerView.Adapter<OnDemandAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public OnDemandAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.single_checkbox_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        holder.check.setText(productList.get(position));
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.check.isChecked()){
                    holder.check.setTextColor(ContextCompat.getColor(mCtx,R.color.green));
                }else {
                    holder.check.setTextColor(ContextCompat.getColor(mCtx,R.color.txt_light));
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        CheckBox check;


        public ProductViewHolder(View itemView) {
            super(itemView);
            check=itemView.findViewById(R.id.check);

        }
    }
}