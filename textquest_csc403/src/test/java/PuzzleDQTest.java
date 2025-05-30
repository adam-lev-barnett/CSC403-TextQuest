import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.textquest.Inventory_and_Items.*;
import java.util.ArrayList;

//TODO

public class PuzzleDQTest {

    PuzzleDeque testPuzzle1;
    PuzzleDeque testPuzzle2;
    Item duckBill;
    Item duckCall;
    Item duckShirt;
    Item cottonCandy1;
    Item cottonCandy2;
    Item cottonCandy3;

    @BeforeEach
    public void setUpPuzzles() {
        testPuzzle1 = new PuzzleDeque();
        testPuzzle2 = new PuzzleDeque();
        duckBill = ItemCatalog.duckBill;
        duckCall = ItemCatalog.duckCall;
        duckShirt = ItemCatalog.duckShirt;
        cottonCandy1 = ItemCatalog.cottonCandyBlessed;
        cottonCandy2 = ItemCatalog.cottonCandyEternal;
        cottonCandy3 = ItemCatalog.cottonCandyPoison;
    }

    @Test
    public void addTest() {
        assertThrows(NullPointerException.class, () -> testPuzzle1.add(null));
        assertThrows(IllegalArgumentException.class, () -> testPuzzle1.add(new Item("test", "test", "test")));

        testPuzzle2.add(duckBill);
        testPuzzle2.add(cottonCandy1);
        testPuzzle2.add(duckCall);

        //^ Size tests
        assertEquals(0, testPuzzle1.getSize());
        assertEquals(3, testPuzzle2.getSize());

        //^ Contains check
        assertTrue(testPuzzle2.contains(duckBill));
        assertTrue(testPuzzle2.contains(cottonCandy1));
        assertTrue(testPuzzle2.contains(duckCall));
    }
    
    // Comparing item order for add and undo with ArrayLists because that's the most effective implementation when comparing item order with ArrayDeques
    @Test
    public void insertionRemovalOrderingTest() {
        ArrayList<Item> testOrder1 = new ArrayList<>(); 
        ArrayList<Item> testOrder2 = new ArrayList<>();
        ArrayList<Item> result1 = new ArrayList<>(); // compare order of removals with order of testOrder1
        ArrayList<Item> result2 = new ArrayList<>(); // compare order of removals with order of testOrder2

        testOrder1.add(duckCall);
        testOrder1.add(duckBill);
        testOrder1.add(cottonCandy3);
        testOrder1.add(cottonCandy2);
        testOrder1.add(cottonCandy1);

        testOrder2.add(duckBill);
        testOrder2.add(cottonCandy1);
        testOrder2.add(cottonCandy2);
        testOrder2.add(cottonCandy3);
        testOrder2.add(duckCall);

        testPuzzle1.add(duckCall);
        testPuzzle1.add(duckBill);
        testPuzzle1.add(cottonCandy3);
        testPuzzle1.add(cottonCandy2);
        testPuzzle1.add(cottonCandy1);

        testPuzzle2.add(duckBill);
        testPuzzle2.add(cottonCandy1);
        testPuzzle2.add(cottonCandy2);
        testPuzzle2.add(cottonCandy3);
        testPuzzle2.add(duckCall);

        result1.add(testPuzzle1.poll());
        result1.add(testPuzzle1.poll());
        result1.add(testPuzzle1.poll());
        result1.add(testPuzzle1.poll());
        result1.add(testPuzzle1.poll());

        result2.add(testPuzzle2.poll());
        result2.add(testPuzzle2.poll());
        result2.add(testPuzzle2.poll());
        result2.add(testPuzzle2.poll());
        result2.add(testPuzzle2.poll());

        assertEquals(result1, testOrder1);
        assertEquals(result2, testOrder2);
        assertNotEquals(result2, testOrder1);
        assertNotEquals(result1, testOrder2);
    }

    @Test
    public void undoTest() {
        ArrayList<Item> testOrder1 = new ArrayList<>(); 
        ArrayList<Item> testOrder2 = new ArrayList<>();
        ArrayList<Item> testOrderUndo1 = new ArrayList<>(); 
        ArrayList<Item> testOrderUndo2 = new ArrayList<>(); 
        
        testPuzzle1.add(duckCall);
        testPuzzle1.add(duckBill);
        testPuzzle1.add(cottonCandy3);
        testPuzzle1.add(cottonCandy2);
        testPuzzle1.add(cottonCandy1);

        testPuzzle2.add(duckBill);
        testPuzzle2.add(cottonCandy1);
        testPuzzle2.add(cottonCandy2);
        testPuzzle2.add(cottonCandy3);
        testPuzzle2.add(duckCall);

        testOrderUndo1.add(cottonCandy1);
        testOrderUndo1.add(cottonCandy2);
        testOrderUndo1.add(cottonCandy3);

        testOrderUndo2.add(duckCall);
        testOrderUndo2.add(cottonCandy3);
        testOrderUndo2.add(cottonCandy2);

        testOrder1.add(testPuzzle1.undo());
        testOrder1.add(testPuzzle1.undo());
        testOrder1.add(testPuzzle1.undo());

        testOrder2.add(testPuzzle2.undo());
        testOrder2.add(testPuzzle2.undo());
        testOrder2.add(testPuzzle2.undo());

        //Order of undo items - should be order of items "undid"
        assertEquals(testOrderUndo1, testOrder1);
        assertEquals(testOrderUndo2, testOrder2);

        //Doesn't contain anymore
        assertFalse(testPuzzle1.contains(cottonCandy1));
        assertFalse(testPuzzle1.contains(cottonCandy2));
        assertFalse(testPuzzle1.contains(cottonCandy3));

        assertFalse(testPuzzle2.contains(duckCall));
        assertFalse(testPuzzle2.contains(cottonCandy2));
        assertFalse(testPuzzle2.contains(cottonCandy3));

    }
}

