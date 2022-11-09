package com.example.db;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,contact,dob;
    Button insert,update,delete,view;
    DBHelper DB;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        dob=findViewById(R.id.dob);
        insert=findViewById(R.id.insert);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        view=findViewById(R.id.view);

        DB=new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String contacttxt=contact.getText().toString();
                String dobtxt=dob.getText().toString();
                boolean check= DB.insertuserdata(nametxt,contacttxt,dobtxt);

                if (check){
                    Toast.makeText(MainActivity.this,"valueInserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"value not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String contacttxt=contact.getText().toString();
                String dobtxt=dob.getText().toString();
                boolean check= DB.updateuserdata(nametxt,contacttxt,dobtxt);

                if (check){
                    Toast.makeText(MainActivity.this,"value Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"value not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String contacttxt=contact.getText().toString();
                String dobtxt=dob.getText().toString();
                boolean check= DB.deleteuserdata(nametxt,contacttxt,dobtxt);

                if (check){
                    Toast.makeText(MainActivity.this,"value deleted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"value not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= DB.getData();
                if (res.getCount()==0){
                    Toast.makeText(MainActivity.this,"no entry exists",Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name:"+res.getString(0)+"\n");
                    buffer.append("Contact:"+res.getString(1)+"\n");
                    buffer.append("DOB:"+res.getString(2)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
