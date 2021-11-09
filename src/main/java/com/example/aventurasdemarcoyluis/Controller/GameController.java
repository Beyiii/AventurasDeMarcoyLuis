package com.example.aventurasdemarcoyluis.Controller;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.IEnemy;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.ICharacter;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.Items;
import com.example.aventurasdemarcoyluis.Items.ItemsType;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.*;
import com.example.aventurasdemarcoyluis.Turnos.TurnoEnemy;
import com.example.aventurasdemarcoyluis.Turnos.TurnoPlayer;
import com.example.aventurasdemarcoyluis.Turnos.Turnos;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa el controlador del juego,
 * crea lo necesario para poder jugar.
 */
public class GameController {
    private final Turnos turnos;
    private final Baul baul;
    private final TurnoPlayer turnoPlayer;
    private final TurnoEnemy turnoEnemy;
    private final Random random;
    private int enemysNumber = 0;
    private int playersNumber = 0;
    private boolean playersWin = false;
    private boolean enemysWin = false;
    private boolean win = false;

    /**
     * Crea los turnos (lista donde se encuentran los personajes)
     * y el baul de los personajes principales.
     */
    public GameController(){
        this.turnos = new Turnos();
        this.baul = new Baul();
        this.turnoPlayer = new TurnoPlayer();
        this.turnoEnemy = new TurnoEnemy();
        this.random = new Random();
    }

    /**
     * Crea al personaje principal Marco.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param FP puntos para atacar.
     * @param HP puntos de vida.
     * @return marco.
     */
    public Marco createMarco(int ATK, int DEF, int FP, int HP){
        Marco marco = new Marco(ATK, DEF, FP, HP, 1);
        turnos.addTurno(marco);
        playersNumber += 1;
        return marco;
    }

    /**
     * Crea al personaje principal Luis.
     * Se agrega el personaje inmediatamente a la lista de turnos.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param FP puntos para atacar.
     * @param HP puntos de vida.
     * @return luis.
     */
    public Luis createLuis(int ATK, int DEF, int FP, int HP){
        Luis luis = new Luis(ATK, DEF, FP, HP, 1);
        turnos.addTurno(luis);
        playersNumber +=1;
        return luis;
    }

    /**
     * Crea al enemigo Goomba.
     * Se agrega el personaje inmediatamente a la lista de turnos.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     * @return un goomba.
     */
    public Goomba createGoomba(int ATK, int DEF, int HP){
        Goomba goomba = new Goomba(ATK, DEF, HP, 1);
        turnos.addTurno(goomba);
        enemysNumber += 1;
        return goomba;
    }

    /**
     * Crea al enemigo Spiny.
     * Se agrega el personaje inmediatamente a la lista de turnos.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     * @return un spiny.
     */
    public Spiny createSpiny(int ATK, int DEF, int HP){
        Spiny spiny =new Spiny(ATK, DEF, HP, 1);
        turnos.addTurno(spiny);
        enemysNumber += 1;
        return spiny;
    }

    /**
     * Crea al enemigo Boo.
     * Se agrega el personaje inmediatamente a la lista de turnos.
     * @param ATK ataque.
     * @param DEF defensa.
     * @param HP puntos de vida.
     * @return un boo.
     */
    public Boo createBoo(int ATK, int DEF, int HP){
        Boo boo = new Boo(ATK, DEF, HP, 1);
        turnos.addTurno(boo);
        enemysNumber += 1;
        return boo;
    }

    /**
     * Se obtiene el baul.
     * @return baul.
     */
    public Baul getBaul(){
        return this.baul;
    }

    /**
     * Se obtiene la lista de turnos.
     * @return los turnos.
     */
    public Turnos getTurnos(){
        return this.turnos;
    }

    /**
     * Crea y retorna un item red mushroom.
     * @return un red mushroom.
     */
    public RedMushroom createRedMushroom(){
        return new RedMushroom();
    }

    /**
     * Crea y retorna un item honey syrup.
     * @return un honey syrup.
     */
    public HoneySyrup createHoneySyrup(){
        return new HoneySyrup();
    }

    /**
     * Agrega un item al baul.
     * @param item
     */
    public void additemBaul(Items item){
        baul.addItem(item);
    }

    /**
     * Permite al jugador usar el item red mushroom.
     * @param player jugador mario o luis.
     */
    public void useRedMushroom(IPlayer player){
        player.useRedMushroom(this.baul);
    }

    /**
     * Permite al jugador usar el item honey syrup.
     * @param player jugador mario o luis.
     */
    public void useHoneySyrup(IPlayer player){
        player.useHoneySyrup(this.baul);
    }

    /**
     * Obtiene los items que hay en el baul
     * @return una hashtable con los items actuales.
     */
    public Hashtable getItemsBaul(){
        return this.baul.getAll();
    }

    /**
     * Obtiene la cantidad de items que quedan en el baul.
     * @return una hashtable con la cantidad de items actuales.
     */
    public Hashtable getNumberOfItemsBaul(){
        return this.baul.getNumberOfItems();
    }

