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
        super(ATK, DEF, FP, HP, PlayerType.MARCO);
    }

    /**
     * Permite que Marco pueda atacar con salto a sus enemigos.
     * Si Marco está fuera de combate no puede atacar.
     * @param enemy personaje enemigo.
     */
    public void saltoAttack(AttackedByMarco enemy){
        if (!this.KO()) { // NO ESTÁ DERROTADO, PUEDE ATACAR
            int newFp = isFpMin(this.getFp() - 1);
            this.setFp(newFp);
            enemy.reciveAttackMarcoSalto(this);
        }
    }

    /**
     * Permite que Marco pueda atacar con martillo a sus enemigos.
     * Si el jugador está fuera de combate no puede atacar.
     * Tiene un 25% de probabilidades de fallar (r == 1).
     * Si r es 2, 3  o 4 acierta el ataque.
     * @param enemy personaje enemigo.
     */
    public void martilloAttack(AttackedByMarco enemy) {
        int r = fallo();
        if (!this.KO() && r != 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
            enemy.reciveAttackMarcoMartillo(this);
        }
        if (!this.KO() && r == 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Marco) {
            Marco other = (Marco) obj;
            return ( this.getAtk()== other.getAtk())
                    && (this.getDef() == other.getDef())
                    && (this.getHpMAX() == other.getHpMAX())
                    && (this.getHpMin() == other.getHpMin())
                    && (this.getFpMax() == other.getFpMax())
                    && (this.getFpMin() == other.getFpMin())
                    && (this.getLvl() == other.getLvl())
                    && (this.getType() == other.getType());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return PlayerType.MARCO.hashCode();
    }
}
