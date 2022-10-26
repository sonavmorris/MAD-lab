package com.example.navigationbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawly;
    public ActionBarDrawerToggle DrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawly = findViewById(R.id.my_draw_layout);
        DrawerToggle = new ActionBarDrawerToggle(this, drawly, R.string.new_open, R.string.new_close);

        drawly.addDrawerListener(DrawerToggle);
        DrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
        public boolean onOptionsItemSelected(MenuItem item){
            if(DrawerToggle.onOptionsItemSelected(item)){
               return true;

            }
            return super.onOptionsItemSelected(item);
        }

}
