package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKOAttack {
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;
    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,1,8);
        spiny = new Spiny(3,1,1,8);
        boo = new Boo(8,3,1,5);

        marco = new Marco(10,1,5,1,4);
        luis = new Luis(15,6, 4, 1,6);    }

    @Test
    public void marcoKOAttackGoombaTest(){
        goomba.attack(marco);
        assertTrue(marco.KO()); //Con el ataque anterior marco está fuera de combate

        int hpGoomba = goomba.getHp();
        marco.saltoAttack(goomba);
        marco.martilloAttack(goomba,0);

        assertEquals(1, hpGoomba); //No hubo daño hacia goomba
    }

    @Test
    public void marcoKOAttackSpinyTest(){
        spiny.attack(marco);
        assertTrue(marco.KO()); //Con el ataque anterior marco está fuera de combate

        int hpSpiny = spiny.getHp();
        marco.martilloAttack(spiny,0);

        assertEquals(1, hpSpiny); //No hubo daño hacia spiny
    }

    @Test
    public void marcoKOAttackBooTest(){
        spiny.attack(marco);
        assertTrue(marco.KO()); //Con el ataque anterior marco está fuera de combate

        int hpBoo = boo.getHp();
        marco.saltoAttack(boo);

        assertEquals(1, hpBoo); //No hubo daño hacia boo
    }

    @Test
    public void luisKOAttackGoombaTest(){
        goomba.attack(luis);
        assertTrue(luis.KO()); //Con el ataque anterior luis está fuera de combate

        int hpGoomba = goomba.getHp();
        luis.saltoAttack(goomba);
        luis.martilloAttack(goomba,0);

        assertEquals(1, hpGoomba); //No hubo daño hacia goomba
    }

    @Test
    public void luisKOAttackSpinyTest(){
        spiny.attack(luis);
        assertTrue(luis.KO()); //Con el ataque anterior luis está fuera de combate

        int hpSpiny = spiny.getHp();
        luis.martilloAttack(spiny, 0);

        assertEquals(1, hpSpiny); //No hubo daño hacia spiny
    }

    @Test
    public void goombaKOAttackMarcoTest(){
        marco.saltoAttack(goomba);
        assertTrue(goomba.KO()); //Con el ataque anterior goomba está fuera de combate

        int hpMarco = marco.getHp();
        goomba.attack(marco);

        assertEquals(1, hpMarco);
    }

    @Test
    public void goombaKOAttackLuisTest(){
        luis.saltoAttack(goomba);
        assertTrue(goomba.KO()); //Con el ataque anterior goomba está fuera de combate

        int hpLuis = luis.getHp();
        goomba.attack(luis);

        assertEquals(1, hpLuis);
    }

    @Test
    public void spinyKOAttackMarcoTest(){
        marco.martilloAttack(spiny,0);
        assertTrue(spiny.KO()); //Con el ataque anterior spiny está fuera de combate

        int hpMarco = marco.getHp();
        spiny.attack(marco);

        assertEquals(1, hpMarco);
    }

    @Test
    public void spinyKOAttackLuisTest(){
        luis.martilloAttack(spiny, 0);
        assertTrue(spiny.KO()); //Con el ataque anterior spiny está fuera de combate

        int hpLuis = luis.getHp();
        spiny.attack(luis);

        assertEquals(1, hpLuis);
    }

    @Test
    public void booKOAttackLuisTest(){
        marco.saltoAttack(boo);
        assertTrue(boo.KO()); //Con el ataque anterior boo está fuera de combate

        int hpLuis = luis.getHp();
        goomba.attack(luis);

        assertEquals(1, hpLuis);
    }
}
