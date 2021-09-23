package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Enemy.EnemyType;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Star) {
            Star other = (Star) obj;
            return ( this.getType() == other.getType());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ItemsType.STAR.hashCode();
    }
}
