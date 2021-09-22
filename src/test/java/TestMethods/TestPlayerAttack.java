package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);
        spiny = new Spiny(3,10,15,8);
        boo = new Boo(8,3,12,5);

        marco = new Marco(10,5,5,4,4);
        luis = new Luis(11,6, 4, 6,6);
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

        int hpExpected = (int)(15 - (kSalto * 10 * 4/4));
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

        marco.martilloAttack(goomba, 0);

        int hpExpected = (int)(15 - (kMartillo * 10 * 4/4));
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

        int hpExpectedMarco = (int)(4 - (4 * 5/100));
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

        marco.martilloAttack(spiny, 0);

        int hpExpected = (int)(15 - (kMartillo * 10 * 4/10));
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

        int hpExpected = (int)(12 - (kSalto * 10 * 4/3));
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

        marco.martilloAttack(boo, 0);

        int hpResult = boo.getHp();

        int fpExpected = 5 - 1;
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

        int hpExpected = (int)(15 - (kSalto * 11 * 6/4));
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

        luis.martilloAttack(goomba,0);

        int hpExpected = (int)(15 - (kMartillo * 11 * 6/4));
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

        int hpExpectedLuis = (int)(6 - (6 * 5/100));
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

        luis.martilloAttack(spiny,0);

        int hpExpected = (int)(15 - (kMartillo * 11 * 6/10));
        int hpResult = spiny.getHp();

        int fpExpected = 4 - 2;
        int fpResult = luis.getFp();

        assertNotEquals(hpSpiny, hpResult);
        assertEquals(hpExpected, hpResult);

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackBooSaltoTest(){
        int hpBoo = boo.getHp();
        int fpLuis = luis.getFp();

        luis.saltoAttack(boo);

        int hpResult = boo.getHp();

        int fpExpected = 4 - 1;
        int fpResult = luis.getFp();

        assertEquals(hpBoo, hpResult); // luis no puede atacar a boo

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisAttackBooMartilloTest(){
        int hpBoo = boo.getHp();
        int fpLuis = luis.getFp();

        luis.martilloAttack(boo,0);

        int hpResult = boo.getHp();

        int fpExpected = 4 - 2;
        int fpResult = luis.getFp();

        assertEquals(hpBoo, hpResult); // luis no puede atacar a boo

        assertNotEquals(fpLuis, fpResult);
        assertEquals(fpExpected, fpResult);

    }
}
