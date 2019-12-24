package com.example.service_side.ui.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.service_side.R;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.viewModel.ParcelViewModel;

import java.util.List;

public class HistoryParcelActivity extends AppCompatActivity {

    private ParcelViewModel parcelViewModel;
    ListView listView;
    String mTitle[] = {"Facebook", "Whatsapp", "Twitter", "Instagram", "Youtube"};
    String mDescription[] = {"Facebook Description", "Whatsapp Description", "Twitter Description", "Instagram Description", "Youtube Description"};
    int images[] = {R.drawable.facebook, R.drawable.whatsapp, R.drawable.twitter, R.drawable.instagram, R.drawable.youtube};

    // so our images and other things are set in array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcel);
        listView = findViewById(R.id.listView);
        // now create an adapter class
        MutableLiveData<List<Parcel>> parcels;
        parcelViewModel = ViewModelProviders.of(this).get(ParcelViewModel.class);
//        parcelViewModel.getAllParcel().observe(this, new Observer<List<Parcel>>() {
//                    @Override
//                    public void onChanged(List<Parcel> parcels) {
//
//                    }
        HistoryParcelActivity.MyAdapter adapter = new HistoryParcelActivity.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(HistoryParcelActivity.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(HistoryParcelActivity.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(HistoryParcelActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(HistoryParcelActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(HistoryParcelActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }

    }
}




