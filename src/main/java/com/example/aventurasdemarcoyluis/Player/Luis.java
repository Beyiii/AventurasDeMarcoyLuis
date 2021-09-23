package com.example.aventurasdemarcoyluis.Player;

import com.example.aventurasdemarcoyluis.Enemy.*;

/**
 * Clase extiende de AbstractPlayer.
 * Clase para representar al personaje jugador Luis.
 */
public class Luis extends AbstractPlayer {

    /**
     * Crea al jugador tipo Luis, usa el constructor de la clase abstracta AbstractPlayer.
     * @param ATK Corresponde al daño total que posee un Luis.
     * @param DEF Permite mitigar el daño recibido por un enemigo.
     * @param FP Puntos de ataque. Utilizados para relizar ataques.
     * @param HP Puntos de vida de Luis.
     * @param LVL Corresponde al nivel de Luis.
     */
    public Luis(int ATK, int DEF, int FP, int HP, int LVL) {
        super(ATK, DEF, FP, HP, LVL, PlayerType.LUIS);
    }

    /**
     * Permite que Luis pueda atacar con salto a sus enemigos.
     * Si Luis está fuera de combate no puede atacar.
     * @param enemy personaje enemigo.
     */
    @Override
    public void saltoAttack(IEnemy enemy){
        if (!this.KO()){
            int newFp = isFpMin(this.getFp() - 1);
            this.setFp(newFp);
            enemy.reciveAttackLuisSalto(this);
        }
    }

    /**
     * Permite que Luis pueda atacar con martillo a sus enemigos.
     * Si Luis está fuera de combate no puede atacar.
     * Tiene un 25% de probabilidades de fallar.
     * @param enemy personaje enemigo.
     */
    @Override
    public void martilloAttack(IEnemy enemy){
        int r = probabilidadMartillo(25);
        if (!this.KO() && r == 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
            enemy.reciveAttackluisMartillo(this);
        }
        if (!this.KO() && r != 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
        }
    }

    /**
     * Permite que Luis pueda atacar con martillo a sus enemigos.
     * Si Luis está fuera de combate no puede atacar.
     * Existe una probabilidad de fallar.
     * @param enemy personaje enemigo.
     * @param probabilidadDeFallo Porcentaje (0-100) de que el ataque falle.
     */
    public void martilloAttack(IEnemy enemy, int probabilidadDeFallo) {
        int r = probabilidadMartillo(probabilidadDeFallo);
        if (!this.KO() && r == 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
            enemy.reciveAttackluisMartillo(this);
        }
        if (!this.KO() && r != 1){
            int newFp = isFpMin(this.getFp() - 2);
            this.setFp(newFp);
        }
    }

    /**
     * Determina el nuevo hp de Luis luego de ser atacado por un enemigo tipo Boo.
     * @param boo Enemigo tipo BOO.
     */
    @Override
    public void reciveAttackBoo(Boo boo) {
        takeDamage(boo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Luis) {
            Luis other = (Luis) obj;
            return ( this.getAtk()== other.getAtk())
                    && (this.getDef() == other.getDef())
                    && (this.getHpMAX() == other.getHpMAX())
                    && (this.getHpMin() == other.getHpMin())
                    && (this.getFpMax() == other.getFpMax())
                    && (this.getFpMin() == other.getFpMin())
                    && (this.getLvl() == other.getLvl())
                    && (this.getType() == other.getType());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return PlayerType.LUIS.hashCode();
    }
}
