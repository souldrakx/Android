package com.hfad.starbuzzv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class StoreCategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_category);

        ListView listStore = (ListView) findViewById(R.id.list_stors);

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try{
            db = starbuzzDatabaseHelper.getReadableDatabase();
            cursor =db.query("STORE",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);

            listStore.setAdapter(listAdapter);
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "no Database StorwCA", Toast.LENGTH_SHORT);
            toast.show();
        }



        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listStore, View itemview, int position, long id) {
                Intent intent = new Intent(StoreCategoryActivity.this, StoreActivity.class);
                intent.putExtra(StoreActivity.EXTRA_STOREID, (int) id);
                startActivity(intent);
            }
        };

        listStore.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}