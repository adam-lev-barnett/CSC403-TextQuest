import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



import org.junit.jupiter.api.Test;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Rooms.GameMap;

public class PlayerTest {
    
    Player testPlayer = new Player("name", "desc", GameMap.entrance);

    @Test
    public void playerConstructorTest() {
        
        //! No players with null fields
        assertThrows(NullPointerException.class, () -> new Player("test", "test", null));
        assertThrows(NullPointerException.class, () -> new Player(null, "test", GameMap.entrance));
        assertThrows(NullPointerException.class, () -> new Player("test", null, GameMap.entrance));


        assertEquals("name", testPlayer.getName());
        assertEquals("desc", testPlayer.getDesc());
        assertEquals(GameMap.entrance, testPlayer.getRoom());
    }

    @Test
    public void playerInventoryTest() {
        testPlayer.addToInventory(ItemCatalog.duckBill);
        testPlayer.addToInventory(ItemCatalog.duckCall);
        testPlayer.addToInventory(ItemCatalog.duckShirt);

        assertTrue(testPlayer.getInventory().hasItem(ItemCatalog.duckBill.getNickName()));
        assertTrue(testPlayer.getInventory().hasItem(ItemCatalog.duckCall.getNickName()));
        assertTrue(testPlayer.getInventory().hasItem(ItemCatalog.duckShirt.getNickName()));

        testPlayer.removeFromInventory(ItemCatalog.duckCall.getNickName());
        assertFalse(testPlayer.getInventory().hasItem(ItemCatalog.duckCall.getNickName()));
    }

    @Test
    public void duckShirtTest() {

        assertFalse(testPlayer.duckShirtStatus());

        testPlayer.putOnDuckShirt();

        assertTrue(testPlayer.duckShirtStatus());
    }


}
