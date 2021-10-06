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
    private Spiny spiny;
    private Boo boo;


    private Marco marco;
    private Luis luis;
    private RedMushroom redMushroom;

    private int setSeed = 1014646950; //para que no falle el ataque con martillo

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(1000,4,15,8);
        spiny = new Spiny(1000,4,15,8);
        boo = new Boo(1000,4,15,8);

        marco = new Marco(1000,5,5,16,4);
        luis = new Luis(1000,6, 4, 18,6);

        redMushroom = new RedMushroom();

        marco.setSeed(setSeed);
        luis.setSeed(setSeed);
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

    @Test
    public void goombaMinHpTest(){
        luis.saltoAttack(goomba);
        int noRestriction = 15 - (int)(1 * 1000 * 6/4);
        int hpExpected = goomba.getHpMin(); //hp minimo = 0
        int hpResult = goomba.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    //hay que ocupar martilo si o si
    @Test
    public void spinyMinHpTest(){
        luis.martilloAttack(spiny);
        int noRestriction = 15 - (int)(1 * 1000 * 6/4);
        int hpExpected = spiny.getHpMin(); //hp minimo = 0
        int hpResult = spiny.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpExpected, hpResult);
    }
    @Test
    public void booMinHpTest(){
        marco.saltoAttack(boo);
        int noRestriction = 15 - (int)(1 * 1000 * 4/4);
        int hpExpected = boo.getHpMin(); //hp minimo = 0
        int hpResult = boo.getHp();

        assertNotEquals(noRestriction, hpResult);
        assertEquals(hpExpected, hpResult);
    }
}
