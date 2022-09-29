import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemsTests {
    Room room2 = new Room();
    @BeforeEach
    public void setUp(){
        room2 = new Room("Room 2", "room that has a lamp and hat, only one other door");
        room2.addItem("Lamp", "A old lamp hanging at the wall");

    }

    @Test
    public void takeTest(){
        Item lamp = room2.findItem("lamp", room2);
        assertNotNull(lamp);

        room2.takeItem("lamp", room2, new UserInterface());
        room2.takeItem("lamp", room2, new UserInterface());
        lamp = room2.findItem("lamp", room2);
        assertNull(lamp);

    }
}
