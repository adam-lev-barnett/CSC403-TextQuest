package com.textquest.Characters;

import com.textquest.InputOutput.*;
import com.textquest.Rooms.*;
import com.textquest.Utilities.*;

public class PlayerCreation {
    

    public static Player createPlayer() {
        String playerName = InputScanner.strIn("What's your name?");
        OutputPause.pause();
        System.out.println(playerName + "? What kind of name is that?");
        OutputPause.pause();
        String playerDesc = InputScanner.strIn("Describe your character: ");
        OutputPause.pause();
        System.out.println("I'm so sorry you look like that.");
        return new Player(playerName, playerDesc, 10, null);
    }

}
