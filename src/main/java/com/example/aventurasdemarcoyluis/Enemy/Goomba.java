package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.*;

/**
 * Clase extiene de AbstractEnemy.
 * Clase para representar al personaje enemigo Goomba.
 */
public class Goomba extends AbstractEnemy {

    /**
     * Crea al enemigo tipo Goomba.
     * @param ATK Corresponde al daño total que posee Goomba.
     * @param DEF Permite mitigar el daño recibido por un jugador.
     * @param HP Puntos de vida de Goomba.
     * @param LVL Corresponde al nivel de Goomba.
     */
    public Goomba(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL, EnemyType.GOOMBA);
    }

    /**
     * Permite que Goomba pueda atacar al jugador.
     * Si Goomba está derrotado no puede atacar.
     * @param player personaje jugador (Marco o Luis).
     */
    @Override
    public void attack(IPlayer player) {
        if (this.KO() == false){
            player.reciveAttackGoomba(this);
        }
        else{}
    }

    /**
     * Determina el nuevo hp de Goomba luego de ser atacado con Salto por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco.
     */
    @Override
    public void reciveAttackMarcoSalto(Marco marco) {
        takeDamage(marco, AttackType.SALTO);
    }

    /**
     * Determina el nuevo hp de Goomba luego de ser atacado con Martillo por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco
     */

    @Override
    public void reciveAttackMarcoMartillo(Marco marco) {
        takeDamage(marco, AttackType.MARTILLO);
    }


    /**
     * Determina el nuevo hp de Goomba luego de ser atacado con Salto por un personaje tipo Luis.
     * @param luis Personaje (jugador) tipo Luis.
     */
    @Override
    public void reciveAttackLuisSalto(Luis luis) {
        takeDamage(luis, AttackType.SALTO);
    }

    /**
     * Determina el nuevo hp de Goomba luego de ser atacado con Martillo por un personaje tipo Luis.
     * @param luis Personaje (jugador) tipo Luis.
     */

    @Override
    public void reciveAttackluisMartillo(Luis luis) {
        takeDamage(luis, AttackType.MARTILLO);
    }
}
