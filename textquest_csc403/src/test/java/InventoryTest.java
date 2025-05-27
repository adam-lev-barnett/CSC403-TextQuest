import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;


public class InventoryTest {

    @Test
    public void addAndRemoveTest() {
        Inventory inventory1 = new Inventory(); // Error and empty test inventory
        Inventory inventory2 = new Inventory(); // Inventory with one item
        
        //& Populate test inventories
        inventory2.addItem(ItemCatalog.duckBill);

        //! No null items, items not in item catalog, or duplicate items
        assertThrows(NullPointerException.class, () -> inventory1.addItem(null));
        assertThrows(IllegalArgumentException.class, () -> inventory1.addItem(new Item("test", "test", "test")));
        assertThrows(IllegalArgumentException.class, () -> inventory2.addItem(ItemCatalog.duckBill));

        //^ Size, contains, and empty
        assertTrue(inventory1.isEmpty());
        assertFalse(inventory2.isEmpty());

        assertTrue(inventory2.size() == 1); // Test size after exception thrown for duplicate item
        assertFalse(inventory2.size() == 2); // Test size after exception thrown for duplicate item

        assertEquals(inventory2.printItemNicknames(), "[" + ItemCatalog.duckBill.getNickName() + "]");
        

    }
}
