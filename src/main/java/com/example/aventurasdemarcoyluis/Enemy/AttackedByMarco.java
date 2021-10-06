package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.Player.Marco;

public interface AttackedByMarco {
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
}
