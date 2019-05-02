package snow.app.ideeleeservice.home;

import android.content.Intent;
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

import com.squareup.picasso.Picasso;

import snow.app.ideeleeservice.AppUtils.CircleTransform;
import snow.app.ideeleeservice.R;
import snow.app.ideeleeservice.forgot.EditPassword;
import snow.app.ideeleeservice.help.HelpActivity;
import snow.app.ideeleeservice.home.homefiles.OrderHomeFragment;
import snow.app.ideeleeservice.products.productlist.ProductListActivity;
import snow.app.ideeleeservice.profile.ProfileFragment;
import snow.app.ideeleeservice.servicepackages.ServicePackages;
import snow.app.ideeleeservice.services.Services;
import snow.app.ideeleeservice.stores.Stores;

public class HomeNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.home_navigation);
            setFragment(new OrderHomeFragment(),"Home");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View v=navigationView.getHeaderView(0);
        ImageView img=v.findViewById(R.id.img);
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
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

        } else if (id == R.id.servicepricing) {

        } else if (id == R.id.mypackage) {
            startActivity(new Intent(HomeNavigation.this, ServicePackages.class));
        } else if (id == R.id.payments) {
        } else if (id == R.id.storeinfo) {
            startActivity(new Intent(HomeNavigation.this, Stores.class));
        } else if (id == R.id.manageaddress) {
        } else if (id == R.id.helpsupport) {
            startActivity(new Intent(HomeNavigation.this, HelpActivity.class));
        } else if (id == R.id.editpassword) {
            startActivity(new Intent(HomeNavigation.this, EditPassword.class));
        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

        // public method to replace fragment on home screen
    public void setFragment(Fragment fragment, String title) {
        TextView tv=findViewById(R.id.title);
        tv.setText(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment, title);
        fragmentTransaction.commit();
    }
}
