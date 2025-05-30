import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;

public class ItemTest {

    @Test
    public void testEquals() {
        Item testItem1 = new Item("test1", "testDesc", "testNickname");
        Item testItem2 = new Item("test1", "testDesc", "testNickname");
        Item testItem3 = new Item("DiffItem", "test", "testtest");

        assertEquals(testItem1, testItem2);
        assertNotEquals(testItem2, testItem3);
        assertEquals(testItem1.hashCode(), testItem2.hashCode());
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
