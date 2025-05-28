import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;

public class ItemCatalogTest {

    @Test
    public void noAddingToCatalogTest() {
        assertThrows(UnsupportedOperationException.class, () -> ItemCatalog.masterInventory.add(new Item("test", "test", "test")));
    }
}
