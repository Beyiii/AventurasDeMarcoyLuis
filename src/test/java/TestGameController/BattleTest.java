package TestGameController;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Controller.GameController;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.ICharacter;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.ItemsType;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.AttackType;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import static org.junit.jupiter.api.Assertions.*;

import com.example.aventurasdemarcoyluis.Turnos.Turnos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BattleTest {
    private GameController gameController;

    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    private Marco marco;
    private Luis luis;

    private Turnos turnos;

    private Baul baul;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    private int setSeed = 1014646950; //para que no falle el ataque con martillo

    @BeforeEach
    public void setUp(){
        gameController = new GameController();

        marco = gameController.createMarco(100,8,5,100);
        luis = gameController.createLuis(100,14,7,100);

        goomba = gameController.createGoomba(8,5,10);
        spiny = gameController.createSpiny(16,10,11);
        boo = gameController.createBoo(13,10,10);

        honeySyrup = new HoneySyrup();

        marco.setSeed(setSeed);
        luis.setSeed(setSeed);

        gameController.additemBaul(honeySyrup);

        baul = gameController.getBaul();
        turnos = gameController.getTurnos();
    }

    @Test
    public void BattleTest(){
        assertEquals(marco, gameController.actualTurn());
        assertTrue(turnos.contain(goomba));

        gameController.attackTurnPlayer(marco,goomba, AttackType.SALTO); // Se realiza el ataque y pasa al siguiente turno.

        assertTrue(goomba.KO());
        assertFalse(turnos.contain(goomba)); //Se elimino goomba de los turnos pues está KO

        assertEquals(luis, gameController.actualTurn());
        assertTrue(turnos.contain(spiny));

        gameController.attackTurnPlayer(luis,spiny,AttackType.MARTILLO); // Se realiza el ataque y pasa al siguiente turno.

        assertTrue(spiny.KO());
        assertFalse(turnos.contain(spiny)); //Se elimino spiny pues está KO

        assertEquals(boo, gameController.actualTurn()); //lo otros 2 enemigos fueron eliminados
        assertTrue(turnos.contain(marco));

        gameController.attackTurnEnemy(boo,marco);

        assertFalse(marco.KO()); //el ataque de boo no es muy poderoso.
        assertTrue(turnos.contain(marco));

        assertEquals(marco, gameController.actualTurn());
        assertTrue(baul.containHoneySyrup());

        gameController.itemTurn(marco, ItemsType.HONEYSYRUP);
        assertFalse(baul.containHoneySyrup());

        assertEquals(luis, gameController.actualTurn());

        gameController.passTurn(); //luis ocupó su turno para pasar

        assertFalse(gameController.isPlayersWin()); //false, aun no termina la batalla

        assertEquals(boo, gameController.actualTurn());
        assertTrue(turnos.contain(marco));

        gameController.attackTurnEnemy(boo,marco);

        assertFalse(marco.KO()); //el ataque de boo no es muy poderoso.
        assertTrue(turnos.contain(marco));

        assertEquals(marco, gameController.actualTurn());
        assertFalse(boo.KO());

        gameController.attackTurnPlayer(marco,boo,AttackType.SALTO);

        assertTrue(boo.KO());
        assertFalse(turnos.contain(boo));

        assertTrue(gameController.isPlayersWin()); //true, todos los enemigos fueron derrotados
    }
}
