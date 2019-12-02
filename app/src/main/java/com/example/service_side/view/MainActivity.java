package com.example.service_side.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service_side.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class
MainActivity extends AppCompatActivity {

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button SignUp=(Button) findViewById(R.id.my_rounded_sign_in);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent=new Intent(getApplicationContext(),User_Details.class);
                startActivity(startIntent);
            }
        });
        final Button Login=(Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtEmailId=findViewById(R.id.username);
                EditText password=findViewById(R.id.password);
                if(isEmailValid(edtEmailId.getText().toString())) {
                    Intent startIntent = new Intent(getApplicationContext(), package_details_1.class);
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
