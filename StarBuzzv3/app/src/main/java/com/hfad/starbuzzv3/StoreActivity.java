package com.hfad.starbuzzv3;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.AsynchronousChannelGroup;

public class StoreActivity extends AppCompatActivity {

    public static final String EXTRA_STOREID = "storeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        int storeID = (Integer)getIntent().getExtras().get(EXTRA_STOREID);

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("STORE",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    new String[]{Integer.toString(storeID)},
                    null, null, null);

            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);

                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }

            cursor.close();
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavoriteClicked(View view){
        int storeId = (Integer)getIntent().getExtras().get(EXTRA_STOREID);
        new UpdateStoreTask().execute(storeId);
    }

    private class UpdateStoreTask extends AsyncTask<Integer, Void, Boolean> {
        private ContentValues storeValues;

        protected void onPreExecute(){
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
            storeValues = new ContentValues();
            storeValues.put("FAVORITE", favorite.isChecked());
        }

        protected Boolean doInBackground(Integer...stors){
            int storeId = stors[0];
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(StoreActivity.this);
            try{
                SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
                db.update("STORE", storeValues, "_id = ?", new String[]{Integer.toString(storeId)});
                db.close();
                return true;
            }catch(SQLiteException e){
                return false;
            }
        }

        protected  void onPostExecute(Boolean success){
            if(!success){
                Toast toast = Toast.makeText(StoreActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}