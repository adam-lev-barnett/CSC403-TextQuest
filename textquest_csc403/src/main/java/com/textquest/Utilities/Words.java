package com.textquest.Utilities;

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
}
