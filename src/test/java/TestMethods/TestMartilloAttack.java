package TestMethods;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMartilloAttack{
    private Goomba goomba;

    private Marco marco;
    private Luis luis;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);

        marco = new Marco(10,5,5,4,4);
        luis = new Luis(11,6, 4, 6,6);
    }

    @Test
    public void marcoMartilloAttack(){
        int c = 0;
        while(goomba.getHp() != 15){
            marco.martilloAttack(goomba);
            c += 1;
        }
        c =- 1;

        System.out.println("Cuantas veces Marco el ataque falló antes de que acertara = " + c);
    }

    @Test
    public void luisMartilloAttack(){
        int c = 0;
        while(goomba.getHp() != 15){
            luis.martilloAttack(goomba);
            c += 1;
        }
        c =- 1;

        System.out.println("Cuantas veces Luis el ataque falló antes de que acertara = " + c);
    }
}