package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestKO {
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;

    private int setSeed = 1014646950; //para que no falle el ataque con martillo

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,3,8);
        spiny = new Spiny(3,2,3,8);
        boo = new Boo(8,3,3,5);

        marco = new Marco(10,5,5,3,4);
        luis = new Luis(15,6, 4, 3,6);

        marco.setSeed(setSeed);
        luis.setSeed(setSeed);
    }

    @Test
    public void marcoKOTest(){
        assertFalse(marco.KO()); //falso porque aun no es derrotado

        goomba.attack(marco);
        spiny.attack(marco);
        goomba.attack(marco);

        assertTrue(marco.KO());

    }

    @Test
    public void LuisKOTest(){
        assertFalse(luis.KO()); //falso porque aun no es derrotado

        goomba.attack(luis);
        spiny.attack(luis);
        boo.attack(luis);

        assertTrue(luis.KO());
    }
    @Test
    public void goombaKOTest(){
        assertFalse(goomba.KO()); //falso porque aun no es derrotado

        marco.saltoAttack(goomba);
        luis.martilloAttack(goomba);
        marco.martilloAttack(goomba);

        assertTrue(goomba.KO());
    }

    @Test
    public void spinyKOTest(){
        assertFalse(spiny.KO()); //falso porque aun no es derrotado

        marco.martilloAttack(spiny);
        luis.martilloAttack(spiny);
        marco.martilloAttack(spiny);

        assertTrue(spiny.KO());
    }

    @Test
    public void booKOTest(){
        assertFalse(boo.KO()); //falso porque aun no es derrotado

        marco.saltoAttack(boo);
        marco.saltoAttack(boo);

        assertTrue(boo.KO());
    }
}
