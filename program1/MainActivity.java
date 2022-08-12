package com.example.program1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText First,Second;
    private Button add;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        First=(EditText) findViewById(R.id.first);
        Second=(EditText) findViewById(R.id.second);
        add=(Button) findViewById(R.id.add);
        result=(TextView) findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1,n2,n3;
                n1=Integer.parseInt(First.getText().toString());
                n2=Integer.parseInt(Second.getText().toString());
                n3=n1+n2;
                result.setText(String.valueOf(n3));

            }
        });
    }
}
