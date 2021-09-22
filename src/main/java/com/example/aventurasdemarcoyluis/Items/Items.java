package com.example.aventurasdemarcoyluis.Items;

/**
 * Interface que contiene metodos que estan en todos los items.
 */
public interface Items {
    /**
     * Obtiene el tipo de Item que es (STAR, REDMUSHROOM o HONEYSYRUP).
     * @return Retorna un ItemsType STAR, REDMUSHROOM o HONEYSYRUP.
     */
    public ItemsType getType();
}
