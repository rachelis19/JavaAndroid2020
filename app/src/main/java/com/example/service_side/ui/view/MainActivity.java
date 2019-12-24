package com.example.service_side.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service_side.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class
MainActivity extends AppCompatActivity {

      private EditText emailUserName;
      private EditText password;
      private Button SignUp;
      private Button Login;
      private Button bto;

      private void findViews()
      {
          emailUserName=findViewById(R.id.emailUserName);
          password=findViewById(R.id.passwordNewUser);
          SignUp= findViewById(R.id.my_rounded_sign_in);
          Login=(Button)findViewById(R.id.login);
          bto=(Button)findViewById(R.id.BTO);
      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent=new Intent(getApplicationContext(), UserDetailsActivity.class);
                startActivity(startIntent);
            }
        });
        bto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HistoryParcelActivity.class);
                startActivity(startIntent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid(emailUserName.getText().toString())) {
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

     public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
