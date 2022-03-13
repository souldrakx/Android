package com.hfad.starbuzzv1;

public class Food {
    private String name;
    private String description;
    private int imageResourcesId;

    public static final Food[] foods ={
            new Food("Hamburger","Doble carne, tocino, queso frito, sukini a la parrilla chorrellana, salsa Jack Daniels, mayonesa, chimichurri, lechuga, tomate y cebolla. Acompañado con papas fritas.", R.drawable.hamburger),
            new Food("Pizza","Especial: Jamon, salami, pimineto, chorizo, piña, champiñon y salchicha", R.drawable.pizza),
            new Food("Tacos", "Tacos varios", R.drawable.tacos)
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
        return description;
    }

    public int getImageResourcesId(){
        return imageResourcesId;
    }

    public String toString(){
        return this.name;
    }
}
