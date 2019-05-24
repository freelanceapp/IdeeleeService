package snow.app.ideeleeservice.home.completed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.home.accepted.adapter.AcceptedJobAdapter;
import snow.app.ideeleeservice.home.completed.adapter.JobCompletedAdapter;

public class CompletedOrderFragment extends Fragment {
    @BindView
            (R.id.recyclerView_completed)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_completed_order, container, false);
        unbinder = ButterKnife.bind(this, v);
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
        JobCompletedAdapter adapter = new JobCompletedAdapter(getActivity(), serviceproviderlist);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
