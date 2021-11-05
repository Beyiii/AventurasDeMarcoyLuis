package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.*;

/**
 * Clase extiene de AbstractEnemy.
 * Clase para representar al personaje enemigo Spiny.
 */
public class Spiny extends AbstractEnemy implements AttackedByLuis{

    /**
     * Crea al enemigo tipo Spiny.
     * @param ATK Corresponde al daño total que posee Spiny.
     * @param DEF Permite mitigar el daño recibido por un jugador.
     * @param HP Puntos de vida de Spiny.
     * @param LVL Corresponde al nivel de Spiny.
     */
    public Spiny(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, EnemyType.SPINY);
    }

    /**
     * Permite que Spiny pueda atacar al jugador.
     * Si Spiny está derrotado no puede atacar.
     * @param player personaje jugador (Marco o Luis).
     */

    public void attack(IPlayer player) {
        if (this.KO() == false){
            player.reciveAttackSpiny(this);
        }
        else{}
    }

    /**
     * Determina el nuevo hp de Marco luego de que saltara sobre Spiny.
     * Spiny no sufre daño con este ataque.
     * @param marco Personaje (jugador) tipo Marco.
     */
    @Override
    public void reciveAttackMarcoSalto(Marco marco) {
        int daño = (int)(5 * marco.getHp()/100);
        marco.setHp(marco.getHp() - daño);
    }

    /**
     * Determina el nuevo hp de Spiny luego de ser atacado con Martillo por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco
     */
    @Override
    public void reciveAttackMarcoMartillo(Marco marco) {
        takeDamagePlayer(marco, AttackType.MARTILLO);
    }

    /**
     * Determina el nuevo hp de Luis luego de que saltara sobre Spiny.
     * Spiny no sufre daño con este ataque.
     * @param luis Personaje (jugador) tipo Luis.
     */
    @Override
    public void reciveAttackLuisSalto(Luis luis) {
        int daño = (int)(5 * luis.getHp()/100);
        luis.setHp(luis.getHp() - daño);
    }

    /**
     * Determina el nuevo hp de Spiny luego de ser atacado con Martillo por un personaje tipo Luis.
     * @param luis Personaje (jugador) tipo Luis
     */
    @Override
    public void reciveAttackluisMartillo(Luis luis) {
        takeDamagePlayer(luis, AttackType.MARTILLO);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Spiny) {
            Spiny other = (Spiny) obj;
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
        return EnemyType.SPINY.hashCode();
    }
}
