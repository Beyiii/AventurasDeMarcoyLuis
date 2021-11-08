package com.example.aventurasdemarcoyluis.Baul;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

import com.example.aventurasdemarcoyluis.Items.*;

/**
 * Clase representa el baul donde estaran guardados los items.
 * Es ocupado por los personajes principales
 */
public class Baul {
    private final Hashtable<ItemsType, Items> baul;
    private final Hashtable itemsCount;
    private int redMushrooms = 0;
    private int honeySyrup = 0;

    /**
     * Crea una hashtable donde estarán los items que se pueden utilizar.
     */
    public Baul(){
        this.baul =  new Hashtable<ItemsType, Items>();
        this.itemsCount = new Hashtable();
    }

    /**
     * Aumenta las variables redMushrooms o honeySyrup en uno.
     * @param tipo REDMUSHROOM o HONEYSYRUP.
     */
    public void countItem(ItemsType tipo){
        if(tipo == ItemsType.REDMUSHROOM){
            redMushrooms += 1;
        }
        else{
            honeySyrup +=1;
        }
    }

    /**
     * Agrega un item al baul.
     * @param item red mushroom, honey syrup u otro.
     */
    public void addItem(Items item){
        this.countItem(item.getType());
        this.baul.put(item.getType(), item);
    }

    /**
     * Disminuye las variables redMushrooms o honeySyrup en uno.
     * @param item REDMUSHROOM o HONEYSYRUP.
     */
    public void takeItem(ItemsType item){
        if(item == ItemsType.REDMUSHROOM){
            redMushrooms -= 1;
        }
        else{
            honeySyrup -=1;
        }
    }

    /**
     * Retira un item del baul.
     * @param item red mushroom, honey syrup u otro.
     */
    public void removeItem(ItemsType item){
        this.takeItem(item);
        this.baul.remove(item);
    }

    /**
     * Remueve el item (si es que está) y retorna true o false.
     * @param item red mushroom, honey syrup u otro.
     * @return true si el item se encuentra en la lista, false si el no.
     */
    public boolean useItem(ItemsType item){
        boolean t = this.baul.containsKey(item);
        this.removeItem(item);
        return t;
    }

    /**
     * Se obtiene la cantidad de items que hay actualmente.
     * @return una hashtable con lo items que hay en el baul.
     */
    public Hashtable getNumberOfItems(){
        itemsCount.put(ItemsType.REDMUSHROOM, this.redMushrooms);
        itemsCount.put(ItemsType.HONEYSYRUP, this.honeySyrup);
        return itemsCount;
    }

    /**
     * Se obtiene todos los items del baul.
     * @return una hashtable con los items que quedan en el baul.
     */
    public Hashtable getAll(){
        return this.baul;
    }

    /**
     * Se obtiene si hay o no red mushrooms.
     * @return false si no hay items red mushrooms y true si es que hay.
     */
    public boolean containRedMushrooms() {
        return baul.containsKey(ItemsType.REDMUSHROOM);
    }

    /**
     * Se obtiene si hay o no honey syrups.
     * @return false si no hay items honey syrups y true sie es que hay.
     */
    public boolean containHoneySyrup() {
        return baul.containsKey(ItemsType.HONEYSYRUP);
    }

    /**
     * Borra todos los items de la lista.
     */
    public void clearBaul(){
        this.itemsCount.clear();
        this.baul.clear();
        this.redMushrooms = 0;
        this.honeySyrup = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baul baul1 = (Baul) o;
        return redMushrooms == baul1.redMushrooms && honeySyrup == baul1.honeySyrup && baul.equals(baul1.baul) && itemsCount.equals(baul1.itemsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baul, itemsCount, redMushrooms, honeySyrup);
    }
}
