package com.hfad.starbuzzv1;

public class Food {
    private String name;
    private String description;
    private int imageResourcesId;

    public static final Food[] foods ={
            new Food("Hamburger","Texto de hamburguesa", R.drawable.hamburger),
            new Food("Pizza","Texto pizza", R.drawable.Pizza),
            new Food("Tacos", "Texto tacos", R.drawable.tacos)
    };

    private Food(String name, String description, int imageResourcesId){
        this.name = name;
        this.description = description;
        this.imageResourcesId = imageResourcesId;
    }

    public  String getName(){
        return name;
    }

    public  String getDescription(){
        return  description;
    }

    public int getImageResourcesId(){
        return  imageResourcesId;
    }

    public String toString(){
        return this.name;
    }
}
