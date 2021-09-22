package com.example.aventurasdemarcoyluis.Items;

/**
 * Clase para representar el item Red Mushroom a traves de type.
 */
public class RedMushroom implements Items{
    final private ItemsType type;  // No estoy segura si se escribe así

    /**
     * Crea el item Red Mushroom a traves del atributo type.
     */
    public RedMushroom() {
        this.type = ItemsType.REDMUSHROOM;
    }

    @Override
    public ItemsType getType() {
        return type;
    }
}
