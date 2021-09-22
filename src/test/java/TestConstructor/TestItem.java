package TestConstructorAndProtection;

import com.example.aventurasdemarcoyluis.EnemyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItem {
    //Creo los items

    @BeforeEach
    public void setUp() {
        //Se inicializan los items
    }
    @Test
    public void constructorTest(){
        //Que el tipo de items sea: star, red mushroom o honey syrup

        //otras cosas del constructor
    }

    @Test
    public void protectionTest(){
        //Que no se pueda settear ningun dato de los items
    }

}
