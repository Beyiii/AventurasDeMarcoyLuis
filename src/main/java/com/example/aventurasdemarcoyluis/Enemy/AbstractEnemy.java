package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.AbstractCharacter;
import com.example.aventurasdemarcoyluis.Player.*;

/**
 * Clase abstracta que extiende de AbstracCharacter, donde se definen atributos extras que
 * determinan a un personaje enemigo (personaje que ataca a jugador)
 */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy, AttackedByMarco{
    private double k = 0.75;
    private EnemyType type;

    /**
     * Constructo de la case abstracta.
     * Crea a un enemigo con los atributos báscicos.
     * @param ATK Corresponde al daño total que posee un enemigo.
     * @param DEF Permite mitigar el daño recibido por un jugador.
     * @param HP Puntos de vida.
     * @param LVL Corresponde al nivel del personaje.
     * @param TYPE Es el tipo de enemigo: Goomba, Spiny o Boo
     */
    public AbstractEnemy(int ATK, int DEF, int HP, int LVL, EnemyType TYPE){
        super(ATK, DEF, HP, LVL);
        this.type = TYPE;
    }

    @Override
    public double getK() {
        return k;
    }

    @Override
    public EnemyType getType() {
        return type;
    }

    @Override
    public void takeDamagePlayer(IPlayer player, AttackType attackType){
        int vida = this.getHp();
        double k = attackType.getK();
        int daño = (int)(k * player.getAtk() * player.getLvl()/this.getDef());
        int newHp = isHpMin(vida-daño);
        this.setHp(newHp);
    }

    @Override
    public void reciveAttackMarcoSalto(Marco marco) {
    }

    @Override
    public void reciveAttackMarcoMartillo(Marco marco) {
    }
}

