import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;

public class ItemTest {

    @Test
    public void testEquals() {
        // New items
        Item testItem1 = new Item("test1", "testDesc", "testNickname");
        Item testItem2 = new Item("test1", "testDesc", "testNickname");
        Item testItem3 = new Item("DiffItem", "test", "testtest");

        // Comparing ItemCatalog items
        Item duckShirtTest = new Item("duck shirt", "DUck Shirt", "A shirt that reads \"I ♥ \uD83E\uDD86s\" For die-hard duck fans. Not a duck? You can still support ducks!");
        Item stringFromCandyTest = new Item("candy string", "Candy String", "Ah, to be young again and willing to eat your own jewelry. But you're dead! Besides, someone already ate this. At least they left the string.");

        assertEquals(testItem1, testItem2);
        assertNotEquals(testItem2, testItem3);
        assertEquals(testItem1.hashCode(), testItem2.hashCode());
        assertEquals(ItemCatalog.duckShirt, duckShirtTest);
        assertEquals(ItemCatalog.stringFromCandy, stringFromCandyTest);
    }

    @Test
    public void testNulls() {
        assertThrows(NullPointerException.class, () -> new Item(null, "testNull", "testNull"));
        assertThrows(NullPointerException.class, () -> new Item("testNull", null, "testNull"));
        assertThrows(NullPointerException.class, () -> new Item("testNull", "test", null));
        assertThrows(NullPointerException.class, () -> new Item("testNull", null, null));
        assertThrows(NullPointerException.class, () -> new Item(null, "test", null));
        assertThrows(NullPointerException.class, () -> new Item(null, null, "test"));
        assertThrows(NullPointerException.class, () -> new Item(null, null, null));
    }

}
