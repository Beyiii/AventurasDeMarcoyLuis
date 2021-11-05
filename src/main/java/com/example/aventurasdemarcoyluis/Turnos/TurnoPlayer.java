package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.Items.Items;
import com.example.aventurasdemarcoyluis.Player.IPlayer;

public class TurnoPlayer {
    private IPlayer player;

    public TurnoPlayer(){}

    public void jugador(IPlayer player){
        this.player = player;
    }

    public void attack(){
    }

    public void item( ){

    }

    public void pass(Turnos turnos){
        turnos.sgteTurno();
    }


}
