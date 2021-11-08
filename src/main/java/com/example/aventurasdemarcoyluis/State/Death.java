package com.example.aventurasdemarcoyluis.State;

public class Death {
    private boolean marcoDie = false;
    private boolean luisDie = false;
    private boolean playersDie = false;

    private boolean goombaDie = false;
    private boolean spinyDie = false;
    private boolean booDie = false;
    private boolean enemysDie = false;

    public Death(){
    }

    public boolean isMarcoDie() {
        return marcoDie;
    }

    public boolean isLuisDie() {
        return luisDie;
    }

    public boolean isPlayersDie() {
        if (marcoDie && luisDie){
            setPlayersDie(true);
        }

        return playersDie;
    }

    public boolean isGoombaDie() {
        return goombaDie;
    }

    public boolean isSpinyDie() {
        return spinyDie;
    }

    public boolean isBooDie() {
        return booDie;
    }

    public boolean isEnemysDie() {
        if(goombaDie && spinyDie && booDie){
            setEnemysDie(true);
        }
        return enemysDie;
    }

    public void setMarcoDie(boolean marcoDie) {
        this.marcoDie = marcoDie;
    }

    public void setLuisDie(boolean luisDie) {
        this.luisDie = luisDie;
    }

    public void setPlayersDie(boolean playersDie) {
        this.playersDie = playersDie;
    }

    public void setGoombaDie(boolean goombaDie) {
        this.goombaDie = goombaDie;
    }

    public void setSpinyDie(boolean spinyDie) {
        this.spinyDie = spinyDie;
    }

    public void setBooDie(boolean booDie) {
        this.booDie = booDie;
    }

    public void setEnemysDie(boolean enemysDie) {
        this.enemysDie = enemysDie;
    }

}
