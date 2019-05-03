package snow.app.ideeleeservice.services.ondemandservices.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import snow.app.ideeleeservice.R;


public class OnDemandAdapterServ extends RecyclerView.Adapter<OnDemandAdapterServ.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public OnDemandAdapterServ(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.on_demand_tv_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        holder.check.setText(productList.get(position));
        holder.child_view.setVisibility(View.VISIBLE);
        holder.child_view.removeAllViews();
        if (position==0){
            ArrayList<String> data = new ArrayList<>();
            data.add("Fast Food");
            data.add("Italian");
            data.add("Deserts");
            for (int i = 0; i < data.size(); i++) {
                RelativeLayout relativeLayout= new RelativeLayout(mCtx);
                ViewGroup.LayoutParams rlp= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                relativeLayout.setLayoutParams(rlp);
                TextView remove=new TextView(mCtx);
                remove.setText("Remove");
                remove.setTextColor(ContextCompat.getColor(mCtx, R.color.red));
                remove.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        mCtx.getResources().getDimension(R.dimen.normal_text));
/*
                        remove.setCompoundDrawablePadding(8);
*/
                remove.setPadding(0,0,10,0);
                Drawable image = mCtx.getResources().getDrawable( R.drawable.cross_ );
                int h = image.getIntrinsicHeight();
                int w = image.getIntrinsicWidth();
                image.setBounds( 0, 0, w, h );
                remove.setCompoundDrawables( image, null, null, null );
                remove.setCompoundDrawablePadding(15);
                RelativeLayout.LayoutParams llp= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                llp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                llp.setMargins(0,0,10,0);
                remove.setLayoutParams(llp);
                relativeLayout.addView(remove);
                final TextView checkBox = new TextView(mCtx);
                checkBox.setText(data.get(i));
                checkBox.setTextColor(ContextCompat.getColor(mCtx, R.color.txt_light));
                checkBox.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        mCtx.getResources().getDimension(R.dimen.normal_text));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(8, 8, 8, 8);
                checkBox.setLayoutParams(layoutParams);
                checkBox.setPadding(15, 5, 5, 5);
                relativeLayout.addView(checkBox);
                holder.child_view.addView(relativeLayout);

            }
        }


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView check;
        LinearLayout child_view;


        public ProductViewHolder(View itemView) {
            super(itemView);
            check = itemView.findViewById(R.id.check);
            child_view = itemView.findViewById(R.id.child_view);
            child_view.setVisibility(View.VISIBLE);
        }
    }
}