package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);

        return true;
    }
    public boolean onOptionItemSelected(@NonNull MenuItem item)
    {
     int id=item.getItemId();
     if(id==R.id.home)
        {
         Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }
     if(id==R.id.settings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
     if(id==R.id.about)
        {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        }
     if(id==R.id.share)
        {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
