package com.textquest.Utilities;

import com.textquest.Rooms.GameMap;

public class Words {
    
    public static void narrate(String words) { // 500 for testing
        System.out.println(words);
        OutputPause.pause(0);
    }

    public static void narrateBlock(String words) {
        System.out.print(words);
        System.out.print("\n");
        OutputPause.pause(5500);
    }

    public static void whoosh() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        OutputPause.pause();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        OutputPause.pause();
        System.out.println("");
    }

    public static void tutorial() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ How to play ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Type in the following commands to perform their respective actions: \n");

        System.out.println("ITEM INTERACTION");
        System.out.println("• 'Pick up (item)' - If the item is in the room, add it to your inventory");
        System.out.println("• 'Drop (item) - If the item is in your inventory, it returns to the room.");
        System.out.println("• 'Use (item) - Use the item if it's in your inventory");
        System.out.println("--------------------------------------------------------------------------\n");

        System.out.println("TRAVERSAL");
        System.out.println("• 'Directions' - Display the areas around you");
        System.out.println("• 'Go (direction) - Travel to the area North, South, East, or West of you.");
        System.out.println("--------------------------------------------------------------------------\n");
    }

    public static void printValidActions() {
        Words.narrate("What will you do?");
        System.out.println("• 'Talk to Duckhead'?");
        System.out.println("• Solve the puzzle? ('solve puzzle')");
        System.out.println("• Pick up an item in the room? ('pick up <item name>')");
        System.out.println(  "    • Available room items: " + GameMap.entrance.getRoomItems());
        System.out.println("• 'Give up'?");
        System.out.println("");
        
        // In-game input testing for getter methods
        Words.narrate("At any time, you can also enter: ");
        System.out.println("• 'Description' - Prints your character's description"); //& Player description changes when you put on your duck shirt! 
        System.out.println("• 'Name' - Prints your character's name");
        System.out.println("• 'DuckheadInventory' - Prints Duckhead's inventory");
        System.out.println("• 'RoomInventory' - Prints room inventory");
    }
}
