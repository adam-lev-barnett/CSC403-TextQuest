import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;

public class ItemTest {

    @Test
    public void testEquals() {
        Item testItem1 = new Item("test1", "testDesc", "testNickname");
        Item testItem2 = new Item("test1", "testDesc", "testNickname");

        assertEquals(testItem1, testItem2);
    }

}
