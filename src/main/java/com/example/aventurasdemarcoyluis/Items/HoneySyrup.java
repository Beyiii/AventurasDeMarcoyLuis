package com.example.aventurasdemarcoyluis.Items;

/**
 * Clase para representar el item Honey Syrup a traves de type.
 */
public class HoneySyrup implements Items{
    final private ItemsType type;  // No estoy segura si se escribe así

    /**
     * Crea el item Honey Syrup a traves del atributo type.
     */
    public HoneySyrup() {
        this.type = ItemsType.HONEYSYRUP;
    }

    @Override
    public ItemsType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HoneySyrup) {
            HoneySyrup other = (HoneySyrup) obj;
            return ( this.getType() == other.getType());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ItemsType.HONEYSYRUP.hashCode();
    }
}
