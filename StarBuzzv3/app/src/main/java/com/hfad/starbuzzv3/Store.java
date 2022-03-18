package com.hfad.starbuzzv3;

public class Store {
    private String name;
    private String description;
    private int imageResourcesId;

    public static final Store[] stors = {
            new Store("Torta Plaza", "Somos mexicanos, fiesteros, bochincheros, anfitriones, familiares y escandalosos. Te damos la bienvenida y te tratamos como en casa.", R.drawable.torta_plaza_logo),
            new Store("Starbucks", "Inspirar y nutrir el espíritu humano: Una persona, una taza y una comunidad a la vez.", R.drawable.starbucks_logo),
            new Store("Carl's JR", "Ofrecer las mejores hamburguesas con un excelente servicio en instalaciones de la más alta calidad en un ambiente confortable y familiar.", R.drawable.carls_jr)
    };

    private Store(String name, String description, int imageResourcesId){
        this.name = name;
        this.description = description;
        this.imageResourcesId = imageResourcesId;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImageResourcesId(){
        return imageResourcesId;
    }

    public String toString(){
        return this.name;
    }

}