    /**
     * Obtiene todos los perosanjes del turno.
     * @return una lista con los personajes del turno
     */
    public List getAllTurnos(){
        return this.turnos.getAll();
    }

    /**
     * Se obtiene el personaje al que le toca jugar.
     * @return personaje asociado al turno actual.
     */
    public ICharacter actualTurn(){
        return turnos.getTurnoActual();
    }

    /**
     * Se obtiene el personaje que le toca jugar en el siguiente turno.
     * @return personaje que jugará en el proximo turno.
     */
    public ICharacter sgteTurn(){
        return turnos.getSgteTurno();
    }


    /**
     * Se finaliza el turno del personaje.
     */
    public void finTurn(){
        turnos.passTurno();
    }

    /**
     * Turno de ataque de los personajes principales.
     * @param player jugador.
     * @param enemy enemigo a atacar.
     * @param attackType tipo de ataque.
     */
    public void attackTurnPlayer(IPlayer player, IEnemy enemy, AttackType attackType){
        turnoPlayer.jugador(player);
        turnoPlayer.attack(enemy, attackType);
        this.isEnemyKO(enemy);
        this.playerWin();
    }

    /**
     * Obtiene a Marco o Luis al azar.
     * @return un personaje principal.
     */
    public IPlayer randomPlayer(){
        int r = random.nextInt(2);

        if (playersNumber == 2){
            return (IPlayer)turnos.getTurno(r);
        }
        else{
            return (IPlayer)turnos.getTurno(0);
        }
    }

    /**
     * Turno de ataque de los enemigos.
     * Se elige un jugador al azar para atacar.
     * @param enemy enemigo que atacará.
     */
    public void attackTurnEnemy(IEnemy enemy){
        IPlayer jugador = randomPlayer();
        turnoEnemy.enemy(enemy);
        turnoEnemy.attack(jugador);
        this.isPlayerKO(jugador);
        this.enemysWin();
    }

    /**
     * Turno de ataque de los enemigos.
     * @param enemy enemigo que atacará.
     * @param player jugador que será atacado.
     */
    public void attackTurnEnemy(IEnemy enemy, IPlayer player){
        turnoEnemy.enemy(enemy);
        turnoEnemy.attack(player);
        this.isPlayerKO(player);
        this.enemysWin();
    }

    /**
     * Si el enemigo está KO se remueve de los turnos y disminuye enemysNumber.
     * @param enemy enemigo.
     */
    public void isEnemyKO(IEnemy enemy){
        if (enemy.KO()){
            turnos.removeCharacter((ICharacter)enemy);
            enemysNumber -= 1;
        }
    }

    /**
     * Si el jugador está KO se remueve de los turnos y disminuye playersNumber.
     * @param player marco o luis.
     */
    public void isPlayerKO(IPlayer player){
        if (player.KO()){
            turnos.removeCharacter((ICharacter) player);
            playersNumber -= 1;
        }
    }

    /**
     * Turno jugador para usar item
     * @param player jugador.
     * @param tipo item a utilizar.
     */
    public void itemTurn(IPlayer player, ItemsType tipo){
        if(tipo == ItemsType.REDMUSHROOM){
            this.useRedMushroom(player);
        }
        else{
            this.useHoneySyrup(player);
        }
        this.finTurn();
    }

    /**
     * Usado para pasar de turno.
     */
    public void passTurn(){
        this.finTurn();
    }

    /**
     * Si el jugador ganó se finaliza la batalla, si no, se finaliza el turno.
     */
    public void playerWin(){
        if (enemysNumber == 0){
            playersWin = true;
            enemysWin = false;
            this.finBatalla();
        }
        else {
            this.finTurn();
        }
    }

    /**
     * Si los enemigos ganaron se finaliza la batalla, si no, se finaliza el turno.
     */
    public void enemysWin(){
        if (playersNumber == 0){
            enemysWin = true;
            playersWin = false;
            this.finBatalla();
        }
        else{
            this.finTurn();
        }
    }

    /**
     * Cambia a la variable win dependiendo se si se ganó o no la batalla.
     */
    public void Win(){
        if(playersWin && !enemysWin){
            win = true;
        }
        else {
            win = false;
        }
    }

    /**
     * Se obtiene si el jugador ganó o no la batalla.
     * @return true si el jugador ganó, o false si no.
     */
    public boolean isPlayersWin(){
        return win;
    }

    /**
     * Utiliza Win() y luego restaura las variables a su inicio.
     */
    public void finBatalla(){
        this.Win();
        this.turnos.clearTurnos();
        this.baul.clearBaul();
        this.turnoPlayer.reset();
        this.turnoEnemy.reset();
        enemysNumber = 0;
        playersNumber = 0;
        enemysWin = false;
        playersWin = false;
    }

    /**
     * Vuelve a la variable win a su estado inicial.
     */
    public void resetWin(){
        win = false;
    }
}
