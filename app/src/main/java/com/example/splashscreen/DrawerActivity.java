package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.splashscreen.ui.utility.ChecklistActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(DrawerActivity.this, drawer, R.string.Open, R.string.Close);
        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                UserMenuSelector(item);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            actionBarDrawerToggle.syncState();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent i = new Intent(DrawerActivity.this, DrawerActivity.class);
                startActivity(i);
                break;

            case R.id.nav_gallery:
                Intent intent = new Intent(DrawerActivity.this,ChecklistActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_slideshow:
                Intent logout = new Intent(DrawerActivity.this,MainActivity.class);
                startActivity(logout);
                finish();
                break;

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void delhi(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","delhi");
        startActivity(intent);
    }
    public void mumbai(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","mumbai");
        startActivity(intent);
    }
    public void bangalore(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","bangalore");
        startActivity(intent);
    }
    public void pune(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","pune");
        startActivity(intent);
    }
    public void chennai(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","chennai");
        startActivity(intent);
    }
    public void kolkata(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","kolkata");
        startActivity(intent);
    }
    public void jaipur(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","jaipur");
        startActivity(intent);
    }
    public void hedrabad(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","hyderabad");
        startActivity(intent);
    }
    public void panjim(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","panjim");
        startActivity(intent);
    }
    public void ahmedabad(View view) {
        Intent intent = new Intent(DrawerActivity.this,CurrentCityInfo.class);
        intent.putExtra("cityname","ahmedabad");
        startActivity(intent);
    }
}
