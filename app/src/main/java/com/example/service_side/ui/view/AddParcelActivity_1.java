package com.example.service_side.ui.view;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.service_side.data.model.entities.Parcel;
import androidx.appcompat.app.AppCompatActivity;
import com.example.service_side.R;
import static com.example.service_side.ui.view.MainActivity.isEmailValid;

public class AddParcelActivity_1 extends AppCompatActivity {

    private EditText phoneNumberIn;
    private EditText firstNameIn;
    private EditText lastNameIn;
    private EditText emailTextIn;
    private EditText addressIn;
    private Parcel newParcel;
    ImageButton next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel_1);
        findViews();
    }

    private void SaveInfoFromUi()
    {
        newParcel= new Parcel();
        newParcel.setPhoneNumberOfRecipient(phoneNumberIn.getText().toString());
        newParcel.setFirstNameOfRecipient(firstNameIn.getText().toString());
        newParcel.setLastNameOfRecipient(lastNameIn.getText().toString());
        newParcel.setEmailAddOfRecipient(emailTextIn.getText().toString());
        newParcel.setAddressOfRecipient(addressIn.getText().toString());

    }
    private void findViews()
    {
        phoneNumberIn=findViewById(R.id.phoneNumberR);
        firstNameIn=findViewById(R.id.firstNameR);
        lastNameIn=findViewById(R.id.lastNameR);
        emailTextIn=findViewById(R.id.emailTextR);
        addressIn=findViewById(R.id.addressR);
        next_btn=(ImageButton)findViewById(R.id.next_first);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(phoneNumberIn.getText().toString()) && !TextUtils.isEmpty(firstNameIn.getText().toString()) && !TextUtils.isEmpty(lastNameIn.getText().toString()) && !TextUtils.isEmpty(addressIn.getText().toString())) {
                    if (isEmailValid(emailTextIn.getText().toString())) {
                        SaveInfoFromUi();
                        Intent startIntent = new Intent(getApplicationContext(),AddParcelActivity_2.class);
                        startIntent.putExtra("com.example.service_side.ui.view.Parcel", newParcel);
                        startActivity(startIntent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "InValid Email Address.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please Fill In All Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }






}
