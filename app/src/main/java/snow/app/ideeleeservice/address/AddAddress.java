package snow.app.ideeleeservice.address;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import snow.app.ideeleeservice.extrafiles.ConnectivityReceiver;
import snow.app.ideeleeservice.extrafiles.MyApplication;
import snow.app.ideeleeservice.home.HomeNavigation;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.serviceselection.ServiceSelectorActivity;
import snow.app.ideeleeservice.servicesnew.OnDemandServices;


public class AddAddress extends AppCompatActivity implements OnMapReadyCallback,
        ConnectivityReceiver.ConnectivityReceiverListener {

    SupportMapFragment mapFragment;
    @BindView(R.id.addmoredetails)
    TextView addmoredetails;
    @BindView(R.id.txt_confirmlocation)
    TextView txt_confirmlocation;
    @BindView(R.id.title)
    TextView title_bookingappointement;
    @BindView(R.id.ux_btn1)
    TextView textView;
    @BindView(R.id.back)
    ImageView backbutton1;
    WindowManager wm;
    ImageView imgonline;
    int height;
    DisplayMetrics displayMetrics;
    String imageUri = "https://i.imgur.com/tGbaZCY.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
        checkConnection();

        addmoredetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.buttonlayout).setVisibility(View.GONE);
                findViewById(R.id.fields).setVisibility(View.VISIBLE);
                findViewById(R.id.txt_confirmlocation).setVisibility(View.VISIBLE);
            }
        });
        txt_confirmlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddAddress.this, HomeNavigation.class));
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddAddress.this, HomeNavigation.class));
            }
        });
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        System.out.println("height of screen---" + height);
        int width = displayMetrics.widthPixels;
        title_bookingappointement.setText("Add Address");

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        ViewGroup.LayoutParams params = mapFragment.getView().getLayoutParams();
        params.height = height / 2;
        mapFragment.getView().setLayoutParams(params);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mapFragment.getMapAsync(new OnMapReadyCallback() {
//                    @Override
//                    public void onMapReady(GoogleMap googleMap) {
//                        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//
//                        googleMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.4233438, -122.0728817))
//                                .title("LinkedIn")
//                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
//
//                        googleMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.4629101,-122.2449094))
//                                .title("Facebook")
//                                .snippet("Facebook HQ: Menlo Park"));
//
//                        googleMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.3092293, -122.1136845))
//                                .title("Apple"));
//
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), 10));
//                    }
//                });
//            }
//        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(AddAddress.this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (!isConnected) {

            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();

        } else {
//
//            Intent refresh = new Intent(this, AddAddress.class);
//            startActivity(refresh);//Start the same Activity
//            finish();
        }

    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        if (!isConnected) {
            //show a No Internet Alert or Dialog
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();
        }
    }
}
