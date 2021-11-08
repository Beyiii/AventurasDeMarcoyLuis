package com.example.aventurasdemarcoyluis.State;

public class EndBattle {
    private boolean battleEnd = false;

    public EndBattle(){
    }

    public boolean isBattleEnd() {
        return battleEnd;
    }

    public void setBattleEnd(boolean battleEnd) {
        this.battleEnd = battleEnd;
    }
}
