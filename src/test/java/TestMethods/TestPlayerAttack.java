package TestMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayerAttack {
    //Creo los enemigos
    //Creo los personajes

    @BeforeEach
    public void setUp() {
        //Se inicializan los enemigos
        //Se inicializan los personajes
    }
    @Test
    public void marcoAttackGoombaTest(){
        //Que Marco ataque a goomba con salto (lo puede dañar)
        //Que Marco ataque a goomba con martillo (lo puede dañar)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void marcoAttackSpinyTest(){
        //Que Marco ataque a Spiny con con salto (no puede dañarlo, marco pierde vida)
        //Que Marco ataque a goomba con martillo (lo puede dañar)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void marcoAttackBooTest(){
        //Que Marco ataque a Boo con con salto (lo puede dañar)
        //Que Marco ataque a goomba con martillo (lo esqueva, no lo puede dañar)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void luisAttackGoombaTest(){
        //Que Luis ataque a goomba con salto (lo puede dañar)
        //Que Luis ataque a goomba con martillo (lo puede dañar)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void luisAttackSpinyTest(){
        //Que Luis ataque a Spiny con con salto (no puede dañarlo, luis pierde vida)
        //Que Luis ataque a goomba con martillo (lo puede dañar)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void luisAttackBooTest(){
        //Que Luis no pueda atacar a boo
    }

}
