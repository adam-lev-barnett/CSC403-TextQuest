package com.textquest.Inventory_and_Items;

import java.util.HashSet;

public class ItemCatalog {
    public static HashSet<Item> masterInventory = new HashSet<>();

    public static Item toyFairyWand = new Item("Bloody Toy Fairy Wand", "Not magical, but still somehow dangerous in the wrong (or right?) hands.");
    public static Item cottonCandyEternal = new Item("Cotton Candy (Eternal)", "A piece of the neverending and never-depleted pile of bright pink cotton candy.");
    public static Item cottonCandyPoison = new Item("Cotton Candy (Poison)", "The radioactive glow of green sends a signal to your brain: \"Eating this won't end well for you. In what way? Feel free to find out.\"");
    public static Item cottonCandyBlessed = new Item("Cotton Candy (Blessed)", "Radiant and gold. Cotton candy so beautiful - awe inspiring even - that you find yourself crying. A voice rises from inside you, seemingly from your heart: \"From The Demise, I was created as a balance. From The Entertaining I was cast out. Aid me, cursed one, and find my true home.\"");


    // public static Item stick = new Item("Stick", "A basic stick, probably from a tree"); 
    // public static Item marshmallow = new Item("Marshmallow", "A squishy marshmallow; easily poked");
    // public static Item burntMarshmallow = new Item("Burnt Marshmallow", "Very gooey. Your fingers might stick together if you're not careful!");
    // public static Item spatula = new Item("Spatula", "A nice wooden spatula with no slats. Great for patty-flipping.");
    // public static Item runeBurger1 = new Item("Runeburger (Triangle)", "A mysterious meat patty with a triangle underneath. See what happens if you flip it!");
    // public static Item runeBurger2 = new Item("Runeburger (Circle)", "A mysterious meat patty with a circle underneath. See what happens if you flip it!");
    // public static Item runeBurger3 = new Item("Runeburger (Square)", "A mysterious meat patty with a square underneath. See what happens if you flip it!");

    
    public void populateItems() {
        masterInventory.add(toyFairyWand);
        masterInventory.add(cottonCandyEternal);
        masterInventory.add(cottonCandyPoison);
        masterInventory.add(cottonCandyBlessed);

    }
}
