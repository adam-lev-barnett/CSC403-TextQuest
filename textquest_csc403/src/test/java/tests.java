import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.textquest.Characters.*;
import com.textquest.Rooms.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;

public class tests {

    @Test
    public void testDuckPuzzle() {
        PuzzleDQ testQ = new PuzzleDQ();
        testQ.add(ItemCatalog.stringFromCandy);
        testQ.add(ItemCatalog.duckBill);
        testQ.add(ItemCatalog.duckCall);
        String result = PuzzleList.duckPuzzle(testQ);
        assertEquals("success", result);
    }        


}
