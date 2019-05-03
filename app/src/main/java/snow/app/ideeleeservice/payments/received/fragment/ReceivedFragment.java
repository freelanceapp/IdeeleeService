package snow.app.ideeleeservice.payments.received.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.payments.received.adapter.ReceivedFragmentAdapter;

public class ReceivedFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_received, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_received);
        serviceproviderlist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        serviceproviderlist.add("sd");
        serviceproviderlist.add("sadas");
        serviceproviderlist.add("sadsd");
        serviceproviderlist.add("sd");
        serviceproviderlist.add("sadas");
        serviceproviderlist.add("sadsd");
        serviceproviderlist.add("sd");
        serviceproviderlist.add("sadas");
        serviceproviderlist.add("sadsd");
        serviceproviderlist.add("sd");
        serviceproviderlist.add("sadas");
        serviceproviderlist.add("sadsd");


        ReceivedFragmentAdapter adapter = new ReceivedFragmentAdapter(getActivity(), serviceproviderlist);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return v;
    }


    }

