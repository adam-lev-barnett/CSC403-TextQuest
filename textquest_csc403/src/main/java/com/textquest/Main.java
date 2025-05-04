package com.textquest;

import com.textquest.Characters.*;
import com.textquest.Rooms.*;
import com.textquest.Inventory_and_Items.*;

public class Main {

    //^ Game element initialization
    ItemCatalog itemCatalog = new ItemCatalog();

    public static void main(String[] args) {
        
        //^ Game script
        Player player = PlayerCreation.createPlayer();
    }
}