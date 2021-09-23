package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestEnemyAttack {
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);
        spiny = new Spiny(3,10,15,8);
        boo = new Boo(8,3,5,5);

        marco = new Marco(10,5,5,4,4);
        luis = new Luis(15,6, 4, 6,6);
    }

    /**
     * Que goomba ataque a marco (su ataque es normal)
     * Que el daño sea igual al indicado en la formula del enunciado
     */
    @Test
    public void goombaAttackMarcoTest(){
        int hpMarco = marco.getHp();
        goomba.attack(marco);
        int hpExpected = (4 - (int)(0.75 * 2 * 8/5));
        int hpResult = marco.getHp();

        assertNotEquals(hpMarco, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void spinyAttackMarcoTest(){
        int hpMarco = marco.getHp();
        spiny.attack(marco);
        int hpExpected = (4 - (int)(0.75 * 3 * 8/5));
        int hpResult = marco.getHp();

        assertNotEquals(hpMarco, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void booAttackMarcoTest(){
        int hpMarco = marco.getHp();
        boo.attack(marco);
        int hpResult = marco.getHp();

        assertEquals(hpMarco, hpResult); //boo no dañó a Marco, ya que no lo puede atacar
    }

    @Test
    public void goombaAttackLuisTest(){
        int hpLuis = luis.getHp();
        goomba.attack(luis);
        int hpExpected = (6 - (int)(0.75 * 2 * 8/6));
        int hpResult = luis.getHp();

        assertNotEquals(hpLuis, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void spinyAttackLuisTest(){
        int hpLuis = luis.getHp();
        spiny.attack(luis);
        int hpExpected = (6 - (int)(0.75 * 3 * 8/6));
        int hpResult = luis.getHp();

        assertNotEquals(hpLuis, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void booAttackLuisTest(){
        int hpLuis = luis.getHp();
        boo.attack(luis);
        int hpExpected = (6 - (int)(0.75 * 8 * 5/6));
        int hpResult = luis.getHp();

        assertNotEquals(hpLuis, hpResult);
        assertEquals(hpExpected, hpResult);
    }
}
