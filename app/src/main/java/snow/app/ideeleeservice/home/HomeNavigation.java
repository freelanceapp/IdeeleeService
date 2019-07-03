package snow.app.ideeleeservice.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import snow.app.ideeleeservice.AppUtils.CircleTransform;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.address.AddAddress;
import snow.app.ideeleeservice.api_request_retrofit.ApiService;
import snow.app.ideeleeservice.api_request_retrofit.retrofit_client.ApiClient;
import snow.app.ideeleeservice.coupons.CouponsListing;
import snow.app.ideeleeservice.extrafiles.OneTimeLogin;
import snow.app.ideeleeservice.forgot.EditPassword;
import snow.app.ideeleeservice.help.HelpActivity;
import snow.app.ideeleeservice.home.homefiles.OrderHomeFragment;
import snow.app.ideeleeservice.login.Login;
import snow.app.ideeleeservice.payments.Payments;
import snow.app.ideeleeservice.products.productlist.ProductListActivity;
import snow.app.ideeleeservice.profile.ProfileFragment;
import snow.app.ideeleeservice.responses.logoutres.LogoutRes;
import snow.app.ideeleeservice.servicepackages.ServicePackages;
import snow.app.ideeleeservice.services.Services;
import snow.app.ideeleeservice.stores.Stores;

public class HomeNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    ApiService apiService;
    String device_token;
    HashMap<String, String> map;
    OneTimeLogin oneTimeLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        ButterKnife.bind(this);
        toolbar.inflateMenu(R.menu.home_navigation);
        oneTimeLogin = new OneTimeLogin(HomeNavigation.this);
        apiService = ApiClient.getClient(getApplicationContext())
                .create(ApiService.class);
        setFragment(new OrderHomeFragment(), "Home");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View v = navigationView.getHeaderView(0);
        ImageView img = v.findViewById(R.id.img);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ProfileFragment(), "Edit Profile");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Picasso.with(this)
                .load("https://pbs.twimg.com/profile_images/572905100960485376/GK09QnNG.jpeg")
                .resize(width / 5, width / 5)
                .transform(new CircleTransform())
                .centerCrop()
                .into(img);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.edit_profile) {
            setFragment(new ProfileFragment(), "Edit Profile");
        } else if (id == R.id.manageservices) {
            startActivity(new Intent(HomeNavigation.this, Services.class));
        } else if (id == R.id.products) {
            startActivity(new Intent(HomeNavigation.this, ProductListActivity.class));
        } else if (id == R.id.liveorders) {
            setFragment(new OrderHomeFragment(), "Home");
//        } else if (id == R.id.servicepricing) {
//            startActivity(new Intent(HomeNavigation.this, ServicePricingActivity.class));
        } else if (id == R.id.mypackage) {
            startActivity(new Intent(HomeNavigation.this, ServicePackages.class));
        } else if (id == R.id.payments) {
            startActivity(new Intent(HomeNavigation.this, Payments.class));
        } else if (id == R.id.storeinfo) {
            startActivity(new Intent(HomeNavigation.this, Stores.class));
        } else if (id == R.id.manageaddress) {
            startActivity(new Intent(HomeNavigation.this, AddAddress.class));
        } else if (id == R.id.helpsupport) {
            startActivity(new Intent(HomeNavigation.this, HelpActivity.class));
        } else if (id == R.id.editpassword) {
            startActivity(new Intent(HomeNavigation.this, EditPassword.class));
        } else if (id == R.id.logout) {
//            oneTimeLogin.setFirstTimeLaunch(true);
//            Toast.makeText(this, "Successfully logged out", Toast.LENGTH_SHORT).show();
//            Intent intent_continue = new Intent(HomeNavigation.this, Login.class);
//            startActivity(intent_continue);
//            finish();


            handleLogout();


        } else if (id == R.id.add_coupons) {
            startActivity(new Intent(HomeNavigation.this, CouponsListing.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment, String title) {
        TextView tv = findViewById(R.id.title);
        tv.setText(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment, title);
        fragmentTransaction.commit();
    }


    public void logoutUser(HashMap<String, String> map) {
        // showProgress();

        Observer<LogoutRes> observer = apiService.logoutUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<LogoutRes>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LogoutRes res) {
                        if (res.getStatus()) {


                            oneTimeLogin.setFirstTimeLaunch(true);
                            Toast.makeText(HomeNavigation.this, res.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent intent_continue = new Intent(HomeNavigation.this, Login.class);
                            startActivity(intent_continue);
                            finish();
                        } else {
                            Toast.makeText(HomeNavigation.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {


                    }
                });


    }


    private void handleLogout() {

        SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);
        String userid = prefs.getString("userid", "0");
        String token = prefs.getString("token", "0");
//        if (userid != null) {
//
//        }


        map = new HashMap<>();
        map.put("userid", userid);
        map.put("token", token);


        logoutUser(map);
    }


}
