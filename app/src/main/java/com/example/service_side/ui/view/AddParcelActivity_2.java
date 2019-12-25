package com.example.service_side.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.service_side.R;
import com.example.service_side.Utils.ParcelChange;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.model.entities.ParcelStatus;
import com.example.service_side.data.model.entities.ParcelType;
import com.example.service_side.data.model.entities.ParcelWeight;
import com.example.service_side.data.repositories.ParcelDataSource;
import com.example.service_side.viewModel.ParcelViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddParcelActivity_2 extends AppCompatActivity
{
    private static final String TAG = "AddParcelActivity_2";
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private TextView mDisplayDate1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    private Button delivery_date_btn;
    private Button received_date_btn;
    private Button approval_btn;
    private EditText worker_name;
    private EditText location_stack;
    private TextView deliveryDate;
    private TextView receiptDate;
    private Spinner spinner;
    private CheckBox fragile;
    private Parcel parcel;
    private ParcelViewModel parcelViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel_2);
        Intent intent = getIntent();
        parcel = new Parcel();
        parcel= (Parcel)intent.getSerializableExtra("com.example.service_side.ui.view.Parcel");
         findViews();
          createSpinner();
          calendarSetUp();
          btnAddClick();
         parcelViewModel.getParcelChange().observe(this, new Observer<ParcelChange>() {
            @Override
            public void onChanged(ParcelChange parcelChange) {
                if(parcelChange.success==true)
                    Toast.makeText(getApplicationContext(), "The Parcel Has Been Saved Successfully", Toast.LENGTH_SHORT).show();
                else
                {
                    Toast.makeText(getApplicationContext(), "The Parcel Has Not Been Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void btnAddClick()
    {
        approval_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SaveInfoFromUi();
                parcelViewModel.addParcel(parcel);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }


    public void findViews() {
        radioGroup = findViewById(R.id.radioGroup);
        receiptDate = (TextView) findViewById(R.id.receipt_txt);
        deliveryDate = (TextView) findViewById(R.id.delivery_txt);
        location_stack = (EditText) findViewById(R.id.location);
        worker_name = (EditText) findViewById(R.id.workerName);
        mDisplayDate1 = (TextView) findViewById(R.id.delivery_txt);
        mDisplayDate2 = (TextView) findViewById(R.id.receipt_txt);
        delivery_date_btn = (Button) findViewById(R.id.delivery_btn);
        received_date_btn = (Button) findViewById(R.id.receipt_btn);
        approval_btn = (Button) findViewById(R.id.approvalBtn);
        spinner = (Spinner) findViewById(R.id.spinner_wieght);
        fragile = (CheckBox) findViewById(R.id.fragile_check);
        parcelViewModel=new ParcelViewModel();
        parcelViewModel=ViewModelProviders.of(this).get(ParcelViewModel.class);
    }
    private void SaveInfoFromUi() {
        try {
            parcel.setWorkerName(worker_name.getText().toString());
            parcel.setLocationStorage(location_stack.getText().toString());
            parcel.setFragile_content(fragile.isChecked());
            parcel.setDelivery_date(deliveryDate.getText().toString());
            parcel.setReceipt_date(receiptDate.getText().toString());
            parcel.setParcelType(CheckTypeOfParcel());
            parcel.setParcelWeight(CheckWeight());
            parcel.setParcelStatus(ParcelStatus.ACCEPTED);
            parcel.setParcelId("1");
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void createSpinner()
    {
        try {


            String[] list_enum_type1 = getResources().getStringArray(R.array.enum_wieght);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_enum_wieght, R.id.txt1, list_enum_type1);
            spinner.setAdapter(adapter1);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT);
        }

    }
    public ParcelWeight CheckWeight() {
        switch (spinner.getSelectedItem().toString()) {
            case "Up To 500g":
                return ParcelWeight.UNTIL_500G;
            case "Up To 1kg":
                return ParcelWeight.UNTIL_1KG;
            case "Up To 5kg":
                return ParcelWeight.UNTIL_5KG;
            case "Up To 20kg":
                return ParcelWeight.UNTIL_20KG;
        }
        return null;
    }

        public ParcelType CheckTypeOfParcel() {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        switch (radioButton.getId()) {
            case R.id.envelope_rb:
                return ParcelType.ENVELOPE;
            case R.id.big_package_rb:
                return ParcelType.BIG_PACKAGE;
            case R.id.small_package_rb:
                return ParcelType.SMALL_PACKAGE;
        }
        return null;
    }
    private void  calendarSetUp()
    {
        delivery_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarCreator(mDateSetListener1);

            }
        });
        received_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarCreator(mDateSetListener2);
            }
        });


        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate1.setText(date);
            }
        };
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate2.setText(date);
            }
        };
    }

    public void calendarCreator(DatePickerDialog.OnDateSetListener mDateSetListener) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                AddParcelActivity_2.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }


}














