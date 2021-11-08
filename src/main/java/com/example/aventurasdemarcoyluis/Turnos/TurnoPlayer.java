package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Enemy.AttackedByLuis;
import com.example.aventurasdemarcoyluis.Enemy.AttackedByMarco;
import com.example.aventurasdemarcoyluis.Enemy.IEnemy;
import com.example.aventurasdemarcoyluis.Items.Items;
import com.example.aventurasdemarcoyluis.Items.ItemsType;
import com.example.aventurasdemarcoyluis.Player.*;

public class TurnoPlayer {
    private IPlayer player;
    private IEnemy enemy = null;
    private AttackType attackType = null;

    public TurnoPlayer(){}

    public void jugador(IPlayer player){
        this.player = player;
    }

    public void reset(){
        player = null;
        enemy = null;
        attackType = null;
    }

    public void marcoAttack(){
        Marco marco =(Marco)player;
        AttackedByMarco enemigo = (AttackedByMarco)enemy;

        if(this.attackType == AttackType.MARTILLO){
            marco.martilloAttack(enemigo);
        }
        else{
            marco.saltoAttack(enemigo);
        }

        reset();
    }

    public void luisAttack(){
        Luis luis = (Luis)player;
        AttackedByLuis enemigo = (AttackedByLuis)enemy;

        if(this.attackType == AttackType.MARTILLO){
            luis.martilloAttack(enemigo);
        }

        else{
            luis.saltoAttack(enemigo);
        }

        reset();
    }

    public void attack(IEnemy enemy, AttackType attackType){
        this.enemy = enemy;
        this.attackType = attackType;

        if (player.getType() == PlayerType.MARCO){
            marcoAttack();
        }

        else{
            luisAttack();
        }
    }
}
