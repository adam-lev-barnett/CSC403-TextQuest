package com.textquest.Rooms;
import com.textquest.Inventory_and_Items.ItemCatalog;

public class GameMap {
    
    // Add new rooms here for easy organization and map connections in future versions
    public final static Room entrance = new Room("Carnival Entrance", "The entrance to the haunted carnival. The gateway to... something?");
    
    // Examples:
    // public static Room outside = new Room("Outside", "Outside the mansion");
    // public static Room kitchen = new Room("Kitchen", "The kitchen");

    static {
    // Room items
        // Carnival Entrance inventory - Items commented out for testing simplicity
        // entrance.items.addItem(ItemCatalog.toyFairyWand);
        // entrance.items.addItem(ItemCatalog.cottonCandyEternal);
        // entrance.items.addItem(ItemCatalog.cottonCandyPoison);
        // entrance.items.addItem(ItemCatalog.cottonCandyBlessed);
        entrance.inventory.addItem(ItemCatalog.duckBill);
        entrance.inventory.addItem(ItemCatalog.duckCall);
        entrance.inventory.addItem(ItemCatalog.stringFromCandy);
    }

    private GameMap() {}
                
}
