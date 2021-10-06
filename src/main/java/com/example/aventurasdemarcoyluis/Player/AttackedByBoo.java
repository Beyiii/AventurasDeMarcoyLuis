package com.example.aventurasdemarcoyluis.Player;

import com.example.aventurasdemarcoyluis.Enemy.Boo;

public interface AttackedByBoo {
    /**
     * Determina el nuevo hp del personaje (jugador) luego de ser atacado por un enemigo tipo Boo.
     * @param boo Enemigo tipo BOO.
     */
    void reciveAttackBoo(Boo boo);
}
