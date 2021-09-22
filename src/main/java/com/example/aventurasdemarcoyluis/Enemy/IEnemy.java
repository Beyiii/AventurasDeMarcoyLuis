package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.*;

public interface IEnemy {

    /**
     * Metodo auxiliar. Reduce el hp del enemigo luego de ser atacado por un jugador.
     * @param player Tipo del jugador (MARCO O LUIS).
     * @param attackType Tipo de ataque que ocupó el jugador (SALTO O MARTILLO).
     */
    void takeDamage(AbstractPlayer player, AttackType attackType);

    /**
     * Permite que el enemigo pueda atacar al personaje jugador.
     * @param player personaje jugador (Marco o Luis).
     */
    void attack(IPlayer player);

    /**
     * Determina el nuevo hp del enemigo luego de ser atacado con Salto por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco.
     */
    void reciveAttackMarcoSalto(Marco marco);

    /**
     * Determina el nuevo hp del enemigo luego de ser atacado con Martillo por un personaje tipo Marco.
     * @param marco Personaje (jugador) tipo Marco
     */
    void reciveAttackMarcoMartillo(Marco marco);

    /**
     * Determina el nuevo hp del enemigo luego de ser atacado con Salto por un personaje tipo Luis.
     * @param luis Personaje (jugador) tipo Luis.
     */
    void reciveAttackLuisSalto(Luis luis);

    /**
     * Determina el nuevo hp del enemigo luego de ser atacado con Martillo por un personaje tipo Luis.
     * @param luis Personaje (jugador) tipo Luis
     */
    void reciveAttackluisMartillo(Luis luis);
}

