package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.AttackedByBoo;
import com.example.aventurasdemarcoyluis.Player.IPlayer;
import com.example.aventurasdemarcoyluis.Player.PlayerType;

import java.util.Random;

public class TurnoEnemy {
    private IEnemy enemy = null;
    private IPlayer player = null;


    public TurnoEnemy(){
    }

    public void enemy(IEnemy enemy){
        this.enemy = enemy;
    }

    public void goombaAttack(){
        Goomba goomba = (Goomba)enemy;
        goomba.attack(player);
    }

    public void spinyAttack(){
        Spiny spiny = (Spiny)enemy;
        spiny.attack(player);
    }

    public void booAttack(){
        Boo boo = (Boo)enemy;
        if(player.getType() == PlayerType.LUIS){
            boo.attack((AttackedByBoo) player);
        }
    }

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

    public void reset(){
        this.enemy = null;
        this.player = null;
    }
}
