package com.example.aventurasdemarcoyluis.Player;

import java.util.Hashtable;
import java.util.Random;
import com.example.aventurasdemarcoyluis.AbstractCharacter;
import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.*;

/**
 * Clase abstracta que extiende de AbstracCharacter, donde se definen atributos extras que
 * determinan a un personaje principal del juego (jugador/player).
 */

public abstract class AbstractPlayer extends AbstractCharacter implements IPlayer {
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
     * @param LVL Corresponde al nivel del personaje.
     * @param TYPE Es el tipo de personaje principar: Marco o Luis.
     */
    public AbstractPlayer(int ATK, int DEF, int FP, int HP, int LVL, PlayerType TYPE){
        this.setAtk(ATK);
        this.setDef(DEF);
        this.fp = FP;
        this.fpMax = FP;
        this.setHp(HP);
        this.setLvl(LVL);
        this.setHpMAX(HP);
        this.type = TYPE;
        this.inventario = new Hashtable<ItemsType, Items>(5);
    }


    /** GET AND SETTERS */
    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getFpMax() {
        return fpMax;
    }

    public int getFpMin() {
        return fpMin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
        if (fp <= this.getFpMax()){
            return this.getFpMax();
        }
        else{
            return fp;
        }
    }

    /**
     * Metodo auxiliar. Usado para el ataque tipo martillo
     * @param probabilidadDeFallo porcentaje de fallo.
     * @return 0 si el está dentro del porcentaje de fallo dado, 1 si no.
     */
    public static int probabilidadMartillo(int probabilidadDeFallo){
        int random = new Random().nextInt(100);
        if (random < probabilidadDeFallo) {
            //FALLO EL ATAQUE
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public void takeDamage(AbstractEnemy enemy){
        int vida = this.getHp();
        int daño = (int)(enemy.getK() * enemy.getAtk() * (enemy.getLvl()/this.getDef()));
        int newHp = isHpMin(vida-daño);
        this.setHp(newHp);
    }

    @Override
    public void saltoAttack(IEnemy enemy) {
    }

    @Override
    public void martilloAttack(IEnemy enemy) {
    }

    @Override
    public void reciveAttackGoomba(Goomba goomba) {
        takeDamage(goomba);
    }

    @Override
    public void reciveAttackSpiny(Spiny spiny) {
        takeDamage(spiny);
    }

    @Override
    public void reciveAttackBoo(Boo boo) {
    }

    @Override
    public void addItems(Items item){
        this.inventario.put(item.getType(), item);
    }


    @Override
    public void useStar() {
        Items i = inventario.get(ItemsType.STAR);
        if (i != null && this.KO() == false){
            this.setEstado("invencible");
        }
        else{}
    }

    @Override
    public void useRedMushroom() {
        Items i = inventario.get(ItemsType.REDMUSHROOM);
        if (i != null && this.KO() == false){
            int vida = (int) (10 * this.getHpMAX() / 100);
            int newHp = isHpMax(vida);
            this.setHp(newHp);
        }
        else{}
    }


    @Override
    public void useHoneySyrup() {
        Items i = inventario.get(ItemsType.HONEYSYRUP);
        if (i != null && this.KO() == false) {
            int newFp = isFpMax(this.getFp() + 3);
            this.setFp(newFp);
        }
        else{}
    }
}
