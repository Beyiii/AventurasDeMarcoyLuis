package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.*;

/**
 * Clase extiene de AbstractEnemy.
 * Clase para representar al personaje enemigo Boo.
 */
public class Boo extends AbstractEnemy{

    /**
     * Crea al enemigo tipo Boo.
     * @param ATK Corresponde al daño total que posee Boo.
     * @param DEF Permite mitigar el daño recibido por un jugador.
     * @param HP Puntos de vida de Boo.
     * @param LVL Corresponde al nivel de Boo.
     */
    public Boo(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL, EnemyType.BOO);
    }

    /**
     * Permite que Boo pueda atacar a Luis.
     * Si Boo está derrotado no puede atacar.
     * @param player personaje jugador (solo puede atacar a Luis).
     */
    @Override
    public void attack(IPlayer player) {
        if (this.KO() == false){
            player.reciveAttackBoo(this);
        }
        else{}
    }

    /**
     * Determina el nuevo hp de Boo luego de ser atacado con Salto por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco.
     */
    @Override
    public void reciveAttackMarcoSalto(Marco marco) {
        takeDamage(marco, AttackType.SALTO);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boo) {
            Boo other = (Boo) obj;
            return ( this.getAtk()== other.getAtk())
                    && (this.getDef() == other.getDef())
                    && (this.getHpMAX() == other.getHpMAX())
                    && (this.getHpMin() == other.getHpMin())
                    && (this.getLvl() == other.getLvl())
                    && (this.getType() == other.getType());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return EnemyType.BOO.hashCode();
    }
}
