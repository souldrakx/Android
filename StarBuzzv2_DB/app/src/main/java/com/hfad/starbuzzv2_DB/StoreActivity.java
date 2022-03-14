package com.hfad.starbuzzv2_DB;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {

    public static final String EXTRA_STOREID = "storeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        int storeID = (Integer)getIntent().getExtras().get(EXTRA_STOREID);
        Store store = Store.stors[storeID];

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(store.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(store.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(store.getImageResourcesId());
        photo.setContentDescription(store.getName());
    }
}