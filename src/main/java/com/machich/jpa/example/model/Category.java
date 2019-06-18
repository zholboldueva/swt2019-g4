package com.machich.jpa.example.model;

public enum Category {
    Altenpflege("Altenpflege"),
    Auto_Rad_Boot ("Auto, Rad & Boot "),
    Babysitter_Kinderbetreuung("Babysitter & Kinderbetreuung"),
    Elektronik("Elektronik"),
    Haus_Garten("Haus & Garten"),
    Künstler_Musiker("Künstler & Musiker"),
    Reise_Event("Reise & Event"),
    Tierbetreuung_Training("Tierbetreuung & Training"),
    Umzug_Transport("Umzug & Transport"),
    OTHER("Andere");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
