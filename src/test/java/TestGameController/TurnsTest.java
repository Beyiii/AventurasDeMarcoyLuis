package TestGameController;

import com.example.aventurasdemarcoyluis.Controller.GameController;
import com.example.aventurasdemarcoyluis.Enemy.Boo;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import com.example.aventurasdemarcoyluis.Enemy.Spiny;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import com.example.aventurasdemarcoyluis.Turnos.Turnos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurnsTest {
    private GameController gameController;

    @BeforeEach
    public void setUp(){
        gameController = new GameController();
    }

    @Test
    public void implementTurns(){
        Marco marco = gameController.createMarco(10,8,5,100);
        Luis luis = gameController.createLuis(10,14,7,20);
        Goomba goomba = gameController.createGoomba(8,5,50);
        Spiny spiny = gameController.createSpiny(16,10,60);
        Boo boo = gameController.createBoo(13,10,12);

        Turnos turnos = gameController.getTurnos();

        assertEquals(turnos.getTurno(0), marco);
        assertEquals(turnos.getTurno(1), luis);
        assertEquals(turnos.getTurno(2), goomba);
        assertEquals(turnos.getTurno(3), spiny);
        assertEquals(turnos.getTurno(4), boo);
    }
}
