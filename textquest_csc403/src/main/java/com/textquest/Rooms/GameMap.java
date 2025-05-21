package com.textquest.Rooms;
import com.textquest.*;
import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Inventory_and_Items.PuzzleDQ;
import com.textquest.Characters.*;

public class GameMap {
    
    public static Room entrance = new Room("Carnival Entrance", "The entrance to the haunted carnival. The gateway to... something?");
    public static Room outside = new Room("Outside", "Outside the mansion");
    public static Room kitchen = new Room("Kitchen", "The kitchen");

    //~ Connections
    public GameMap() {
        //^ Carnival Entrance connections
        entrance.south = null;
        entrance.east = kitchen;

        //^ Outside connections
        outside.north = entrance;

        //^ Kitchen Connections
        kitchen.west = entrance;

    //~ Room items
        //^ Carnival Entrance inventory
        entrance.items.addItem(ItemCatalog.toyFairyWand);
        entrance.items.addItem(ItemCatalog.cottonCandyEternal);
        entrance.items.addItem(ItemCatalog.cottonCandyPoison);
        entrance.items.addItem(ItemCatalog.cottonCandyBlessed);
        entrance.items.addItem(ItemCatalog.duckBill);
        entrance.items.addItem(ItemCatalog.duckCall);
        entrance.items.addItem(ItemCatalog.stringFromCandy);
        entrance.items.addItem(ItemCatalog.duckShirt);

    //~ Room Puzzle DQs

        
    //~ Room Characters
        
        
    
        //^ Kitchen inventory




    }
    /* 9 dashes for roof and floor
     * 
     *             |
     *         ---------     ---------
     *      – |  Lobby  | – | Kitchen |
     *         ---------     ---------
     *             |
     *         ----------
     *        | Entrance |
     *         ----------
     */

}
