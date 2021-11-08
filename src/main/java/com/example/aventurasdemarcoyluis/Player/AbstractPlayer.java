package com.example.aventurasdemarcoyluis.Player;

import java.util.Hashtable;
import java.util.Random;
import com.example.aventurasdemarcoyluis.AbstractCharacter;
import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.*;

/**
 * Clase abstracta que extiende de AbstracCharacter, donde se definen atributos extras que
 * determinan a un personaje principal del juego (jugador/player).
 */

public abstract class AbstractPlayer extends AbstractCharacter implements IPlayer {
    private final Random random;
    private int fp;
    private int fpMin = 0;
    private int fpMax;
    private PlayerType type;
    private String estado = "vencible";
    private Hashtable<ItemsType, Items> inventario;

    /**
     * Constructor de la clase abstracta.
     * Crea un personaje principal (jugador) con los atributos básicos.
     * @param ATK Corresponde al daño total que posee un personaje.
     * @param DEF Permite mitigar el daño recibido por un enemigo.
     * @param FP Puntos de ataque. Utilizados para relizar ataques.
     * @param HP Puntos de vida.
     * @param TYPE Es el tipo de personaje principar: Marco o Luis.
     */
    public AbstractPlayer(int ATK, int DEF, int FP, int HP, PlayerType TYPE){
        super(ATK, DEF, HP);
        this.fp = FP;
        this.fpMax = FP;
        random = new Random();
        this.type = TYPE;
        this.inventario = new Hashtable<ItemsType, Items>(5);
    }

    /**
     * Obtiene los puntos para poder atacar.
     * @return los puntos para poder atacar.
     */
    public int getFp() {
        return fp;
    }

    /**
     * Cambia el valor del fp.
     * @param fp el nuevo valor de fp.
     */
    public void setFp(int fp) {
        this.fp = fp;
    }

    /**
     * Obtiene el valor de fp maximo.
     * @return el valor de fp maximo.
     */
    public int getFpMax() {
        return fpMax;
    }

    /**
     * Obtiene el valor de fp maximo.
     * @return el valor de fp minimo.
     */
    public int getFpMin() {
        return fpMin;
    }

    /**
     * Obtiene el estado en el que se encuentra el personaje.
     * Los estados son "Vencible" e "Invencible".
     * @return el estado del personaje.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Cambia elo estado en que se encuentra el jugador.
     * @param estado el nuevo estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el tipo de jugador (Marco o Luis).
     * @return tipo del jugador.
     */
    public PlayerType getType() {
        return type;
    }

    /**
     * Verifica si algún cálculo hecho con la variable fp es igual o menor a 0.
     * Esto permite que el fp del personaje no pueda ser inferior al fp minimo.
     * @param fp Fp del personaje luego de un ataque.
     * @return El fp definitivo. fpMin si el fp que se calculó es menor a 0, y fp calculado si no.
     */
    public int isFpMin(int fp){
        if (fp <= this.getFpMin()){
            return this.getFpMin();
        }
        else{
            return fp;
        }
    }

    /**
     * Verifica si algún cálculo hecho con la variable fp excede al hp máximo.
     * Esto permite que el fp del personaje no pueda ser mayor al fpMax.
     * @param fp Fp del personaje luego de un ataque.
     * @return El fp definitivo. fpMax si el fp que se calculó es mayor al fp máximo, y fp calculado si no.
     */
    public int isFpMax(int fp){
        if (fp >= this.getFpMax()){
            return this.getFpMax();
        }
        else{
            return fp;
        }
    }

    /**
     * Metodo auxiliar. Usado para el metodo fallo.
     * @param seed valor de la semilla.
     */
    public void setSeed(final long seed){
        random.setSeed(seed);
    }

    /**
     * Metodo auxiliar. Usado para el ataque tipo martillo
     * @return retorna un número entre [1,4] cada uno con 25% de probabilidades de salir.
     */
    public int fallo(){
       return random.nextInt(4) + 1;
    }

    @Override
    public void takeDamageEnemy(IEnemy enemy){
        int vida = this.getHp();
        int daño = (int)(enemy.getK() * enemy.getAtk() * enemy.getLvl()/this.getDef());
        int newHp = isHpMin(vida-daño);
        this.setHp(newHp);
    }

    @Override
    public void reciveAttackGoomba(Goomba goomba) {
        takeDamageEnemy(goomba);
    }

    @Override
    public void reciveAttackSpiny(Spiny spiny) {
        takeDamageEnemy(spiny);
    }

    @Override
    public void useRedMushroom(Baul baul) {
        boolean t = baul.useItem(ItemsType.REDMUSHROOM);
        if (t == true && this.KO() == false){
            int vida = this.getHp() + (int)(10 * this.getHpMAX() / 100);
            int newHp = isHpMax(vida);
            this.setHp(newHp);
        }
        else{}
    }


    @Override
    public void useHoneySyrup(Baul baul) {
        boolean t = baul.useItem(ItemsType.HONEYSYRUP);
        if (t == true && this.KO() == false) {
            int newFp = isFpMax(this.getFp() + 3);
            this.setFp(newFp);
        }
        else{}
    }
}
