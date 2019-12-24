package com.example.service_side.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service_side.R;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__details);
        Intent i=getIntent();
        Button signUp=(Button)findViewById(R.id.button_user);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstName=findViewById(R.id.firstNameUser);
                EditText lastName=findViewById(R.id.lastNameUser);
                EditText password=findViewById(R.id.passwordNewUser);
                EditText edtEmailId=findViewById(R.id.emailTextUser);
                EditText distribution_Company =findViewById(R.id.distribution_Company);
                //Date dateOfbirth=(Date) findViewById(R.id.dateOfBrith);
                if(MainActivity.isEmailValid(edtEmailId.getText().toString())) {
                    Intent startIntent = new Intent(getApplicationContext(), AddParcelActivity_1.class);
                    startActivity(startIntent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "InValid Email Address.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}