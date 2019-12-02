package com.example.service_side.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.service_side.R;
import java.util.Calendar;


public class package_details_2 extends AppCompatActivity {

    private static final String TAG = "package_details_2";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button bt1;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details_2);
        mDisplayDate = (TextView) findViewById(R.id.text_date);
        bt1=(Button)findViewById(R.id.button_date);
        bt2=(Button)findViewById(R.id.button_date_delivery);
        Intent i = getIntent();
        Spinner spinner = (Spinner) findViewById(R.id.spinner_type);
        String [] list_enum_type=getResources().getStringArray(R.array.enum_type);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinner_enum_type,R.id.txt,list_enum_type);
        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_wieght);
        String [] list_enum_type1=getResources().getStringArray(R.array.enum_wieght);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.spinner_enum_wieght,R.id.txt1,list_enum_type1);
        spinner1.setAdapter(adapter1);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        package_details_2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


          mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
               mDisplayDate.setText(date);
            }
        };

    }

}
