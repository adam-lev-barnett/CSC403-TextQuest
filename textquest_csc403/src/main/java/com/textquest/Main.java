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
        
        //^ Game script: Opening
        Player player = PlayerCreation.createPlayer();

        Words.talk("Anyway, welcome " + player.getName() + ".");
        Words.talk("Today, we're going on a little adventure.");
        Words.talk("Are you ready?");
        Words.talk("Buckle in!");

        player.setRoom(GameMap.entrance);
        //& Characters in room: Duckhead
        Words.talk("Where once was fun but now is a sprawl of decaying wooden ticket stalls and rusty turnstiles. A crowd of ghosts gathers around a mysterious cotton candy cart. Floating heads of mascots past wistfully bob to a discordant calliope with bloodstained mouths. From the lineup, a duck head with bloodshot eyes spots you, pauses, and slowly turns around.");
        duckHead.speak("I'm not a real duck. Are you?");

        Interpreter interpreter = new Interpreter(player);
        interpreter.getAction();
    }
}