package TestConstructor;

import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
    private Marco marco;
    private Luis luis;

    @BeforeEach
    public void setUp(){
        marco = new Marco(10,5,5,4,4);
        luis = new Luis(15,6, 4, 6,6);
    }

    /**
     * Test para asegurarse que sean del tipo correspondiente
     */

    @Test
    public void typeTest(){
        assertEquals(PlayerType.MARCO, marco.getType());
        assertEquals(PlayerType.LUIS, luis.getType());
    }

    /** Mas test para el constructor que no se me ocurren en este momento (Buscar en internet)*/

    /** Buscar test para mostrar la protección de algunas variables uwu */

}

