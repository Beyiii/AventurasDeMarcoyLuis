package com.example.aventurasdemarcoyluis.State;

public class Win {
    private boolean playersWin = false;
    private boolean enemysWin = false;

    public Win(){}

    public boolean isEnemysWin() {
        return enemysWin;
    }

    public boolean isPlayersWin() {
        return playersWin;
    }

    public void setEnemysWin(boolean enemysWin) {
        this.enemysWin = enemysWin;
    }

    public void setPlayersWin(boolean playersWin) {
        this.playersWin = playersWin;
    }
}
