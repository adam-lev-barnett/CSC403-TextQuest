package com.textquest.Characters;
import com.textquest.Inventory_and_Items.*;

public class GameCharacter {
    String name;
    String desc;
    int health;
    Inventory inventory;

    public GameCharacter(String name, String desc, int health) {
        this.name = name;
        this.desc = desc;
        this.health = health;
    }

}
