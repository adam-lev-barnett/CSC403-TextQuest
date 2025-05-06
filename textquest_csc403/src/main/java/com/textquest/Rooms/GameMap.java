package com.textquest.Rooms;
import com.textquest.*;
import com.textquest.Inventory_and_Items.ItemCatalog;

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
        entrance.items.put("Bloody Toy Fairy Wand", ItemCatalog.toyFairyWand);
        entrance.items.put("Cotton Candy (Eternal)", ItemCatalog.cottonCandyEternal);
        entrance.items.put("Cotton Candy (Poison)", ItemCatalog.cottonCandyPoison);
        entrance.items.put("Cotton Candy (Blessed)", ItemCatalog.cottonCandyBlessed);



        
    
        //^ Kitchen inventory

        /* kitchen.items.put("Spatula", ItemCatalog.spatula);
        kitchen.items.put("RuneBurger (Triangle)", ItemCatalog.runeBurger1);
        kitchen.items.put("RuneBurger (Circle)", ItemCatalog.runeBurger2);
        kitchen.items.put("RuneBurger (Square)", ItemCatalog.runeBurger3); */


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
