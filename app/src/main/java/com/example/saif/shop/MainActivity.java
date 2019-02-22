package com.example.saif.shop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private TabLayout tabLayout;
    private Toolbar tb;
    private ViewPager viewPager;
    private  DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView tvnavusername;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_logout:
                final SharedPreferences sharedpreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();
                Login.checkuser=false;
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
                finish();
                break;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SharedPreferences sharedpreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        tb=  findViewById(R.id.toolbar_id);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);



        //navigation view
        navigationView= findViewById(R.id.navdrawer);
        View h = navigationView.inflateHeaderView(R.layout.nav_header);
        tvnavusername=(TextView)h.findViewById(R.id.tv_navusername);
        tvnavusername.setText(sharedpreferences.getString("customerName",Login.customerName));
        navigationView.setNavigationItemSelectedListener(this);




        //drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,tb,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        Viewpageradapter  viewpageradapter= new Viewpageradapter(getSupportFragmentManager());
        viewpageradapter.Addfragment(new Fragmentjustforyou(), "JUST FOR YOU");
        viewpageradapter.Addfragment(new Fragmentexplore(), "EXPLORE");
        viewpageradapter.Addfragment(new Fragmentstore(), "STORE");

        viewPager.setAdapter(viewpageradapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
