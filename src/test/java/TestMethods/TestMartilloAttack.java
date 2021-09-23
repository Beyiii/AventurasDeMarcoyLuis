package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestMartilloAttack{
    private Goomba goomba;

    private Marco marco;
    private Luis luis;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);

        marco = new Marco(10,5,5,4,4);
        luis = new Luis(10,6, 4, 6,4);
    }

    @Test
    public void marcoMartilloAttack(){
        int c = -1;
        while(goomba.getHp() == 15){
            marco.martilloAttack(goomba);
            c += 1;
        }
        int hpExpected = 15 - (int)(1.5 * 10 * 4/4); // 0

        assertEquals(hpExpected, goomba.getHp());
        System.out.println("Cuantas veces el ataque falló antes de que acertara = " + c);
    }

    @Test
    public void luisMartilloAttack(){
        int c = -1;
        while(goomba.getHp() == 15){
            luis.martilloAttack(goomba);
            c += 1;
        }
        int hpExpected = 15 - (int)(1.5 * 10 * 4/4); // 0

        assertEquals(hpExpected, goomba.getHp());
        System.out.println("Cuantas veces el ataque falló antes de que acertara = " + c);
    }
}