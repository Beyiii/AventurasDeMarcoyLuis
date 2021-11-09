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

    /**
     * Crea las acciones que podrán realizar los personajes principales.
     */
    public TurnoPlayer(){}

    /**
     * Cambia la variable jugador.
     * @param player marco o luis.
     */
    public void jugador(IPlayer player){
        this.player = player;
    }

    /**
     * Permite a marco atacar.
     */
    public void marcoAttack(){
        Marco marco =(Marco)player;
        AttackedByMarco enemigo = (AttackedByMarco)enemy;

        if(this.attackType == AttackType.MARTILLO){
            marco.martilloAttack(enemigo);
        }
        else{
            marco.saltoAttack(enemigo);
        }
    }

    /**
     * Permite a luis atacar.
     */
    public void luisAttack(){
        Luis luis = (Luis)player;
        AttackedByLuis enemigo = (AttackedByLuis)enemy;

        if(this.attackType == AttackType.MARTILLO){
            luis.martilloAttack(enemigo);
        }

        else{
            luis.saltoAttack(enemigo);
        }
    }

    /**
     * Permite que marco o luis puedan atacar.
     * @param enemy enemigo al que se atacará.
     * @param attackType ataque que se usará.
     */
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

    /**
     * Restaura las variables a su inicio.
     */
    public void reset(){
        player = null;
        enemy = null;
        attackType = null;
    }
}
