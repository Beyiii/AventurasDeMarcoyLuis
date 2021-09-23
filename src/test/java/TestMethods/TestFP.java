package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Player.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestFP {
    private Goomba goomba;

    private Marco marco;
    private Luis luis;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(1000, 4, 15, 8);

        marco = new Marco(10, 5, 1, 16, 4);
        luis = new Luis(15, 6, 1, 18, 6);

        honeySyrup = new HoneySyrup();
    }

    @Test
    public void marcoMaxFpTest(){
        int fpMarco = marco.getFp();
        marco.addItems(honeySyrup);
        marco.useHoneySyrup(); //Marco ya está en su máximo de su fp
        int noRestriction = fpMarco + 3; //Si no hubiera tope máximo de fp
        int fpResult = marco.getFp();

        assertNotEquals(noRestriction, fpResult);
        assertEquals(fpMarco, fpResult);
    }

    @Test
    public void marcoMinFpTest(){
        marco.saltoAttack(goomba);
        marco.saltoAttack(goomba);
        int noRestriction = 1 - 2;
        int fpExpected = marco.getFpMin(); // fp minimo  = 0
        int fpResult = marco.getFp();

        assertNotEquals(noRestriction, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void luisMaxFpTest(){
        int fpLuis = luis.getFp();
        luis.addItems(honeySyrup);
        luis.useHoneySyrup(); //Luis ya está en el maximo de su fp
        int noRestriction = fpLuis + 3;
        int fpResult = luis.getFp();

        assertNotEquals(noRestriction, fpResult);
        assertEquals(fpLuis, fpResult);
    }

    @Test
    public void luisMinHpTest(){
        luis.saltoAttack(goomba);
        luis.saltoAttack(goomba);
        int noRestriction = 1 - 2;
        int fpExpected = luis.getFpMin(); //fp minimo =  0
        int fpResult = luis.getFp();

        assertNotEquals(noRestriction, fpResult);
        assertEquals(fpExpected, fpResult);
    }
}
