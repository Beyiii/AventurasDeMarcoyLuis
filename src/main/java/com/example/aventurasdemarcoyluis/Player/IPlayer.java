package com.example.aventurasdemarcoyluis.Player;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.Items;

public interface IPlayer{
    /**
     * Se obtiene los punto de ataque.
     * @return los puntos de ataque.
     */
    public int getAtk();

    /**
     * Se obtiene el nivel del personaje.
     * @return el nivel del personaje.
     */
    public int getLvl();

    /**
     * Obtiene el tipo de enemigo que es (GOOMBA, SPINY O BOO).
     * @return el tipo de enemigo.
     */
    public PlayerType getType();

    /**
     * Metodo auxiliar. Reduce el hp del jugador luego de ser atacado por un enemigo.
     * @param enemy Tipo de enemigo (GOOMBA, SPINY O BOO)
     */
    void takeDamageEnemy(IEnemy enemy);

    /**
     * Determina el nuevo hp del personaje (jugador) luego de ser atacado por un enemigo tipo Goomba.
     * @param goomba Enemigo tipo GOOMBA.
     */
    void reciveAttackGoomba(Goomba goomba);

    /**
     * Determina el nuevo hp del personaje (jugador) luego de ser atacado por un enemigo tipo Spiny.
     * @param spiny Enemigo tipo SPINY.
     */
    void reciveAttackSpiny(Spiny spiny);


    /**
     * Agrega items al inventario del personajes (jugador)
     * @param item Item que será agregadoa l inventario del jugador.
     */
    void addItems(Items item);

    /**
     * Metodo para que el jugador pueda usar el item Star,
     * el cual cambia el estado del personaje a invencible (no determinado por el momento).
     * Si el jugador está derrotado no puede ocupar el item.
     */
    void useStar();

    /**
     * Metodo para que el jugador pueda usar el item Red Mushroom,
     * el cual hace que el peronaje pueda recuperar el 10% de sus puntos de vida (hp).
     * Si el jugador está derrotado no puede ocupar el item.
     */
    void useRedMushroom();

    /**
     * Metodo para que el jugador pueda ocupas el item Honey Syrup,
     * el cual hace que el personaje tenga 3 puntos de ataque (fp) extras.
     * Si el jugador está derrotado no puede ocupar el item.
     */
    void useHoneySyrup();
}
