package TestBaul;

import com.example.aventurasdemarcoyluis.Baul.Baul;
import com.example.aventurasdemarcoyluis.Items.HoneySyrup;
import com.example.aventurasdemarcoyluis.Items.RedMushroom;
import com.example.aventurasdemarcoyluis.Player.Luis;
import com.example.aventurasdemarcoyluis.Player.Marco;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBaul {
    private Marco marco;
    private Luis luis;

    private Baul baul;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;

    @BeforeEach
    public void setUp(){
        marco = new Marco(10,5,5,16);
        luis = new Luis(15,6, 4, 18);

        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
        baul = new Baul();
    }

    @Test
    public void addItemTest(){
        boolean actualRedMushroom = baul.containRedMushrooms(); // false, pues aun no se agregan items
        boolean actualHoneySyrup = baul.containHoneySyrup();// false, pues aun no se agregan items

        assertFalse(actualRedMushroom);
        assertFalse(actualHoneySyrup);

        baul.addItem(redMushroom);
        baul.addItem(honeySyrup);

        boolean redMushroomResult = baul.containRedMushrooms();
        boolean honeySyrupResult = baul.containHoneySyrup();

        assertTrue(redMushroomResult);
        assertTrue(honeySyrupResult);
    }

    @Test
    public void useItemsTest(){
        baul.addItem(redMushroom);
        baul.addItem(honeySyrup);

        assertTrue(baul.containRedMushrooms()); //true porque agregue items
        assertTrue(baul.containHoneySyrup());

        marco.useRedMushroom(baul);
        luis.useHoneySyrup(baul);

        assertFalse(baul.containRedMushrooms()); //false porque se usaron
        assertFalse(baul.containHoneySyrup());

    }


}
