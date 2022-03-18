package com.hfad.starbuzzv3;

public class Drink {
    private String name;
    private String description;
    private int imageResourcesId;

    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shot with steamed milk", R.drawable.latte),
            new Drink("Cappuccion", "Espresso, hot milk, and steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted an brewed fresh", R.drawable.filter)
    };

    private Drink(String name, String description, int imageResourcesId){
        this.name = name;
        this.description = description;
        this.imageResourcesId = imageResourcesId;
    }

    public String getDescription(){
        return description;
    }

    public  String getName(){
        return name;
    }

    public int getImageResourcesId(){
        return imageResourcesId;
    }

    public String toString(){
        return this.name;
    }
}
