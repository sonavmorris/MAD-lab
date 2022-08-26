package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(username.getText().toString(), "admin") && Objects.equals(password.getText().toString(), "admin"))
                {
                    Toast.makeText(login.this, "Authenticated successfully", Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(login.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
        }
        });

    }
}
