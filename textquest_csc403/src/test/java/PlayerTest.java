import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Rooms.GameMap;

public class PlayerTest {
    
    Player testPlayer = new Player("name", "desc", GameMap.entrance);

    @Test
    public void testPlayerConstructor() {
        
        //! No players with null fields
        assertThrows(NullPointerException.class, () -> new Player("test", "test", null));
        assertThrows(NullPointerException.class, () -> new Player(null, "test", GameMap.entrance));
        assertThrows(NullPointerException.class, () -> new Player("test", null, GameMap.entrance));


        assertEquals("name", testPlayer.getName());
        assertEquals("desc", testPlayer.getDesc());
        assertEquals(GameMap.entrance, testPlayer.getRoom());
    }

    @Test
    public void testPlayerInventory() {
        testPlayer.addToInventory(ItemCatalog.duckBill);
    }


}
