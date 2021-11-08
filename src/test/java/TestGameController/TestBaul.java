package TestGameController;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Controller.GameController;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.ItemsType;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class TestBaul {
    private GameController gameController;

    private Marco marco;

    private Baul baul;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp(){
        gameController = new GameController();

        marco = gameController.createMarco(10,5,5,16);

        redMushroom = gameController.createRedMushroom();
        honeySyrup = gameController.createHoneySyrup();
        baul = gameController.getBaul();

    }

    @Test
    public void addItemsTest(){
        assertFalse(baul.containHoneySyrup());
        assertFalse(baul.containRedMushrooms());

        gameController.additemBaul(redMushroom);
        gameController.additemBaul(honeySyrup);

        assertTrue(baul.containRedMushrooms());
        assertTrue(baul.containHoneySyrup());
    }

    @Test
    public void emptyBaulRedMushroomTest(){
        marco.setHp(10); //hp actual = 10, hp max= 16

        int hp = marco.getHp();//10
        gameController.itemTurn(marco, ItemsType.REDMUSHROOM); //No hay items en el baul

        int hpExpected = hp + (int)(10*16/100); //11
        int hpResult = marco.getHp(); //10

        assertEquals(hp, hpResult);
        assertNotEquals(hpExpected, hpResult);
    }

    @Test
    public void emptyBaulHoneySyruoTest(){
        marco.setFp(1); //fp actual = 1, fp max = 5

        int fp = marco.getFp(); //1
        gameController.itemTurn(marco, ItemsType.HONEYSYRUP); //No hay items en el baul

        int fpExpected = fp + 3; //5
        int fpResult = marco.getFp(); //1

        assertEquals(fp, fpResult);
        assertNotEquals(fpExpected, fpResult);
    }


    @Test
    public void useRedMushroomTest(){
        gameController.additemBaul(redMushroom);

        marco.setHp(10); //hp actual = 10, hp max= 16

        int hp = marco.getHp();
        gameController.itemTurn(marco, ItemsType.REDMUSHROOM);

        int hpExpected = hp + (int)(10*16/100);
        int hpResult = marco.getHp();

        assertNotEquals(hp, hpResult);
        assertEquals(hpExpected, hpResult);
    }

    @Test
    public void useHoneySyrupTest(){
        gameController.additemBaul(honeySyrup);

        marco.setFp(1); //fp actual = 1, fp max = 5

        int fp = marco.getFp();
        gameController.itemTurn(marco, ItemsType.HONEYSYRUP);

        int fpExpected = fp + 3;
        int fpResult = marco.getFp();

        assertNotEquals(fp, fpResult);
        assertEquals(fpExpected, fpResult);
    }

    @Test
    public void getItemsBaulTest(){
        gameController.additemBaul(redMushroom);
        gameController.additemBaul(honeySyrup);

        Hashtable expected = new Hashtable();
        expected.put(ItemsType.REDMUSHROOM, new RedMushroom());
        expected.put(ItemsType.HONEYSYRUP, new HoneySyrup());

        Hashtable result = gameController.getItemsBaul();

        assertEquals(expected,result);
    }

    @Test
    public void getNumberOfItemsBaulTest(){
        gameController.additemBaul(redMushroom);
        gameController.additemBaul(honeySyrup);

        Hashtable expected = new Hashtable();
        expected.put(ItemsType.REDMUSHROOM, 1);
        expected.put(ItemsType.HONEYSYRUP, 1);

        Hashtable result = gameController.getNumberOfItemsBaul();

        assertEquals(expected, result);
    }
}
