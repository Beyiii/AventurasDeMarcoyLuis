package com.example.aventurasdemarcoyluis.Player;

import com.example.aventurasdemarcoyluis.Enemy.*;

/**
 * Clase extiende de AbstractPlayer.
 * Clase para representar al personaje jugador Marco.
 */
public class Marco extends AbstractPlayer {

    /**
     * Crea al jugador tipo Marco, usa el constructor de la clase abstracta AbstractPlayer.
     * @param ATK Corresponde al daño total que posee Marco.
     * @param DEF Permite mitigar el daño recibido por un enemigo.
     * @param FP Puntos de ataque. Utilizados para relizar ataques.
     * @param HP Puntos de vida de Marco.
     * @param LVL Corresponde al nivel de Marco.
     */
    public Marco(int ATK, int DEF, int FP, int HP, int LVL) {
        super(ATK, DEF, FP, HP, LVL, PlayerType.MARCO);
    }

    /**
     * Permite que Marco pueda atacar con salto a sus enemigos.
     * Si Marco está fuera de combate no puede atacar.
     * @param enemy personaje enemigo.
     */
    @Override
    public void saltoAttack(IEnemy enemy){
        if (this.KO() == false) { // NO ESTÁ DERROTADO, PUEDE ATACAR
            int newFp = isFpMin(this.getFp() - 1);
            this.setFp(newFp);
            enemy.reciveAttackMarcoSalto(this);
        }
        else{ //ESTÁ DERROTADO, NO HACE NADA
        }
    }

    /**
     * Permite que Marco pueda atacar con martillo a sus enemigos.
     * Si el jugador está fuera de combate no puede atacar.
     * @param enemy personaje enemigo.
     */
    @Override
    public void martilloAttack(IEnemy enemy) {
        int r = probabilidadMartillo(25);
        if (this.KO() == false && r == 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
            enemy.reciveAttackMarcoMartillo(this);
        }
        else {}
    }

    public void martilloAttack(IEnemy enemy, int probabilidadDeFallo) {
        int r = probabilidadMartillo(probabilidadDeFallo);
        if (this.KO() == false && r == 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
            enemy.reciveAttackMarcoMartillo(this);
        }
        else {}
    }
}
