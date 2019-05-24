package snow.app.ideeleeservice.payments.withdrawl.fragment;

import android.content.Context;
import android.net.Uri;
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
import snow.app.ideeleeservice.payments.received.adapter.ReceivedFragmentAdapter;
import snow.app.ideeleeservice.payments.withdrawl.adapter.WithdrawlFragmentAdapter;

public class WithdrawlFragement extends Fragment {
    @BindView
            (R.id.recyclerView_withdrawl)
    RecyclerView recyclerView;
    ArrayList<String> serviceproviderlist;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_withdrawl_fragement, container, false);
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


        WithdrawlFragmentAdapter adapter = new WithdrawlFragmentAdapter(getActivity(), serviceproviderlist);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
