package TestConstructor;

import com.example.aventurasdemarcoyluis.Items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestItem {
    private Star star;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp(){
        star = new Star();
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
    }

    @Test
    public void equalsTest(){
        assertEquals(star, new Star());
        assertEquals(redMushroom, new RedMushroom());
        assertEquals(honeySyrup, new HoneySyrup());
    }

    @Test
    public void notEqualsTest(){
        assertNotEquals(star, redMushroom);
        assertNotEquals(star, honeySyrup);
        assertNotEquals(redMushroom, honeySyrup);
    }

    /**
     * Test para asegurarse que sean del tipo correspondiente
     */

    @Test
    public void typeTest(){
        assertEquals(ItemsType.STAR, star.getType());
        assertEquals(ItemsType.REDMUSHROOM, redMushroom.getType());
        assertEquals(ItemsType.HONEYSYRUP, honeySyrup.getType());
    }

    /** Mas test para el constructor que no se me ocurren en este momento (Buscar en internet)*/

    /** Buscar test para mostrar la protección de algunas variables uwu */
}