package com.textquest.Characters;

import com.textquest.Rooms.Room;
import com.textquest.Inventory_and_Items.*;
import com.textquest.*;
import com.textquest.InputOutput.*;
import java.util.Scanner;


public class Player extends GameCharacter {

    public Player(String name, String desc, int health, Room room) {
        super(name, desc, health, room);
    }
    
    public void traverse(String direction) {
        switch (direction) {
            case "North": 
                room = room.north;
                break;
            case "South":
                room = room.south;
                break;
            case "East":
                room = room.east;
                break;
            case "West":
                room = room.west;
                break;
            default:
                System.out.println("You cannot go this direction.");
        }
    }
}
