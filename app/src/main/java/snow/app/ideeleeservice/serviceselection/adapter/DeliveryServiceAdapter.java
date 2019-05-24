package snow.app.ideeleeservice.serviceselection.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;


public class DeliveryServiceAdapter extends RecyclerView.Adapter<DeliveryServiceAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public DeliveryServiceAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.multiple_checkbox_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        holder.check.setText(productList.get(position));
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0 && holder.check.isChecked()) {
                    holder.child_view.removeAllViews();
                    holder.child_view.setVisibility(View.VISIBLE);
                    ArrayList<String> data = new ArrayList<>();
                    data.add("Fast Food");
                    data.add("Italian");
                    data.add("Deserts");
                    for (int i = 0; i < data.size(); i++) {
                        final CheckBox checkBox = new CheckBox(mCtx);
                        checkBox.setText(data.get(i));
                        checkBox.setTextColor(ContextCompat.getColor(mCtx, R.color.txt_light));
                        checkBox.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                                mCtx.getResources().getDimension(R.dimen.normal_text));
/*
                        checkBox.setButtonDrawable(ContextCompat.getDrawable(mCtx, R.drawable.checkbox_selector));
*/
                        checkBox.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkBox.isChecked()) {
                                    checkBox.setTextColor(ContextCompat.getColor(mCtx, R.color.green));
                                } else {
                                    checkBox.setTextColor(ContextCompat.getColor(mCtx, R.color.txt_light));
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        layoutParams.setMargins(8, 8, 8, 8);
                        checkBox.setLayoutParams(layoutParams);
                        checkBox.setPadding(15, 5, 5, 5);
                        holder.child_view.addView(checkBox);
                    }
                } else {
                    holder.child_view.setVisibility(View.GONE);
                }
                if (holder.check.isChecked()) {
                    holder.check.setTextColor(ContextCompat.getColor(mCtx, R.color.green));
                } else {
                    holder.check.setTextColor(ContextCompat.getColor(mCtx, R.color.txt_light));
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.check)
        CheckBox check;
        @BindView(R.id.child_view)
        LinearLayout child_view;


        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}