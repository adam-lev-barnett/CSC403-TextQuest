package com.textquest;

import com.textquest.Characters.*;
import com.textquest.Rooms.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.Words;

public class Main {

    public static void main(String[] args) {

        //^ Game element initialization
        ItemCatalog itemCatalog = new ItemCatalog();
        itemCatalog.populateItems();
        CharacterList charList = new CharacterList();
        GameCharacter duckHead = charList.duckHead();
        
        //^ Game script: Player creation and opening
        /* Player player = PlayerCreation.createPlayer();

        Words.narrate("Anyway, welcome " + player.getName() + ".");
        Words.narrate("Today, we're going on a little adventure.");
        Words.narrate("Are you ready?");
        Words.narrate("Buckle in!");

        player.setRoom(GameMap.entrance); */

        //^ Chapter 1: The entrance
        //& Characters in room: Duckhead

        Words.narrate("Where once was found fun is now a sprawl of decaying wooden ticket stalls and rusty turnstiles."); 
        Words.narrate("A crowd of ghosts gathers around a mysterious cotton candy cart.");
        Words.narrate("Floating heads of mascots past wistfully bob to a discordant calliope with bloodstained mouths.");
        Words.narrate("From the lineup, a duck head with bloodshot eyes spots you, pauses, and slowly turns around.");
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
        Words.narrate("What will you do?");
        Words.narrate("• Explore the 'cotton candy cart'?'");
        Words.narrate("• 'Punch Duckhead?'");
        Words.narrate("• Search the 'ticket stalls'?");
        Words.narrate("• Check out the 'gift shop'?");
        Words.narrate("")


        //! Interpreter interpreter = new Interpreter(player);
        //! interpreter.getAction();
    }
}