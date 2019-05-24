package snow.app.ideeleeservice.services.deliveryservices.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.services.ondemandservices.adapter.OnDemandAdapterServ;
import snow.app.ideeleeservice.serviceselection.DelieveryService;
import snow.app.ideeleeservice.servicesnew.OnDemandServices;

public class DeliveryFragment extends Fragment {
    @BindView
            (R.id.recyclerView_acceptedorder)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    @BindView(R.id.btn)
    Button btn;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delivery, container, false);
        unbinder = ButterKnife.bind(this, v);
        serviceproviderlist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        serviceproviderlist.add("Food Delivery");
        serviceproviderlist.add("Gift Delivery");
        serviceproviderlist.add("Liquid Delivery");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DelieveryService.class));
            }
        });
        OnDemandAdapterServ adapter = new OnDemandAdapterServ(getActivity(), serviceproviderlist);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
