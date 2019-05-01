package snow.app.ideeleeservice.home.completed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import snow.app.ideeleeservice.R;

public class CompletedOrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View v=   inflater.inflate(R.layout.fragment_completed_order, container, false);
return v;
    }

}
