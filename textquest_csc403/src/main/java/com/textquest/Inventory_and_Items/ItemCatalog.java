package com.textquest.Inventory_and_Items;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ItemCatalog {
    private static final Set<Item> internalInventory = new HashSet<>();
    public static final Set<Item> masterInventory = Collections.unmodifiableSet(internalInventory);

    // Full item list - easy O(1) access for individual inventory population
    // No need for string keys because there's no user input
    public static final Item toyFairyWand = new Item("Bloody Wand", "Bloody Toy Fairy Wand", "Not magical, but still somehow dangerous in the wrong (or right?) hands.");
    public static final Item cottonCandyEternal = new Item("Eternal Cotton Candy", "Cotton Candy (Eternal)", "A piece of the neverending and never-depleted pile of bright pink cotton candy.");
    public static final Item cottonCandyPoison = new Item("Poison Cotton Candy", "Cotton Candy (Poison)", "The radioactive glow of green sends a signal to your brain: \"Eating this won't end well for you. In what way? Feel free to find out.\"");
    public static final Item cottonCandyBlessed = new Item("Blessed Cotton Candy", "Cotton Candy (Blessed)", "Radiant and gold. Cotton candy so beautiful - awe inspiring even - that you find yourself crying. A voice rises from inside you, seemingly from your heart: \"From The Demise, I was created as a balance. From The Entertaining I was cast out. Aid me, cursed one, and find my true home.\"");
    public static final Item duckBill = new Item("duck bill", "Duck Bill", "If you're going to quack like a duck, you better look the part. There are small holes on the sides. You might be able to thread something through them to help secure it to your face.");
    public static final Item rope10 = new Item("rope", "Rope (nylon cord, 10 ft.)", "Left by some ghouls who tried to break into the gift shop many moons ago. What ended up happening to them? In any case, they forgot their rope.");
    public static final Item stringFromCandy = new Item("candy string", "Candy String", "Ah, to be young again and willing to eat your own jewelry. But you're dead! Besides, someone already ate this. At least they left the string.");
    public static final Item duckCall = new Item("duck call", "Duck Call", "Not your average duck call. It emits a mystical energy you can't quite comprehend, possibly having to do with the fact that you aren't a duck.");
    public static final Item duckShirt = new Item("duck shirt", "Duck Shirt", "A shirt that reads \"I \\u2665 \\uD83E\\uDD86s\" For die-hard duck fans. Not a duck? You can still support ducks!");
    
    // Can only add or remove items directly through the class

    static {
        //^ Entrance items
        // masterInventory.add(toyFairyWand);
        internalInventory.add(cottonCandyEternal);
        internalInventory.add(cottonCandyPoison);
        internalInventory.add(cottonCandyBlessed);
        internalInventory.add(duckBill);
        // masterInventory.add(rope10);
        internalInventory.add(stringFromCandy);
        internalInventory.add(duckCall);
        internalInventory.add(duckShirt);
    }

    private ItemCatalog() {}




}
