package com.example.aventurasdemarcoyluis.Items;

/**
 * Clase para representar el item Star a traves de type.
 */
public class Star implements Items {
    final private ItemsType type;  // No estoy segura si se escribe así

    /**
     * Crea el item Star a traves del atributo type.
     */
    public Star(){
        this.type = ItemsType.STAR;
    }

    @Override
    public ItemsType getType() {
        return type;
    }
}
