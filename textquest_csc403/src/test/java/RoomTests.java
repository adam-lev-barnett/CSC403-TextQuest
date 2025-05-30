import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Rooms.*;

public class RoomTests {
    Room testRoom1;
    Room testRoom2;
    Room testRoom3; // equality check
    
    @BeforeEach
    public void setUp() {
        testRoom1 = new Room("Test room 1", "Test desc 1");
        testRoom2 = new Room("Test room 2", "Test desc 2");
        testRoom3 = new Room("Test room 1", "Test desc 1");

        testRoom1.getRoomInventory().addItem(ItemCatalog.cottonCandyBlessed);
        testRoom1.getRoomInventory().addItem(ItemCatalog.cottonCandyEternal);
        testRoom1.getRoomInventory().addItem(ItemCatalog.cottonCandyPoison);

        // Rooms with same name and description should still be equal regardless of inventories
        testRoom3.getRoomInventory().addItem(ItemCatalog.duckShirt); 

        // Rooms with same PuzzleDeques should still be equal
        testRoom1.getPuzzle().add(ItemCatalog.cottonCandyBlessed);
        testRoom1.getPuzzle().add(ItemCatalog.cottonCandyEternal);
        testRoom1.getPuzzle().add(ItemCatalog.duckBill);
    }

    @Test
    public void noNullFieldsTest() {
        assertThrows(NullPointerException.class, () -> new Room(null, "not null"));
        assertThrows(NullPointerException.class, () -> new Room("not null", null));
        assertThrows(NullPointerException.class, () -> new Room(null, null));
    }

    @Test 
    public void equalsTest() {
        assertEquals(testRoom1, testRoom3);
        assertNotEquals(testRoom2, testRoom1);
        assertEquals(testRoom1.hashCode(), testRoom3.hashCode());
    }

}
