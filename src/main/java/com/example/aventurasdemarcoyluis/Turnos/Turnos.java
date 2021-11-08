package com.example.aventurasdemarcoyluis.Turnos;

import com.example.aventurasdemarcoyluis.ICharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el orden de los personajes que habrá
 * en el juego.
 */
public class Turnos {
    private final List<ICharacter> turnoList;
    private int turno;

    /**
     * Crea una lista donde estarán los personajes ordenados por su turno.
     * Crea una lista donde estaran los tipos de los personajes.
     * turno es el indice del personaje que le toca jugar.
     */
    public Turnos(){
        turnoList = new ArrayList<ICharacter>();
        turno = 0;
    }

    /**
     * Cambia el numero de a quien le toca jugar.
     * @param turno entero que representa a un jugador.
     */
    public void setTurnoNumber(int turno) {
        this.turno = turno;
    }

    /**
     * Obtiene el turno(numero asociado al personaje que le toca jugar)
     * @return el numero del personaje que le toca jugar.
     */
    public int getTurnoNumber() {
        return turno;
    }

    /**
     * Cambia el turno actual por el que siguiente turno.
     */
    public void passTurno(){
        int n = this.getTurnoNumber();
        int nTurnos = this.turnoList.size() - 1;

        if (n == nTurnos){
            setTurnoNumber(0);;
        }
        else{
            setTurnoNumber(n+1);
        }
    }

    /**
     * Agrega a un personaje a la lista de turnos.
     * Agrega el tipo del personaje en la lista de tipos.
     * Se debe agregar los personajes en el orden que uno desee que esten.
     * @param personaje Marco, Luis, Goomba, Spiny o Boo.
     */
    public void addTurno(ICharacter personaje){
        this.turnoList.add(personaje);
    }

    /**
     * Agreaga a un personaje a la lista de turnos.
     * @param indice el lugar de la lista de turnos en donde se quiere poner al personaje.
     * @param personaje Marco, Luis, Goomba, Spiny o Boo.
     */
    public void addTurnoIndice(int indice, ICharacter personaje){
        this.turnoList.add(indice, personaje);
    }

    /**
     * Se obtiene el personaje asociado al turno actual.
     * @return personaje al que le toca jugar.
     */
    public ICharacter getTurnoActual() {
        int indice = this.getTurnoNumber();
        return turnoList.get(indice);
    }

    /**
     * Se obtiene el personaje asociado al turno siguiente.
     * @return personaje que le tocará jugar en el proximo turno.
     */
    public ICharacter getSgteTurno(){
        int sgte = this.getTurnoNumber() + 1;
        return turnoList.get(sgte);
    }

    /**
     * Se obtiene el personaje asociado al turno entregado.
     * @param indice turno.
     * @return personaje asociado al indice.
     */
    public ICharacter getTurno(int indice){
        return turnoList.get(indice);
    }

    /**
     * Se obtiene los personajes ordenados por sus turnos.
     * @return lista de los personajes.
     */
    public List getAll(){
        return this.turnoList;
    }

    /**
     * Borra los elementos de la lista de turnos.
     */
    public void clearTurnos(){
        this.turnoList.clear();
    }

    public void removeCharacter(ICharacter character){
        turnoList.remove(character);
    }
}