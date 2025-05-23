package com.textquest.Inventory_and_Items;
import com.textquest.Characters.*;
import com.textquest.InputOutput.InputScanner;
import com.textquest.Utilities.Words;
import com.textquest.Main;

public class PuzzleList {

    //! Was originally going to give the characters PuzzleDQs and pop both DQs at the same time to compare values, but then I'd have to repopulate the comparison DQs
    //& Puzzles pop items one at a time so they don't have to iterate through everything if the puzzle is incorrect before the end
    // public PuzzleDQ duckQ = new PuzzleDQ(ItemCatalog.stringFromCandy, ItemCatalog.duckBill, ItemCatalog.duckCall);
    //! How to return items to player???
    //! "you haven't added anything yet" - done when items in dq
    //! Can continue to add the same item after submission, but it doesn't accumulate in the dq

    public static String duckPuzzle(PuzzleDQ submission, Player player) { //~ Main creates different conditionals based on the String scenarios returned from the puzzle (returning items to inventory, resetting the puzzle queue, success, etc.)
        
        //! Null checks
        if (submission == null) throw new NullPointerException("Puzzle cannot be null");
        if (player == null) throw new NullPointerException("Player cannot be null");
        
        
        if (submission.getSize() < 3) {
            CharacterList.duckHead.speak("QUACK! I am looking for three very specific items. This isn't - QUACK - even three non-specific items.");
            CharacterList.duckHead.speak("Come back when it's worth my time. QUACK!");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.pop());
            }
            return "too small";
        }

        if (submission.getSize() > 3) {
            CharacterList.duckHead.speak("QUACK! I am looking for three very specific items... so this is too many items! QUACK! I don't get paid enough for this.");
            CharacterList.duckHead.speak("Come back when it's worth my time. QUACK!");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.pop());
            }
            return "too large";
        }

        Item item1 = submission.poll(); // Standard queue operation to remove and return head of queue (first item added to room's puzzleDQ)

        //^ Correct first item
        if (item1.equals(ItemCatalog.stringFromCandy)) CharacterList.duckHead.speak("Ew... Food garbage? What are you - QUACK - gonna do with that?");
        
        else if (item1.equals(ItemCatalog.duckBill)) {
            Words.narrate("Duckhead looks at you with contempt; his oversized, cartoon-ish eyes glare at you, unblinking and patronizing.");
            CharacterList.duckHead.speak("Very funny, kid. But you ain't passing for a - QUACK - duck if you can't keep that beak on your face.");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.pop());
            }
            player.getInventory().addItem(item1);
            return "bill first";
        }

        else if (item1.equals(ItemCatalog.duckCall)) {
            Words.narrate("Duckhead looks at you with contempt; his oversized, cartoon-ish eyes glare at you, unblinking and patronizing.");
            CharacterList.duckHead.speak("If you can't look the part, you shouldn't talk the talk."); 
            CharacterList.duckHead.speak("And if you shouldn't talk the talk, don't even try to walk the walk.");
            CharacterList.duckHead.speak("Because - well - QUACK - you've heard of a murder of crows, right? Ducks can murder too, especially when you don't belong...");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.pop());
            }
            player.getInventory().addItem(item1);
            return "call first";
        }

        else {
            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            player.getInventory().addItem(submission.pop());
            player.getInventory().addItem(item1);
            return "idiot";
        }

        Item item2 = submission.poll();

        //^ Correct second item
        if (item2.equals(ItemCatalog.duckBill)) CharacterList.duckHead.speak("Oh, I see - QUACK - where you're going with this. You couldn't find string that hasn't been chewed on, though?"); 
        
        else if (item2.equals(ItemCatalog.duckCall)) {
            Words.narrate("Duckhead quacks at you, his ghostly saliva hitting you square on the forehead.");
            CharacterList.duckHead.speak("You're just going to hang that quacker around your neck? Just because you can talk the talk doesn't mean you can walk the walk.");
            player.getInventory().addItem(submission.pop());
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            return "call second";
        }

        else {
            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            player.getInventory().addItem(submission.pop());
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            return "idiot";
        }

        Item item3 = submission.poll();
        if (!item3.equals(ItemCatalog.duckCall)) {


            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.pop());
            }
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            player.getInventory().addItem(item3);
            return "idiot";
        }
        //~ Ignore input request for testing
            // String quack = InputScanner.strIn("Use your duck call and \"QUACK\" to continue.");
            // while (!quack.equals("QUACK")) {
            //     quack = InputScanner.strIn("\"QUACK\" like your unlife depends on it!");
            // }
        Words.narrate("Duckhead's mascot head begins to dissapate before your eyes... revealing...");
        Words.narrate("An actual, living duck. Not floating. Flying. Frantically flapping his mortal wings.");
        // CharacterList.duckHead.speak("QUACK! QUACK! Thank you " + Main.player + "."); 
        // CharacterList.duckHead.speak("QUACK! QUACK! Thank you " + Main.testPlayer + "."); 
        CharacterList.duckHead.speak("Our souls were bound to this plane, which does not befit a duck.");
        CharacterList.duckHead.speak("We can now flee this wretched place.");
        CharacterList.duckHead.speak("Before we do, let us open the gates to the rest of the park as thanks for your kindness.");

        Words.narrate("You see the other mascot heads dissolve, revealing ducks of all species. Their thankful quacks echoing throughout the park.");
        Words.narrate("They disperse and unlock the gates, allowing access to all areas of this hellish amusement park. What horrible secrets await?");
        Main.entranceGatesLocked = false;
        CharacterList.duckHead.speak("Fare thee - QUACK - well.");
        Words.narrate("The ducks fly free into the moonlight. If only you could do the same...");

        return "success";

    }
    
}
