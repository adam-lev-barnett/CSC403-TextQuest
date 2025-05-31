package com.textquest.Inventory_and_Items;
import com.textquest.Characters.*;
import com.textquest.Utilities.Words;
// import com.textquest.Main;

public class Puzzles {

    // In future versions, more puzzles will be added to this class; functionality is similar to CharacterList and GameMap
    // See PuzzleDeque for overview of mechanics and interaction with inventories
    // Main creates different conditionals based on the String scenarios returned from the puzzle (returning items to inventory, resetting the puzzle queue, success, etc.)

    private Puzzles() {}

    public static String duckPuzzle(PuzzleDeque submission, Player player) { 
        
        if (submission == null || submission.contains(null)) throw new NullPointerException("Puzzle and/or contents cannot be null");
        if (player == null) throw new NullPointerException("Player cannot be null");
        
        
        if (submission.getSize() < 3) {
            CharacterList.duckHead.speak("QUACK! I am looking for three very specific items. This isn't - QUACK - even three non-specific items.");
            CharacterList.duckHead.speak("Come back when it's worth my time. QUACK!");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.poll());
            }
            System.out.println("All items have been returned to your inventory.");
            return "too small";
        }

        if (submission.getSize() > 3) {
            CharacterList.duckHead.speak("QUACK! I am looking for three very specific items... so this is too many items! QUACK! I don't get paid enough for this.");
            CharacterList.duckHead.speak("Come back when it's worth my time. QUACK!");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.poll());
            }
            System.out.println("All items have been returned to your inventory.");
            return "too large";
        }

        Item item1 = submission.poll(); // Standard queue operation to remove and return head of queue (first item added to room's puzzleDQ)
        Words.narrate("Duckhead removes the first item from the puzzle: " + item1);

        // Correct first item
        if (item1.equals(ItemCatalog.stringFromCandy)) {
            CharacterList.duckHead.speak("Ew... Food garbage? What are you - QUACK - gonna do with that? I guess I'll accept it to see where you're going with this.");
        }
        
        else if (item1.equals(ItemCatalog.duckBill)) {
            Words.narrate("Duckhead looks at you with contempt; his oversized, cartoon-ish eyes glare at you, unblinking and patronizing.");
            CharacterList.duckHead.speak("Very funny, kid. But you ain't passing for a - QUACK - duck if you can't find a way to keep that beak on your face.");
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.poll());
            }
            player.getInventory().addItem(item1);
            System.out.println("All items have been returned to your inventory.");
            return "bill first";
        }

        else if (item1.equals(ItemCatalog.duckCall)) {
            Words.narrate("Duckhead looks at you with contempt; his oversized, cartoon-ish eyes glare at you, unblinking and patronizing.");
            CharacterList.duckHead.speak("If you can't look the part, you shouldn't talk the talk."); 
            while (!(submission.isEmpty())) {
                player.getInventory().addItem(submission.poll());
            }
            player.getInventory().addItem(item1);
            System.out.println("All items have been returned to your inventory.");
            return "call first";
        }

        else {
            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            player.getInventory().addItem(submission.poll());
            player.getInventory().addItem(item1);
            System.out.println("All items have been returned to your inventory.");
            return "idiot";
        }

        Item item2 = submission.poll();
        Words.narrate("Duckhead removes the second item from the puzzle: " + item2.getNickName());

        // Correct second item
        if (item2.equals(ItemCatalog.duckBill)) {
            CharacterList.duckHead.speak("Oh, I see - QUACK - where you're going with this. You're going to use the string to keep the bill on your face.");
            CharacterList.duckHead.speak(" You couldn't tie that on with string that hasn't been chewed on, though...?"); 
        }
        
        else if (item2.equals(ItemCatalog.duckCall)) {
            Words.narrate("Duckhead quacks at you, his ghostly saliva hitting you square on the forehead.");
            CharacterList.duckHead.speak("You're just going to hang that quacker around your neck? Just because you can talk the talk doesn't mean you can walk the walk.");
            player.getInventory().addItem(submission.poll());
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            System.out.println("All items have been returned to your inventory.");
            return "call second";
        }

        else {
            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            player.getInventory().addItem(submission.poll());
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            System.out.println("All items have been returned to your inventory.");
            return "idiot";
        }

        Item item3 = submission.poll();
        Words.narrate("Duckhead removes the third item from the puzzle: " + item3.getNickName());
        if (!item3.equals(ItemCatalog.duckCall)) {
            Words.narrate("Duckhead looks at you in disbelief, as if he's thinking \"What an idiot.\"");
            CharacterList.duckHead.speak("You're a QUACK-ing idiot.");
            player.getInventory().addItem(item1);
            player.getInventory().addItem(item2);
            player.getInventory().addItem(item3);
            System.out.println("All items have been returned to your inventory.");
            return "idiot";
        }

        // Successful puzzle completion - items no longer in player inventory or puzzle deque
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~ puzzle success test
        //~ Ignore the following input request for testing to avoid hangup while testing
            // String quack = InputScanner.strIn("Use your duck call and \"QUACK\" to continue.");
            // while (!quack.equals("QUACK")) {
            //     quack = InputScanner.strIn("\"QUACK\" like your unlife depends on it!");
            // }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        Words.narrate("Duckhead's mascot head begins to dissapate before your eyes... revealing...");
        Words.narrate("An actual, living duck. Not floating. Flying. Frantically flapping his mortal wings.");
        // CharacterList.duckHead.speak("QUACK! QUACK! Thank you " + this.player + "."); 
        CharacterList.duckHead.speak("Our souls were bound to this plane, which does not befit a duck.");
        CharacterList.duckHead.speak("We can now flee this wretched place.");
        CharacterList.duckHead.speak("Before we do, let us open the gates to the rest of the park as thanks for your kindness.");

        Words.narrate("You see the other mascot heads dissolve, revealing ducks of all species. Their thankful quacks echoing throughout the park.");
        Words.narrate("They disperse and unlock the gates, allowing access to all areas of this hellish amusement park. What horrible secrets await?");
        // In case there are more rooms, the following bool allows the player to access them only after solving the puzzle
        // Main.entranceGatesLocked = false;
        CharacterList.duckHead.speak("Fare thee - QUACK - well.");
        Words.narrate("The ducks fly free into the moonlight. If only you could do the same...");

        // Confirms player solved puzzle - player no longer able to access room puzzle
        player.getRoom().solvePuzzle();

        return "success";

    }
    
}
