package TestMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHP {
    //Creo los enemigos
    //Creo los personajes

    @BeforeEach
    public void setUp() {
        //Se inicializan los enemigos
        //Se inicializan los personajes
    }
    @Test
    public void marcoMaxHpTest(){
        //Que Marco no pueda tener mas hp que el maximo
    }

    @Test
    public void marcoMinHpTest(){
        //Que Marco no pueda tener hp menos que 0
    }

    @Test
    public void luisMaxHpTest(){
        //Que Luis no pueda tener mas hp que el maximo
    }

    @Test
    public void luisMinHpTest(){
        //Que Luis no npueda tener hp meno que 0
    }
}
