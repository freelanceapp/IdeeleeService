package snow.app.ideeleeservice.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import snow.app.ideeleeservice.AppUtils.CircleTransform;
import snow.app.ideeleeservice.R;

import static android.content.Context.WINDOW_SERVICE;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
    }

    private Unbinder unbinder;
    @BindView(R.id.img)
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, v);
        WindowManager wm = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        Picasso.with(getActivity())
                .load("https://pbs.twimg.com/profile_images/572905100960485376/GK09QnNG.jpeg")
                .resize(width / 4, width / 4)
                .transform(new CircleTransform())
                .centerCrop()
                .into(img);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
