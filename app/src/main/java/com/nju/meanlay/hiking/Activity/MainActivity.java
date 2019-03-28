package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.Adapter.MyFragmentPageAdapter;
import com.nju.meanlay.hiking.App;
import com.nju.meanlay.hiking.Fragment.MyEventFragment;
import com.nju.meanlay.hiking.Fragment.TopEventFragment;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MyFragmentPageAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView userNameTV;
    private TextView userUniversityTV;
    private TextView userIntroductionTV;
    private CircleImageView avatar;
    private SearchView searchView;
    private Toolbar toolbar;
    private LinearLayout searchLayout;
    private ImageView cancelSearchV;

    public static final int EDIT_PROFILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        pagerAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        searchView = findViewById(R.id.search);
        searchLayout = findViewById(R.id.search_layout);
        cancelSearchV = findViewById(R.id.cancel_search);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhite));
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        View v  = navigationView.getHeaderView(0);
        userNameTV = v.findViewById(R.id.user_name_main);
        userUniversityTV = v.findViewById(R.id.user_university_main);
        userIntroductionTV = v.findViewById(R.id.user_introduction_main);
        avatar = v.findViewById(R.id.avatar_main);
        setUserInfo();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ((TopEventFragment)pagerAdapter.getItem(0)).getAdapter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        cancelSearchV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLayout.setVisibility(View.GONE);
                toolbar.setVisibility(View.VISIBLE);
                searchView.clearFocus();
                ((TopEventFragment)pagerAdapter.getItem(0)).getAdapter().cancelFilter();
            }
        });
    }

    private void setUserInfo() {
        User user = App.getInstance().getUser();
        userNameTV.setText(user.getNickName());
        userIntroductionTV.setText(user.getIntroduction());
        userUniversityTV.setText(user.getUniversity());
        Glide.with(this).load(Integer.valueOf(user.getAvatarUrl())).centerCrop().into(avatar);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent intent = new Intent(MainActivity.this,CreateEventActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_search) {
            searchLayout.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.GONE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_friends) {
            Intent intent = new Intent(this,MyFriendsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ended_event) {
            Intent intent = new Intent(this,EndedEventActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_collection) {
            Intent intent = new Intent(this,CollectionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Toast.makeText(this,"还在开发",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_edit_profile) {
            Intent intent = new Intent(MainActivity.this,EditProfileActivity.class);
            startActivityForResult(intent,EDIT_PROFILE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==  EDIT_PROFILE) {
            setUserInfo();
        }
    }
}
