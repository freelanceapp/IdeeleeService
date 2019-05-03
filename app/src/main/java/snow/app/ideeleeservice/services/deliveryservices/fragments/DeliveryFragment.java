package snow.app.ideeleeservice.services.deliveryservices.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.services.ondemandservices.adapter.OnDemandAdapterServ;

public class DeliveryFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.fragment_delivery, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_acceptedorder);
        serviceproviderlist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

         serviceproviderlist.add("Food Delivery");
        serviceproviderlist.add("Gift Delivery");
        serviceproviderlist.add("Liquid Delivery");


        OnDemandAdapterServ adapter = new OnDemandAdapterServ(getActivity(), serviceproviderlist);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return v;
    }

}
