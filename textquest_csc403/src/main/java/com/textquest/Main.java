package com.textquest;

import com.textquest.Characters.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;

//! Add boolean solvedPuzzle so that the interpreter knows not to let you try the puzzle when there aren't items to use

public class Main {
    //^ Uncomment for testPlayer
    // public static Player player = new Player("Bill", "A big duck", 3, GameMap.entrance);

    //^ Create player from user input
    public static Player player = PlayerCreation.createPlayer();

    public static boolean entranceGatesLocked = true;
    public static GameCharacter duckHead = CharacterList.duckHead;

    public static void main(String[] args) {

        // ~~~~~ Game element initialization ~~~~~ //
        
        //^ Game script: Opening ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
        Words.narrate("Anyway, welcome " + player.getName() + ".");
        Words.narrate("Today, we're going on a little adventure.");
        Words.narrate("Buckle in!");

        Words.whoosh();

        //^ Chapter 1: The entrance
        //& Characters in room: Duckhead

        Words.narrate("Where once was found fun is now a sprawl of decaying wooden ticket stalls and rusty turnstiles."); 
        Words.narrate("A crowd of ghosts gathers around a mysterious cotton candy cart.");
        Words.narrate("The gift shop, while broken, looks lively - Everyone is dead, but capitalism is alive and well.");
        Words.narrate("Floating heads of mascots past wistfully bob to a discordant calliope with bloodstained mouths.");
        Words.narrate("From the lineup, a duck head with bloodshot eyes spots you, pauses, and slowly turns around.");

        //~ Comment out the following Duckhead dialog for testing
        
        String duckQ = duckHead.speakResponse("I'm not a real duck. Are you?");
        while (!duckQ.equalsIgnoreCase("yes") && !duckQ.equalsIgnoreCase("no")) {
            duckQ = duckHead.speakResponse("*QUACK* It's a \"yes\" or \"no\" question *QUACK*");
        }
        switch (duckQ.toLowerCase()) {
            case "yes":
                duckHead.speak("Nice *QUACK* try, but I see who you really are.");
                break;
            case "no":
                duckHead.speak("You're not *QUACK* going to make it much farther look- *QUACK* -ing like that.");
                break;
            default:
                duckHead.speak("...");
                break;
        }
        //~ End Duckhead dialog

        // Words.narrate("What will you do?");
        // System.out.println("• 'Talk to Duckhead'?");
        // System.out.println("• Solve the puzzle? ('solve puzzle')");
        // System.out.println("• Pick up an item in the room? ('pick up <item name>')");
        // System.out.println(  "    • Available room items:" + GameMap.entrance.getRoomItems());
        // System.out.println("• 'Give up'?");
        // System.out.println("");
        
        // In-game input testing for getter methods
        // Words.narrate("At any time, you can also enter: ");
        // System.out.println("• 'Description' - Prints your character's description"); //& Player description changes when you put on your duck shirt! 
        // System.out.println("• 'Name' - Prints your character's name");
        // System.out.println("• 'DuckheadInventory' - Prints Duckhead's inventory");
        // System.out.println("• 'RoomInventory' - Prints room inventory");

        // Words.printValidActions();

        // Interpreter interpreter = new Interpreter(player);
        Interpreter interpreter = new Interpreter(player);
        interpreter.getAction();
    }
}