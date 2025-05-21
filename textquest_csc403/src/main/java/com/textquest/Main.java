package com.textquest;

import com.textquest.Characters.*;
import com.textquest.Rooms.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;

import edu.princeton.cs.algs4.*;;

//~ Character creation 
//~ 

public class Main {
    public static Player testPlayer = new Player("Bill", "A big duck", 3, GameMap.entrance);
    // public static Player player = PlayerCreation.createPlayer();
    public static boolean entranceGatesLocked = true;
    public static GameMap gameMap = new GameMap();

    public static void main(String[] args) {

        //^ Game element initialization
        ItemCatalog itemCatalog = new ItemCatalog();

        //~ Character creation 
        CharacterList charList = new CharacterList();

        GameCharacter duckHead = CharacterList.duckHead;

        itemCatalog.populateItems();

        
        //^ Game script: Player creation and opening
        // Words.narrate("Anyway, welcome " + player.getName() + ".");
        Words.narrate("Anyway, welcome " + testPlayer.getName() + ".");
        Words.narrate("Today, we're going on a little adventure.");
        Words.narrate("Are you ready?");
        Words.narrate("Buckle in!");

        // player.setRoom(GameMap.entrance);
        testPlayer.setRoom(GameMap.entrance);


        //^ Chapter 1: The entrance
        //& Characters in room: Duckhead

        Words.narrate("Where once was found fun is now a sprawl of decaying wooden ticket stalls and rusty turnstiles."); 
        Words.narrate("A crowd of ghosts gathers around a mysterious cotton candy cart.");
        Words.narrate("The gift shop, while broken, looks lively - Everyone is dead, but capitalism is alive and well.");
        Words.narrate("Floating heads of mascots past wistfully bob to a discordant calliope with bloodstained mouths.");
        Words.narrate("From the lineup, a duck head with bloodshot eyes spots you, pauses, and slowly turns around.");

        //~ Comment out duck dialog for expedited testing
        /* 
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
        */

        Words.narrate("What will you do?");
        Words.narrate("• Explore the 'cotton candy cart'?'");
        Words.narrate("• 'Punch Duckhead?'");
        Words.narrate("• Search the 'ticket stalls'?");
        Words.narrate("• Check out the 'gift shop'?");
        Words.narrate("• Solve the puzzle? ('solve puzzle')");
        Words.narrate("•'Give up'?");

        // Interpreter interpreter = new Interpreter(player);
        Interpreter interpreter = new Interpreter(testPlayer);
        interpreter.getAction();
    }
}