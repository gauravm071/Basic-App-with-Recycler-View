package com.example.basicappwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, phoneNumber,email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.etName);
        phoneNumber= findViewById(R.id.etPhoneNumber);
        email= findViewById(R.id.etEmail);
        button= findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                Bundle bundle= new Bundle();
                bundle.putString("name",name.getText().toString());
                bundle.putString("phoneNumber",phoneNumber.getText().toString());
                bundle.putString("email",email.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}