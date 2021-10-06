package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.Luis;

public interface AttackedByLuis {
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
