package TestMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEnemyAttack {
    //Creo los enemigos
    //Creo los personajes

    @BeforeEach
    public void setUp() {
        //Se inicializan los enemigos
        //Se inicializan los personajes
    }
    @Test
    public void goombaAttackMarcoTest(){
        //Que goomba ataque a marco (su ataque es normal)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void spinyAttackMarcoTest(){
        //Que spiny ataque a marco (su ataque es normal)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void booAttackMarcoTest(){
        //Que boo no pueda atacar a marco (boo solo ataca a luis)
    }

    @Test
    public void goombaAttackLuisTest(){
        //Que goomba ataque a Luis (su ataque es normal)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void spinyAttackLuisTest(){
        //Que spiny ataque a Luis (su ataque es normal)
        //Que el daño sea igual al indicado en la formula del enunciado
    }

    @Test
    public void booAttackLuisTest(){
        //Que boo ataque a Luis (Boo solo ataca luis)
        //Que el daño sea igual al indicado en la formula del enunciado
    }
}
