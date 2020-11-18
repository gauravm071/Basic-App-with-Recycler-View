package com.example.basicappwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name,email,phoneNumber;
    Button button;
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name= findViewById(R.id.tvName);
        email= findViewById(R.id.tvEmail);
        phoneNumber= findViewById(R.id.tvPhoneNumber);
        button= findViewById(R.id.button2);
        number= findViewById(R.id.etNumber);
        String myNumber=number.getText().toString();
        Intent intent= getIntent();
        Bundle extras= intent.getExtras();
        String myname= extras.getString("name").toString();
        String myemail= extras.getString("email").toString();
        String myPhoneNumber= extras.getString("phoneNumber").toString();
        name.setText("Name: "+myname);
        email.setText("Email: "+myemail);
        phoneNumber.setText("Phone Number: "+myPhoneNumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                Bundle bundle= new Bundle();
                bundle.putString("number",number.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}