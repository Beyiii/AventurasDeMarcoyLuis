package com.example.aventurasdemarcoyluis.Controller;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Player.IPlayer;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import com.example.aventurasdemarcoyluis.Player.PlayerType;
import com.example.aventurasdemarcoyluis.Turnos.Turnos;

public class GameController {
    private final Turnos turnos = new Turnos();
    private final Baul baul = new Baul();

    public GameController(){}

    public void createMarco(int ATK, int DEF, int FP, int HP){
        Marco marco = new Marco(ATK, DEF, FP, HP, 1);
        turnos.addTurno(marco);
    }

    public void createLuis(int ATK, int DEF, int FP, int HP){
        Luis luis = new Luis(ATK, DEF, FP, HP, 1);
        turnos.addTurno(luis);
    }

}
