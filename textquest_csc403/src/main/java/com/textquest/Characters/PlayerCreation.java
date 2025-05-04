package com.textquest.Characters;

import com.textquest.InputOutput.*;
import com.textquest.Rooms.*;

public class PlayerCreation {

    public static Player createPlayer() {
        String playerName = InputScanner.strIn("What's your name?");
        String playerDesc = InputScanner.strIn("Describe your character: ");
        return new Player(playerName, playerDesc, 10, GameMap.lobby);
    }

}
