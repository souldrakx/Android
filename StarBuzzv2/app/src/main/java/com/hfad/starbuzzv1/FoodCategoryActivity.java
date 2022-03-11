package com.hfad.starbuzzv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Food.foods);
        ListView listFoods = (ListView) findViewById(R.id.list_foods);
        listFoods.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listFoods, View itemview, int position, long id) {
                Intent intent = new Intent(FoodCategoryActivity.this, FoodActivity.class);
                intent.putExtra(FoodActivity.EXTRA_FOOD, (int) id);
            }
        };
        listFoods.setOnItemClickListener(itemClickListener);
    }
}