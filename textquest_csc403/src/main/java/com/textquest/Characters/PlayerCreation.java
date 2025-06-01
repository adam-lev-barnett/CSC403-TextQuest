package com.textquest.Characters;

import com.textquest.InputOutput.*;
import com.textquest.Rooms.GameMap;
import com.textquest.Utilities.*;

// Interactive player creation 
public class PlayerCreation {
    
    private PlayerCreation() {}

    public static Player CreatePlayer() {
        String playerName = InputScanner.strIn("What's your name?");
        OutputPause.pause(1000);
        System.out.println(playerName + "? What kind of name is that?");
        OutputPause.pause(1000);
        String playerDesc = InputScanner.strIn("Describe your character: ");
        OutputPause.pause(1000);
        System.out.println("I'm so sorry you look like that.");
        return new Player(playerName, playerDesc, GameMap.entrance);
    }

}
