package TestLvl;

import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIncreaseLvl {
    private Marco marco;
    private Luis luis;

    @BeforeEach
    public void setup(){
        marco = new Marco(10,5,5,20);
        luis = new Luis(5,6, 4, 20);
    }

    @Test
    public void marcoIncreaseLvl(){
        int lvlActual = marco.getLvl(); // por defecto lvl = 1
        assertEquals(1, lvlActual);

        marco.setHp(10); //hp actual = 10, hp max = 20
        marco.setFp(1); //fp actual = 1, fp max = 5
        marco.increaseLvl(); //aumenta sus estadisticas

        int atkExpected = (10 + (int)(15 * 10/100));
        int defExpected = (5 + (int)(15 * 5/100));
        int hpExpected = (10 + (int)(15 * 20/100));
        int fpExpected = (1 + (int)(15 * 5/100));
        int lvlExpected = 2;

        int atkResult = marco.getAtk();
        int defResult = marco.getDef();
        int hpResult = marco.getHp();
        int fpResult = marco.getFp();
        int lvlResult = marco.getLvl();

        assertEquals(atkExpected, atkResult);
        assertEquals(defExpected, defResult);
        assertEquals(hpExpected, hpResult);
        assertEquals(fpExpected, fpResult);
        assertEquals(lvlExpected, lvlResult);
    }

    @Test
    public void luisIncreaseLvl(){
        int lvlActual = luis.getLvl(); // por defecto lvl = 1
        assertEquals(1, lvlActual);

        luis.setHp(15); //hp actual = 15, hp max = 20
        luis.setFp(2); //fp actual = 2, fp max = 4
        luis.increaseLvl(); //aumenta sus estadisticas

        int atkExpected = (5 + (int)(15 * 5/100));
        int defExpected = (6 + (int)(15 * 6/100));
        int hpExpected = (15 + (int)(15 * 20/100));
        int fpExpected = (2 + (int)(15 * 4/100));
        int lvlExpected = 2;

        int atkResult = luis.getAtk();
        int defResult = luis.getDef();
        int hpResult = luis.getHp();
        int fpResult = luis.getFp();
        int lvlResult = luis.getLvl();

        assertEquals(atkExpected, atkResult);
        assertEquals(defExpected, defResult);
        assertEquals(hpExpected, hpResult);
        assertEquals(fpExpected, fpResult);
        assertEquals(lvlExpected, lvlResult);
    }
}
