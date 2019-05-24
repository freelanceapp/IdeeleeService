package snow.app.ideeleeservice.servicesnew;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.servicepackages.MyPackageDetails;
import snow.app.ideeleeservice.services.deliveryservices.fragments.DeliveryFragment;
import snow.app.ideeleeservice.serviceselection.DelieveryService;
import snow.app.ideeleeservice.serviceselection.MoreOnDemand;


public class OnDemandServiceAdapter extends RecyclerView.Adapter<OnDemandServiceAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> productList;

    //getting the context and product list with constructor
    public OnDemandServiceAdapter(Context mCtx, List<String> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ondemandrow, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position

        holder.cat.setText(productList.get(position));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cat)
        TextView cat;

        public ProductViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCtx, MoreOnDemand.class);
                    mCtx.startActivity(intent);
                }
            });

        }
    }

    public void showSubCatDialog() {
        final Dialog dialog = new Dialog(mCtx);
        dialog.setContentView(R.layout.subcatdialog);
        dialog.setTitle("Title");

// set the custom dialog components - text, image and button
//        TextView text = (TextView) dialog.findViewById(R.id.text1);
//        text.setText("Text view 1");
//
//        TextView text = (TextView) dialog.findViewById(R.id.text2);
//        text.setText("Text view 2");
        dialog.show();


    }
}