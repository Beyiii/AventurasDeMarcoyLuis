package com.example.aventurasdemarcoyluis.Controller;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.Items;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.IPlayer;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import com.example.aventurasdemarcoyluis.Player.PlayerType;
import com.example.aventurasdemarcoyluis.Turnos.Turnos;

/**
 * Clase que representa el controlador del juego,
 * crea lo necesario para poder jugar.
 */
public class GameController {
    private final Turnos turnos;
    private final Baul baul;

    /**
     * Crea los turnos (lista donde se encuentran los personajes)
     * y el baul de los personajes principales.
     */
    public GameController(){
        this.turnos = new Turnos();
        this.baul = new Baul();
    }

    /**
     * Crea al personaje principal Marco.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param FP puntos para atacar.
     * @param HP puntos de vida.
     */
    public void createMarco(int ATK, int DEF, int FP, int HP){
        Marco marco = new Marco(ATK, DEF, FP, HP, 1);
        turnos.addTurnoIndice(0, marco);
    }

    /**
     * Crea al personaje principal Luis.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param FP puntos para atacar.
     * @param HP puntos de vida.
     */
    public void createLuis(int ATK, int DEF, int FP, int HP){
        Luis luis = new Luis(ATK, DEF, FP, HP, 1);
        turnos.addTurnoIndice(1, luis);
    }

    /**
     * Crea al enemigo Goomba.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     */
    public void createGoomba(int ATK, int DEF, int HP){
        Goomba goomba = new Goomba(ATK, DEF, HP, 1);
        turnos.addTurno(goomba);
    }

    /**
     * Crea al enemigo Spiny.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     */
    public void createSpiny(int ATK, int DEF, int HP){
        Spiny spiny =new Spiny(ATK, DEF, HP, 1);
        turnos.addTurno(spiny);
    }

    /**
     * Crea al enemigo Boo.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     */
    public void createBoo(int ATK, int DEF, int HP){
        Boo boo = new Boo(ATK, DEF, HP, 1);
        turnos.addTurno(boo);
    }

    /**
     * Crea y retorna un item red mushroom.
     * @return un red mushroom.
     */
    public RedMushroom createRedMushroom(){
        return new RedMushroom();
    }

    /**
     * Crea y retorna un item honey syrup.
     * @return un honey syrup.
     */
    public HoneySyrup createHoneySyrup(){
        return new HoneySyrup();
    }

    /**
     * Agrega un item al baul.
     * @param item
     */
    public void additemBaul(Items item){
        baul.addItem(item);
    }

    









}
