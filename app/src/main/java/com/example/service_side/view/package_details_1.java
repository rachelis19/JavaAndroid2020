package com.example.service_side.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.service_side.R;

public class package_details_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details_1);
        Intent i = getIntent();
        final ImageButton next_btn=(ImageButton)findViewById(R.id.next_first);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),package_details_2.class);
                startActivity(startIntent);
            }
        });
    }


}
