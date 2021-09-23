package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestHP {
    private Goomba goomba;

    private Marco marco;
    private Luis luis;
    private RedMushroom redMushroom;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(1000,4,15,8);

        marco = new Marco(10,5,5,16,4);
        luis = new Luis(15,6, 4, 18,6);

        redMushroom = new RedMushroom();
    }

    /**
     * Podria ser que los jugadores tengan una lista de items y que cuando los gastan desaparezcan de la lista
     */

    @Test
    public void marcoMaxHpTest(){
        int hpMarco = marco.getHp();
        marco.addItems(redMushroom);
        marco.useRedMushroom(); //Marco ya está en el maximo de su hp
        int noRestriction = hpMarco + (int)(10 * 16/100 );
        int hpResult = marco.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpMarco, hpResult);
    }

    @Test
    public void marcoMinHpTest(){
        goomba.attack(marco);
        int noRestriction = 16 - (int)(0.75 * 1000 * 8/5 );
        int hpExpected = marco.getHpMin(); //hp minimo = 0
        int hpResult = marco.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void luisMaxHpTest(){
        int hpLuis = luis.getHp();
        luis.addItems(redMushroom);
        luis.useRedMushroom(); //Luis ya está en el maximo de su hp
        int noRestriction = hpLuis + (int)(10 * 18/100 );
        int hpResult = luis.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpLuis, hpResult);
    }

    @Test
    public void luisMinHpTest(){
        goomba.attack(luis);
        int noRestriction = 18 - (int)(0.75 * 1000 * 8/6 );
        int hpExpected = luis.getHpMin(); //hp minimo = 0
        int hpResult = luis.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpExpected, hpResult);
    }
}
