package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.*;

public interface IEnemy {
    /**
     * Se obtiene los punto de ataque.
     * @return los puntos de ataque.
     */
    public int getAtk();

    /**
     * Obtiene la constante k de los enemigos.
     * @return la constante k.
     */
    public double getK();

    /**
     * Se obtiene el nivel del personaje.
     * @return el nivel del personaje.
     */
    public int getLvl();

    /**
     * Obtiene el tipo de enemigo que es (GOOMBA, SPINY O BOO).
     * @return el tipo de enemigo.
     */
    public EnemyType getType();

    /**
     * Metodo auxiliar. Reduce el hp del enemigo luego de ser atacado por un jugador.
     * @param player Tipo del jugador (MARCO O LUIS).
     * @param attackType Tipo de ataque que ocupó el jugador (SALTO O MARTILLO).
     */
    void takeDamagePlayer(IPlayer player, AttackType attackType);

    boolean KO();

}

