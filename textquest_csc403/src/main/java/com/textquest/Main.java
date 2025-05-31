package com.textquest;

import com.textquest.Characters.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;

public class Main {
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~ test player test
    //~ Uncomment for testPlayer 
    // public static Player player = new Player("Bill", "A big duck", GameMap.entrance);

    //~ Create player from user input - comment out for testing!
    public static Player player = PlayerCreation.createPlayer();
    public static boolean entranceGatesLocked = true;
    public static GameCharacter duckHead = CharacterList.duckHead;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {

        //Game element initialization//
        
        //Game script: Opening
        Words.narrate("Anyway, welcome " + player.getName() + ".");
        Words.narrate("Today, we're going on a little adventure.");
        Words.narrate("Buckle in!");

        Words.whoosh();

        // Chapter 1: The entrance
        //& Characters in room: Duckhead

        Words.narrate("Where once was found fun is now a sprawl of decaying wooden ticket stalls and rusty turnstiles."); 
        Words.narrate("A crowd of ghosts gathers around a mysterious cotton candy cart.");
        Words.narrate("The gift shop, while broken, looks lively - Everyone is dead, but capitalism is alive and well.");
        Words.narrate("Floating heads of mascots past wistfully bob to a discordant calliope with bloodstained mouths.");
        Words.narrate("From the lineup, a duck head with bloodshot eyes spots you, pauses, and slowly turns around.");

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~ duckhead dialog test
        //~ Comment out the following Duckhead dialog for testing due to user input - nothing to uncomment for testing
        
        String duckQ = duckHead.speakResponse("I'm not a real duck. Are you?");
        while (!duckQ.equalsIgnoreCase("yes") && !duckQ.equalsIgnoreCase("no")) {
            duckQ = duckHead.speakResponse("*QUACK* It's a \"yes\" or \"no\" question *QUACK*");
        }
        switch (duckQ.toLowerCase()) {
            case "yes":
                duckHead.speak("Nice *QUACK* try, but I see who you really are: " + player.getDesc());
                break;
            case "no":
                duckHead.speak("You're not *QUACK* going to make it much farther look- *QUACK* -ing like that: " + player.getDesc());
                break;
            default:
                duckHead.speak("...");
                break;
        }

        //~ End Duckhead dialog
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        Interpreter interpreter = new Interpreter(player);
        interpreter.getAction();
    }
}