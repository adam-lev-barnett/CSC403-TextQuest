import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.textquest.Characters.*;
import com.textquest.Rooms.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;
import java.lang.NullPointerException;

public class tests {
    
    @Test
    public void testDuckPuzzle() {
        PuzzleDQ testQ1 = new PuzzleDQ(); // correct dq
        PuzzleDQ testQ2 = new PuzzleDQ(); // size 0 dq
        PuzzleDQ testQ3 = new PuzzleDQ(); // huge puzzle dq
        PuzzleDQ testQ4 = new PuzzleDQ(); // incomplete dq
        PuzzleDQ testQ5 = new PuzzleDQ(); // dq of newly generated items
        PuzzleDQ testQ6 = new PuzzleDQ(); // dq of existing items but incorrect items
        PuzzleDQ testQ7 = new PuzzleDQ(); // Correct items, wrong order, bill first
        PuzzleDQ testQ8 = new PuzzleDQ(); // Correct items, wrong order, call first
        PuzzleDQ testQ9 = new PuzzleDQ(); // Incorrect second item

        testQ1.add(ItemCatalog.stringFromCandy);
        testQ1.add(ItemCatalog.duckBill);
        testQ1.add(ItemCatalog.duckCall);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.stringFromCandy);
        testQ4.add(ItemCatalog.duckBill);
        testQ5.add(new Item(null, null));
        testQ5.add(new Item("Test item", "nothing"));
        testQ6.add(ItemCatalog.cottonCandyPoison);
        testQ6.add(ItemCatalog.cottonCandyPoison);
        testQ6.add(ItemCatalog.cottonCandyPoison);
        testQ7.add(ItemCatalog.duckBill);
        testQ7.add(ItemCatalog.stringFromCandy);
        testQ7.add(ItemCatalog.duckCall);
        testQ8.add(ItemCatalog.duckCall);
        testQ8.add(ItemCatalog.stringFromCandy);
        testQ8.add(ItemCatalog.duckBill);

        String result1 = PuzzleList.duckPuzzle(testQ1);
        String result2 = PuzzleList.duckPuzzle(testQ2);
        String result3 = PuzzleList.duckPuzzle(testQ3);
        String result4 = PuzzleList.duckPuzzle(testQ4);
        String result5 = PuzzleList.duckPuzzle(testQ5);
        String result6 = PuzzleList.duckPuzzle(testQ6);
        String result7 = PuzzleList.duckPuzzle(testQ7);
        String result8 = PuzzleList.duckPuzzle(testQ8);

        assertThrows(NullPointerException.class, () -> PuzzleList.duckPuzzle(null));
        assertEquals("success", result1);
        assertEquals("too small", result2);
        assertEquals("too large", result3);
        assertEquals("too small", result4);
        assertEquals("too small", result5);
        assertEquals("idiot", result6);
        assertEquals("bill first", result7);
        assertEquals("call first", result8);
        // assertEquals("success", result1);






    }
    
    @Test
    public void playerConstructorTest() {
        
        assertThrows(NullPointerException.class, () -> new Player("", "", 0, null));
    }

    public void testsComplete() {
        System.out.println("Tests complete");
    }


}
