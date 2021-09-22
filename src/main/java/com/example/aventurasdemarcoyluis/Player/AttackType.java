package com.example.aventurasdemarcoyluis.Player;

/**
 * Clase para representar los tipos de ataques que hay.
 */
public enum AttackType {
    SALTO(1), MARTILLO(1.5);

    private double k;

    private AttackType(double k) {
        this.k = k;
    }

    public double getK() {
        return k;
    }
}
