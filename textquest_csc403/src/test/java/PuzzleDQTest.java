import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;

//TODO

public class PuzzleDQTest {

    PuzzleDeque testPuzzle1 = new PuzzleDeque();
    PuzzleDeque testPuzzle2 = new PuzzleDeque();
    Item duckBill = ItemCatalog.duckBill;
    Item duckCall = ItemCatalog.duckCall;
    Item duckShirt = ItemCatalog.duckShirt;
    Item cottonCandy1 = ItemCatalog.cottonCandyBlessed;
    Item cottonCandy2 = ItemCatalog.cottonCandyEternal;
    Item cottonCandy3 = ItemCatalog.cottonCandyPoison;

    @Test
    public void addTest() {
        testPuzzle1.add(null);
    }
}

