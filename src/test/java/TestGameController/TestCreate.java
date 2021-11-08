package TestGameController;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Controller.GameController;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCreate {
    private GameController gameController;

    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;

    private Baul baul;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp(){
        gameController = new GameController();

        goomba = new Goomba(2,4,15);
        spiny = new Spiny(2,4,15);
        boo = new Boo(2,4,15);

        marco = new Marco(10,5,5,20);
        luis = new Luis(10,5, 5, 4);

        baul = new Baul();
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
    }

    @Test
    public void createMarcoTest(){
        Marco createMarco = gameController.createMarco(10,5,5,20);
        assertEquals(marco, createMarco);
    }

    @Test
    public void createLuisTest(){
        Luis createLuis = gameController.createLuis(10,5, 5, 4);
        assertEquals(luis, createLuis);
    }

    @Test
    public void createGoombaTest(){
        Goomba createGoomba = gameController.createGoomba(2,4,15);
        assertEquals(goomba, createGoomba);
    }

    @Test
    public void createSpinyTest(){
        Spiny createSpiny = gameController.createSpiny(2,4,15);
        assertEquals(spiny, createSpiny);
    }

    @Test
    public void createBooTest(){
        Boo createBoo = gameController.createBoo(2,4,15);
        assertEquals(boo, createBoo);
    }

    @Test
    public void createRedMushroomTest(){
        RedMushroom createRedMushroom = gameController.createRedMushroom();
        assertEquals(redMushroom, createRedMushroom);
    }

    @Test
    public void createHoneySyrupTest(){
        HoneySyrup createHoneySyrup = gameController.createHoneySyrup();
        assertEquals(honeySyrup, createHoneySyrup);
    }

    @Test
    public void createBaulTest(){
        Baul createBaul = gameController.getBaul();
        assertEquals(baul, createBaul);
    }
}
