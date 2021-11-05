package com.example.aventurasdemarcoyluis;

/**
 * Clase abstracta donde se definen distintos atributos que representan un personaje
 * en el juego.
 */
public abstract class AbstractCharacter implements ICharacter{
    private int atk;
    private int def;
    private int hp;
    private int hpMAX;
    private int hpMin = 0;
    private int lvl = 1;

    public AbstractCharacter(int ATK, int DEF, int HP){
        this.atk = ATK;
        this.def = DEF;
        this.hp = HP;
        this.hpMAX = HP;
    }
    /**
     * Se obtiene los punto de ataque.
     * @return los puntos de ataque.
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Cambia el valor del parametro atk.
     * @param atk nuevo puntos de ataque.
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     * Se obtiene los puntos de defensa.
     * @return los puntos de defensa.
     */
    public int getDef() {
        return def;
    }

    /**
     * Cambia el valor del parametro def.
     * @param def nuevo valor de la defensa.
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * Se obtiene los puntos de vida.
     * @return los punto de vida.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Cambia el valor del parametro hp.
     * @param hp nuevo puntos de vida.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Se obtiene los puntos de vida maxima.
     * @return los puntos de vida maxima.
     */
    public int getHpMAX() {
        return hpMAX;
    }

    /**
     * Cambia el valor del parametro hpMAX.
     * @param hpMAX nuevo puntos de vida maxima.
     */
    protected void setHpMAX(int hpMAX) {
        this.hpMAX = hpMAX;
    }

    /**
     * Se obtiene los puntos de vida minima.
     * @return los puntos de vida minima.
     */
    public int getHpMin() {
        return hpMin;
    }

    /**
     * Se obtiene el nivel del personaje.
     * @return el nivel del personaje.
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Cambia el nivel del personaje.
     * @return el nuevo nivel del personaje.
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

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