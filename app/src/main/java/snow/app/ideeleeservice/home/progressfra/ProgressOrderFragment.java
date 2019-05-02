package snow.app.ideeleeservice.home.progressfra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.neworder.adapter.NewJobAdapter;
import snow.app.ideeleeservice.home.progressfra.adapter.JobProgressAdapter;


public class ProgressOrderFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_in_progress_order, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_progress);
        serviceproviderlist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "Pending", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "Online Payment"));
//
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "Accept", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "cash on delivery"));
//
//        serviceproviderlist.add(
//                new ActiveJobModal(
//                        "On Going", "APR 18,2019 02:00PM", "JACK HARRY", "", "", "", "Online payment"));
//        //
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");
        serviceproviderlist.add("dd");


        JobProgressAdapter adapter = new JobProgressAdapter(getActivity(), serviceproviderlist);
        recyclerView.setAdapter(adapter);
        return v;
    }
}