package TestGameController;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Controller.GameController;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.ICharacter;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetTurnsTest {
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

        marco = gameController.createMarco(10,8,5,100);
        luis = gameController.createLuis(10,14,7,20);
        goomba = gameController.createGoomba(8,5,50);
        spiny = gameController.createSpiny(16,10,60);
        boo = gameController.createBoo(13,10,12);
    }

    @Test
    public void getTurnsTest(){
        List turnos = gameController.getAllTurnos();

        List expected = new ArrayList();

        expected.add(marco);
        expected.add(luis);
        expected.add(goomba);
        expected.add(spiny);
        expected.add(boo);

        List noExpected = new ArrayList();

        assertEquals(expected, turnos);
        assertNotEquals(noExpected, turnos);
    }

    @Test
    public void getActualTurnTest(){
        ICharacter actualTurn = gameController.actualTurn(); //Marco, pues aun no se pasa al sgte turno
        assertEquals(marco, actualTurn);

        gameController.finTurn(); //Pasa al siguiente turno.

        ICharacter actualTurn2= gameController.actualTurn(); //Luis, pues se pasó al sgte. turno
        assertEquals(luis, actualTurn2);

        gameController.finTurn(); //Pasa al siguiente turno.

        ICharacter actualTurn3= gameController.actualTurn(); //Goomba, pues se pasó al sgte. turno
        assertEquals(goomba, actualTurn3);

        gameController.finTurn(); //Pasa al siguiente turno.

        ICharacter actualTurn4= gameController.actualTurn(); //Spiny, pues se pasó al sgte. turno
        assertEquals(spiny, actualTurn2);

        gameController.finTurn(); //Pasa al siguiente turno.

        ICharacter actualTurn5= gameController.actualTurn(); //Boo, pues se pasó al sgte. turno
        assertEquals(boo, actualTurn2);

        gameController.finTurn(); //Pasa al siguiente turno.

        ICharacter actualTurn6= gameController.actualTurn(); //Marco, pues se pasó al sgte. turno
        assertEquals(marco, actualTurn2);
    }

    @Test
    public void getSgteTurnTest(){
        ICharacter sgteTurn = gameController.sgteTurn(); //Luis, el segundo que se añadió a la lista de turnos
        ICharacter actualTurn = gameController.actualTurn(); //Mario,el primero que se añadió a la lista de turnos

        assertEquals(marco, actualTurn);
        assertEquals(luis, sgteTurn);
    }
}

