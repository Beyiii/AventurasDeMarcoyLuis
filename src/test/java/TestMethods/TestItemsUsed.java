package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestItemsUsed {
    private Goomba goomba;

    private Marco marco;
    private Luis luis;

    private Star star;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(8,4,15,8);

        marco = new Marco(10,5,5,16,4);
        luis = new Luis(15,6, 4, 18,6);

        goomba.attack(marco);
        goomba.attack(luis);

        star = new Star();
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
    }

    @Test
    public void marcoUseStarTest(){
        String estadoMarco = marco.getEstado();
        marco.addItems(star);
        marco.useStar();
        String estadoExpected = "invencible";
        String estadoResult = marco.getEstado();

        assertNotEquals(estadoMarco, estadoResult);
        assertEquals(estadoExpected, estadoResult);

    }

    @Test
    public void marcoUseRedMushroomTest(){
        int hpMarco = marco.getHp();
        marco.addItems(redMushroom);
        marco.useRedMushroom();
        int hpExpected = hpMarco + (int)(10 * 16/100);
        int hpResult = marco.getHp();

        assertNotEquals(hpMarco, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void marcoUseHoneySyrupTest(){
        int fpMarco = marco.getFp();

        marco.martilloAttack(goomba); // -2 fp
        marco.martilloAttack(goomba); // -2 fp

        int fpAfterAttack = marco.getFp();

        marco.addItems(honeySyrup);
        marco.useHoneySyrup();

        int fpExpected = fpAfterAttack + 3;
        int fpResult = marco.getFp();

        assertNotEquals(fpMarco, fpResult);
        assertNotEquals(fpMarco, fpAfterAttack);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisUseStarTest(){
        String estadoLuis = luis.getEstado();
        luis.addItems(star);
        luis.useStar();
        String estadoExpected = "invencible";
        String estadoResult = luis.getEstado();

        assertNotEquals(estadoLuis, estadoResult);
        assertEquals(estadoExpected, estadoResult);
    }

    @Test
    public void luisUseRedMushroomTest(){
        int hpLuis = luis.getHp();
        luis.addItems(redMushroom);
        luis.useRedMushroom();
        int hpExpected = (int)(hpLuis + (10 * 18/100));
        int hpResult = luis.getHp();

        assertNotEquals(hpLuis, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void luisUseHoneySyrupTest(){
        int fpLuis = luis.getFp();

        luis.martilloAttack(goomba); // -2 fp
        luis.martilloAttack(goomba); // -2 fp

        int fpAfterAttack = luis.getFp();

        luis.addItems(honeySyrup);
        luis.useHoneySyrup();

        int fpExpected = fpAfterAttack + 3;
        int fpResult = luis.getFp();

        assertNotEquals(fpLuis, fpResult);
        assertNotEquals(fpLuis, fpAfterAttack);
        assertEquals(fpExpected, fpResult);
    }
}
