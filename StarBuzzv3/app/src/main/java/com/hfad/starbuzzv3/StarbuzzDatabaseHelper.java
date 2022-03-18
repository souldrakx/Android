package com.hfad.starbuzzv3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 2;

    StarbuzzDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }

    private static void insertFood(SQLiteDatabase db, String name, String description, int resourcesId) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("NAME", name);
        foodValues.put("DESCRIPTION", description);
        foodValues.put("IMAGE_RESOURCE_ID", resourcesId);
        db.insert("FOOD", null, foodValues);
    }

    private static void insertStore(SQLiteDatabase db, String name, String description, int resourcesId) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("NAME", name);
        foodValues.put("DESCRIPTION", description);
        foodValues.put("IMAGE_RESOURCE_ID", resourcesId);
        db.insert("STORE", null, foodValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");

            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.drawable.cappuccino);
            insertDrink(db, "Filter", "Our best drip coffe", R.drawable.filter);

            db.execSQL("CREATE TABLE FOOD(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");

            insertFood(db,"Hamburger","Doble carne, tocino, queso frito, sukini a la parrilla chorrellana, salsa Jack Daniels, mayonesa, chimichurri, lechuga, tomate y cebolla. Acompañado con papas fritas.", R.drawable.hamburger);
            insertFood(db,"Pizza","Especial: Jamon, salami, pimineto, chorizo, piña, champiñon y salchicha", R.drawable.pizza);
            insertFood(db,"Tacos", "Tacos varios", R.drawable.tacos);

            db.execSQL("CREATE TABLE STORE(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");

            insertStore(db,"Torta Plaza", "Somos mexicanos, fiesteros, bochincheros, anfitriones, familiares y escandalosos. Te damos la bienvenida y te tratamos como en casa.", R.drawable.torta_plaza_logo);
            insertStore(db,"Starbucks", "Inspirar y nutrir el espíritu humano: Una persona, una taza y una comunidad a la vez.", R.drawable.starbucks_logo);
            insertStore(db,"Carl's JR", "Ofrecer las mejores hamburguesas con un excelente servicio en instalaciones de la más alta calidad en un ambiente confortable y familiar.", R.drawable.carls_jr);
        }

        if(oldVersion < 2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE FOOD ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE STORE ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
