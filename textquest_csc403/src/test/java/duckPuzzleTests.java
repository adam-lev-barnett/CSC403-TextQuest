import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.GameMap;

import java.lang.NullPointerException;

//^ Duck puzzle tests complete

public class duckPuzzleTests {
    
    @Test
    public void testDuckPuzzle() {

        //! Inventory doesn't allow null items, or items not from ItemCatalog (see InventoryTest)

        Player testPlayer = new Player("TestPlayer", "test player", GameMap.entrance);
        Player nullPlayer = null;

        PuzzleDeque testQ1 = new PuzzleDeque(); // correct dq
        PuzzleDeque testQ2 = new PuzzleDeque(); // size 0 dq
        PuzzleDeque testQ3 = new PuzzleDeque(); // Too big
        PuzzleDeque testQ4 = new PuzzleDeque(); // incomplete dq
        PuzzleDeque testNull = null; //null puzzle check
        // PuzzleDQ testQ5 = new PuzzleDQ(); //! puzzle with items not from itemList - Inventory prevents this from happening; see InventoryTest
        PuzzleDeque testQ6 = new PuzzleDeque(); // dq of existing items but incorrect items
        PuzzleDeque testQ7 = new PuzzleDeque(); // Correct items, wrong order, bill first
        PuzzleDeque testQ8 = new PuzzleDeque(); // Correct items, wrong order, call first
        PuzzleDeque testQ9 = new PuzzleDeque(); // Incorrect second item
        PuzzleDeque testQ10 = new PuzzleDeque(); // Incorrect second item, random item
        PuzzleDeque testQ11 = new PuzzleDeque(); // First two items correct, last item incorrect

        testQ1.add(ItemCatalog.stringFromCandy);
        testQ1.add(ItemCatalog.duckBill);
        testQ1.add(ItemCatalog.duckCall);


        testQ3.add(ItemCatalog.stringFromCandy);
        testQ3.add(ItemCatalog.cottonCandyBlessed);
        testQ3.add(ItemCatalog.cottonCandyEternal);
        testQ3.add(ItemCatalog.cottonCandyPoison);
        testQ3.add(ItemCatalog.duckBill);
        testQ3.add(ItemCatalog.duckCall);
        testQ3.add(ItemCatalog.duckShirt);

        testQ4.add(ItemCatalog.duckCall);

        // testQ5.add(new Item("Test item nickname","Test name", "nothing"));

        testQ6.add(ItemCatalog.cottonCandyPoison);
        testQ6.add(ItemCatalog.cottonCandyEternal);
        testQ6.add(ItemCatalog.cottonCandyBlessed);

        testQ7.add(ItemCatalog.duckBill);
        testQ7.add(ItemCatalog.stringFromCandy);
        testQ7.add(ItemCatalog.duckCall);
        
        testQ8.add(ItemCatalog.duckCall);
        testQ8.add(ItemCatalog.stringFromCandy);
        testQ8.add(ItemCatalog.duckBill);

        testQ9.add(ItemCatalog.stringFromCandy);
        testQ9.add(ItemCatalog.duckCall);
        testQ9.add(ItemCatalog.duckBill);
        
        testQ10.add(ItemCatalog.stringFromCandy);
        testQ10.add(ItemCatalog.cottonCandyBlessed);
        testQ10.add(ItemCatalog.duckBill);

        testQ11.add(ItemCatalog.stringFromCandy);
        testQ11.add(ItemCatalog.duckBill);
        testQ11.add(ItemCatalog.cottonCandyBlessed);


        String result1 = Puzzles.duckPuzzle(testQ1, testPlayer);
        String result2 = Puzzles.duckPuzzle(testQ2, testPlayer);
        String result3 = Puzzles.duckPuzzle(testQ3, testPlayer);
        String result4 = Puzzles.duckPuzzle(testQ4, testPlayer);
        // String result5 = PuzzleList.duckPuzzle(testQ5, testPlayer); //! Inventory test should throw illegal argument for adding item not in item catalog
        String result6 = Puzzles.duckPuzzle(testQ6, testPlayer);
        String result7 = Puzzles.duckPuzzle(testQ7, testPlayer);
        String result8 = Puzzles.duckPuzzle(testQ8, testPlayer);
        String result9 = Puzzles.duckPuzzle(testQ9, testPlayer);
        String result10 = Puzzles.duckPuzzle(testQ10, testPlayer);
        String result11 = Puzzles.duckPuzzle(testQ11, testPlayer);

        assertThrows(NullPointerException.class, () -> Puzzles.duckPuzzle(testNull, testPlayer)); //null 
        assertThrows(NullPointerException.class, () -> Puzzles.duckPuzzle(testQ1, nullPlayer)); // null player
        assertEquals("success", result1);
        assertEquals("too small", result2);
        assertEquals("too large", result3);
        assertEquals("too small", result4);
        // assertEquals("too small", result5);
        assertEquals("idiot", result6);
        assertEquals("bill first", result7);
        assertEquals("call first", result8);
        assertEquals("call second", result9);
        assertEquals("idiot", result10);
        assertEquals("idiot", result11);

    }

    public void testsComplete() {
        System.out.println("Tests complete");
    }


}
