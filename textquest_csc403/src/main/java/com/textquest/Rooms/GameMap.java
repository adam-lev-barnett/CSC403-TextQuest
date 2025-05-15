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
        entrance.items.addItem("Fairy wand", ItemCatalog.toyFairyWand);
        entrance.items.addItem("Eternal cotton candy", ItemCatalog.cottonCandyEternal);
        entrance.items.addItem("Poisoned cotton candy", ItemCatalog.cottonCandyPoison);
        entrance.items.addItem("Blessed cotton candy", ItemCatalog.cottonCandyBlessed);
        entrance.items.addItem("Duck bill", ItemCatalog.duckBill);
        entrance.items.addItem("Duck call", ItemCatalog.duckCall);
        entrance.items.addItem("String", ItemCatalog.stringFromCandy);
        entrance.items.addItem("Duck shirt", ItemCatalog.duckShirt);

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
