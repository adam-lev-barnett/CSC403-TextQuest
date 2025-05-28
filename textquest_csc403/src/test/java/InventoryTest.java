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
        Inventory inventory3 = new Inventory(); // Inventory with four items
        
        //& Populate test inventories
        inventory2.addItem(ItemCatalog.duckBill);
        inventory3.addItem(ItemCatalog.duckBill);
        inventory3.addItem(ItemCatalog.cottonCandyBlessed);
        inventory3.addItem(ItemCatalog.cottonCandyEternal);
        inventory3.addItem(ItemCatalog.cottonCandyPoison);

        //! No null items, items not in item catalog
        assertThrows(NullPointerException.class, () -> inventory1.addItem(null));
        assertThrows(IllegalArgumentException.class, () -> inventory1.addItem(new Item("test", "test", "test")));

        //^ hasItem and getItem
        assertTrue(inventory2.hasItem(ItemCatalog.duckBill.getNickName()));
        assertFalse(inventory2.hasItem(ItemCatalog.cottonCandyBlessed.getNickName()));
        assertEquals(inventory2.getItem(ItemCatalog.duckBill.getNickName()), ItemCatalog.duckBill);

        //^ Size, contains, and empty
        assertTrue(inventory1.getItems().isEmpty());
        assertFalse(inventory2.getItems().isEmpty());
        assertTrue(inventory2.getItems().size() == 1); // Test size after exception thrown for duplicate item
        assertFalse(inventory2.getItems().size() == 2); // Test size after exception thrown for duplicate item
        assertTrue(inventory3.getItems().size() == 4); 

        //& Remove items
        inventory3.removeItem(ItemCatalog.cottonCandyEternal.getNickName());
        inventory3.removeItem(ItemCatalog.cottonCandyPoison.getNickName());

        assertTrue(inventory3.getItems().size() == 2); 

        // Removing an item not in inventory doesn't alter inventory
        inventory3.removeItem(ItemCatalog.cottonCandyEternal.getNickName());
        assertTrue(inventory3.getItems().size() == 2); 

        //& Remove more items to test has, get, empty
        inventory3.removeItem(ItemCatalog.duckBill.getNickName());
        inventory3.removeItem(ItemCatalog.cottonCandyBlessed.getNickName());

        //^ hasItem and getItem continued
        assertFalse(inventory3.hasItem(ItemCatalog.cottonCandyBlessed.getNickName()));
        assertTrue(inventory3.isEmpty());


    }
}
