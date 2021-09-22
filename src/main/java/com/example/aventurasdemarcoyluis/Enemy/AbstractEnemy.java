package com.example.aventurasdemarcoyluis.Enemy;

import com.example.aventurasdemarcoyluis.AbstractCharacter;
import com.example.aventurasdemarcoyluis.Player.*;

/**
 * Clase abstracta que extiende de AbstracCharacter, donde se definen atributos extras que
 * determinan a un personaje enemigo (personaje que ataca a jugador)
 */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemy {
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
        this.setAtk(ATK);
        this.setDef(DEF);
        this.setHp(HP);
        this.setLvl(LVL);
        this.type = TYPE;
    }

    /** GET AND SETTERS */
    public double getK() {
        return k;
    }

    public EnemyType getType() {
        return type;
    }

    @Override
    public void takeDamage(AbstractPlayer player, AttackType attackType){
        int vida = this.getHp();
        double k = attackType.getK();
        int daño = (int)(k * player.getAtk() * (player.getLvl()/this.getDef()));
        int newHp = isHpMin(vida-daño);
        this.setHp(newHp);
    }

    @Override
    public void attack(IPlayer player) {
    }

    @Override
    public void reciveAttackMarcoSalto(Marco marco) {
    }

    @Override
    public void reciveAttackMarcoMartillo(Marco marco) {
    }

    @Override
    public void reciveAttackLuisSalto(Luis luis) {
    }

    @Override
    public void reciveAttackluisMartillo(Luis luis) {
    }
}

