package com.example.aventurasdemarcoyluis;

public interface ICharacter {
    int getAtk();
    void setAtk(int atk);
    int getDef();
    void setDef(int def);
    int getHp();
    void setHp(int hp);
    int getHpMAX();
    int getHpMin();
    int getLvl();
    void setLvl(int lvl);
    int isHpMin(int hp);
    int isHpMax(int hp);
    boolean KO();
}
