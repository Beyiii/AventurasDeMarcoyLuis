package TestConstructor;

import com.example.aventurasdemarcoyluis.Enemy.*;
import com.example.aventurasdemarcoyluis.Enemy.Goomba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestEnemy {
    private Goomba goomba;
    private Spiny spiny;
    private Boo boo;

    @BeforeEach
    public void setUp() {
        goomba = new Goomba(2,4,15,8);
        spiny = new Spiny(3,10,15,8);
        boo = new Boo(8,3,5,5);
    }

    /**
     * Test para asegurarse que sean del tipo correspondiente
     */

    @Test
    public void typeTest(){
        assertEquals(EnemyType.GOOMBA, goomba.getType());
        assertEquals(EnemyType.SPINY, spiny.getType());
        assertEquals(EnemyType.BOO, boo.getType());
    }

    /** Mas test para el constructor que no se me ocurren en este momento (Buscar en internet)*/

    /** Buscar test para mostrar la protección de algunas variables uwu */

    /** REVIASAR EJEMPLO MONEY PARA COPIAR ALGUNOS TESTS AQUÍ */
}
