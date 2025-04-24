package com.textquest.Rooms;
import com.textquest.*;

public final class GameMap {
    Room lobby = new Room("Lobby", "The starting room");
    Room outside = new Room("Outside", "Outside the mansion");
    Room kitchen = new Room("Kitchen", "The kitchen");

    //~ Connections
    public GameMap() {
        //^ Lobby connections
        lobby.south = outside;
        lobby.east = kitchen;

        //^ Outside connections
        outside.north = lobby;

        //^ Kitchen Connections
        kitchen.west = lobby;
    }
    /* 9 dashes for roof and floor
     * 
     *             |
     *         ---------     ---------
     *      – |  Lobby  | – | Kitchen |
     *         ---------     ---------
     *             |
     *         ---------
     *        | Outside |
     *         ---------
     */

}
