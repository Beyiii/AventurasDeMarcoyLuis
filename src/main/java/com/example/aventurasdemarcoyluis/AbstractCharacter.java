package com.example.aventurasdemarcoyluis;

/**
 * Clase abstracta donde se definen distintos atributos que representan un personaje
 * en el juego.
 */

public abstract class AbstractCharacter {
    private int atk;
    private int def;
    private int hp;
    private int hpMAX;
    private int hpMin = 0;
    private int lvl = 1;

    /** GET AND SETTERS */

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMAX() {
        return hpMAX;
    }

    protected void setHpMAX(int hpMAX) {
        this.hpMAX = hpMAX;
    }

    public int getHpMin() {
        return hpMin;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /** -------------------------------------------------------------- */

    /**
     * Determina si el personaje está fuera de combate
     * @return true si el personaje está fuera de combate. Retorna false si el personaje aún puede atacar.
     */
    public boolean KO() {
        if(this.getHp() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Verifica si algún cálculo hecho con la variable hp es igual o menor a 0.
     * Esto permite que el hp del personaje no pueda ser inferior al hp minimo.
     * @param hp Hp del personaje luego de un ataque.
     * @return El hp definitivo. hpMin si el hp que se calculó es menor a 0, y hp calculado si no.
     */
    public int isHpMin(int hp){
        if (hp <= this.getHpMin()){
            return this.getHpMin();
        }
        else{
            return hp;
        }
    }

    /**
     * Verifica si algún cálculo hecho con la variable hp excede al hp máximo.
     * Esto permite que el hp del personaje no pueda ser mayor al hpMax.
     * @param hp Hp del personaje luego de un ataque.
     * @return El hp definitivo. hpMax si el hp que se calculó es mayor al hp máximo, y hp calculado si no.
     */
    public int isHpMax(int hp){
        if ( hp >= this.getHpMAX()){
            return this.getHpMAX();
        }
        else{
            return hp;
        }
    }
}