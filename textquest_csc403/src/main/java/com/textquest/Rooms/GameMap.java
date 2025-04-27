package com.textquest.Rooms;
import com.textquest.*;
import com.textquest.Inventory_and_Items.ItemCatalog;

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

    //~ Room items
    
        //^ Kitchen inventory
        kitchen.items.put("Spatula", ItemCatalog.spatula);
        kitchen.items.put("RuneBurger (Triangle)", ItemCatalog.runeBurger1);
        kitchen.items.put("RuneBurger (Circle)", ItemCatalog.runeBurger2);
        kitchen.items.put("RuneBurger (Square)", ItemCatalog.runeBurger3);


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
