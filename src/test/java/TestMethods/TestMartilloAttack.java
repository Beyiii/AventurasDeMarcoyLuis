package TestMethods;

import java.util.*;
import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestMartilloAttack{
    private Goomba goomba;

    private Marco marco;
    private Luis luis;

    private int setSeed;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);

        marco = new Marco(10,5,5,4,4);
        luis = new Luis(10,6, 4, 6,4);

        setSeed = new Random().nextInt();
    }

    @Test
    public void marcoMartilloAttack(){
        final var testRandom = new Random(setSeed);
        marco.setSeed(setSeed);
        int acertar = 1;  //para acertar el golpe tiene que ser 2,3 o 4

        while(goomba.getHp() == 15){
            final int prob = testRandom.nextInt(4)+1;
            marco.martilloAttack(goomba);
            acertar = prob;
        }

        int hpExpected = 15 - (int)(1.5 * 10 * 4/4); // 0

        assertEquals(hpExpected, goomba.getHp());
        assertNotEquals(1, acertar);

        System.out.println("semilla = " + setSeed + " acertar= " + acertar);
    }

    @Test
    public void luisMartilloAttack(){
        final var testRandom = new Random(setSeed);
        luis.setSeed(setSeed);
        int acertar = 1;    //para acertar el golpe tiene que ser 2,3 o 4

        while(goomba.getHp() == 15){
            final int prob = testRandom.nextInt(4)+1;
            luis.martilloAttack(goomba);
            acertar = prob;
        }

        int hpExpected = 15 - (int)(1.5 * 10 * 4/4); // 0

        assertEquals(hpExpected, goomba.getHp());
        assertNotEquals(1, acertar);

        System.out.println("semilla = " + setSeed + " acertar= " + acertar);
    }
}