package TestConstructorAndProtection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
    //Creo los personajes

    @BeforeEach
    public void setUp() {
        //Se inicializan los los personajes
    }
    @Test
    public void constructorTest(){
        //Que el tipo de personaje sea: Marco o Luis

        //otras cosas del constructor
    }

    @Test
    public void protectionTest(){
        //Que no se pueda settear ningun dato del personaje (hp, lvl, ...)
    }
}
