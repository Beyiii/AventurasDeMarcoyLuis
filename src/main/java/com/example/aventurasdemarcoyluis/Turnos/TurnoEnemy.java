package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.Enemy.EnemyType;
import com.example.aventurasdemarcoyluis.Enemy.IEnemy;
import com.example.aventurasdemarcoyluis.Player.AttackedByBoo;
import com.example.aventurasdemarcoyluis.Player.IPlayer;

import java.util.Random;

public class TurnoEnemy {
    private final Random random;
    private IEnemy enemy;
    private Turnos turnos;


    public TurnoEnemy(){
        this.random = new Random();
    }

    public void enemy(IEnemy enemy){
        this.enemy = enemy;
    }

    public void turnos(Turnos turnos){
        this.turnos = turnos;
    }

    public void attack(){
    }
}
