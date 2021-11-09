package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.AttackedByBoo;
import com.example.aventurasdemarcoyluis.Player.IPlayer;
import com.example.aventurasdemarcoyluis.Player.PlayerType;

import java.util.Random;

public class TurnoEnemy {
    private IEnemy enemy = null;
    private IPlayer player = null;


    /**
     * Crea las acciones que puede hacer un enemigo en su turno.
     */
    public TurnoEnemy(){
    }

    /**
     * Cambia a la variable enemy.
     * @param enemy enemigo.
     */
    public void enemy(IEnemy enemy){
        this.enemy = enemy;
    }

    /**
     * Permite que goomba ataque.
     */
    public void goombaAttack(){
        Goomba goomba = (Goomba)enemy;
        goomba.attack(player);
    }

    /**
     * Permite que spiny ataque.
     */
    public void spinyAttack(){
        Spiny spiny = (Spiny)enemy;
        spiny.attack(player);
    }

    /**
     * Permite que boo ataque.
     */
    public void booAttack(){
        Boo boo = (Boo)enemy;
        if(player.getType() == PlayerType.LUIS){
            boo.attack((AttackedByBoo) player);
        }
    }

    /**
     * Usado en el turno de un enemigo.
     * Permite que cualquier enemigo pueda atacar.
     * @param player jugador al que atacará el enemigo.
     */
    public void attack(IPlayer player){
        this.player = player;

        if(enemy.getType() == EnemyType.GOOMBA){
            goombaAttack();
        }
        if (enemy.getType() == EnemyType.SPINY){
            spinyAttack();
        }
        else{
            booAttack();
        }
    }

    /**
     * Restaura las variables a su inicio.
     */
    public void reset(){
        this.enemy = null;
        this.player = null;
    }
}
