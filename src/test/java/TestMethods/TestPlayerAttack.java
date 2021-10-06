package TestMethods;


import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPlayerAttack  {
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;

    private int kSalto = 1;
    private double kMartillo = 1.5;

    private int setSeed = 1014646950; //para que no falle el ataque con martillo

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);
        spiny = new Spiny(3,10,15,8);
        boo = new Boo(8,3,15,5);

        marco = new Marco(10,5,5,20,4);
        luis = new Luis(5,6, 4, 20,6);

        marco.setSeed(setSeed);
        luis.setSeed(setSeed);
    }
    /**Que Marco ataque a goomba con salto (lo puede dañar)
     * Que Marco ataque a goomba con martillo (lo puede dañar)
     * Que el daño sea igual al indicado en la formula del enunciado
     */
    @Test
    public void marcoAttackGoombaSaltoTest(){
        int hpGoomba = goomba.getHp();
        int fpMarco = marco.getFp();

        marco.saltoAttack(goomba);

        int hpExpected = 15 - (kSalto * 10 * 4/4);
        int hpResult = goomba.getHp();

        int fpExpected = 5 - 1;
        int fpResult = marco.getFp();

        assertNotEquals(hpGoomba, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void marcoAttackGoombaMartilloTest(){
        int hpGoomba = goomba.getHp();
        int fpMarco = marco.getFp();

        marco.martilloAttack(goomba);

        int hpExpected = 15 - (int)(kMartillo * 10 * 4/4);
        int hpResult = goomba.getHp();

        int fpExpected = 5 - 2;
        int fpResult = marco.getFp();

        assertNotEquals(hpGoomba, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }


    @Test
    public void marcoAttackSpinySaltoTest(){
        int hpSpiny = spiny.getHp();
        int hpMarco = marco.getHp();
        int fpMarco = marco.getFp();

        marco.saltoAttack(spiny);

        int hpExpectedMarco = 20 - (int)(20 * 5/100);
        int hpResultSpiny = spiny.getHp();
        int hpResultMarco = marco.getHp();

        int fpExpected = 5 - 1;
        int fpResult = marco.getFp();

        assertEquals(hpSpiny, hpResultSpiny);

        assertNotEquals(hpMarco, hpResultMarco);
        assertEquals(hpExpectedMarco, hpResultMarco);

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void marcoAttackSpinyMartilloTest(){
        int hpSpiny = spiny.getHp();
        int fpMarco = marco.getFp();

        marco.martilloAttack(spiny);

        int hpExpected = 15 - (int)(kMartillo * 10 * 4/10);
        int hpResult = spiny.getHp();

        int fpExpected = 5 - 2;
        int fpResult = marco.getFp();

        assertNotEquals(hpSpiny, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }
    @Test
    public void marcoAttackBooSaltoTest(){
        int hpBoo = boo.getHp();
        int fpMarco = marco.getFp();

        marco.saltoAttack(boo);

        int hpExpected = 15 - (int)(kSalto * 10 * 4/3);
        int hpResult = boo.getHp();

        int fpExpected = 5 - 1;
        int fpResult = marco.getFp();

        assertNotEquals(hpBoo, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void marcoAttackBooMartilloTest(){
        int hpBoo = boo.getHp();
        int fpMarco = marco.getFp();

        marco.martilloAttack(boo);

        int hpResult = boo.getHp();

        int fpExpected = 5 - 2;
        int fpResult = marco.getFp();

        assertEquals(hpBoo, hpResult); // boo esquiva el martillo

        assertNotEquals(fpMarco, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackGoombaSaltoTest(){
        int hpGoomba = goomba.getHp();
        int fpLuis = luis.getFp();

        luis.saltoAttack(goomba);

        int hpExpected = 15 - (int)(kSalto * 5 * 6/4);
        int hpResult = goomba.getHp();

        int fpExpected = 4 - 1;
        int fpResult = luis.getFp();

        assertNotEquals(hpGoomba, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackGoombaMartilloTest(){
        int hpGoomba = goomba.getHp();
        int fpLuis = luis.getFp();

        luis.martilloAttack(goomba);

        int hpExpected = 15 - (int)(kMartillo * 5 * 6/4);
        int hpResult = goomba.getHp();

        int fpExpected = 4 - 2;
        int fpResult = luis.getFp();

        assertNotEquals(hpGoomba, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackSpinySaltoTest(){
        int hpSpiny = spiny.getHp();
        int hpLuis = luis.getHp();
        int fpLuis = luis.getFp();

        luis.saltoAttack(spiny);

        int hpExpectedLuis = (int)(20 - (20 * 5/100));
        int hpResultSpiny = spiny.getHp();
        int hpResultLuis = luis.getHp();

        int fpExpected = 4 - 1;
        int fpResult = luis.getFp();

        assertEquals(hpSpiny, hpResultSpiny);

        assertNotEquals(hpLuis, hpResultLuis);
        assertEquals(hpExpectedLuis, hpResultLuis);

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackSpinyMartilloTest(){
        int hpSpiny = spiny.getHp();
        int fpLuis = luis.getFp();

        luis.martilloAttack(spiny);

        int hpExpected = 15 - (int)(kMartillo * 5 * 6/10);
        int hpResult = spiny.getHp();

        int fpExpected = 4 - 2;
        int fpResult = luis.getFp();

        assertNotEquals(hpSpiny, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }
}
