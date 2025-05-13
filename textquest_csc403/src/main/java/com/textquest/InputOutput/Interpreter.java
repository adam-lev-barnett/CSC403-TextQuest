package com.textquest.InputOutput;

import java.io.InputStream;
import java.util.Scanner;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import java.lang.StringBuilder;

public class Interpreter {

    Scanner action = new Scanner(System.in);
    Player player;

    public Interpreter(Player player) {
        this.player = player;
    }

    public void getAction() {
        System.out.println("Enter a command: ");

        String command = action.nextLine();
        while (!command.equals("give up")) {
            String[] playerWords = command.split(" ");

            //^ Traversal
            if (playerWords[0].equalsIgnoreCase("go")) {
                player.traverse(playerWords[1]);
            }

            //^ Self-checks
            else if (playerWords[0].equalsIgnoreCase("description")) {
                System.out.println(player.getDesc());
            }

            //^ Inventory actions

            //& Pick up item: item moves from area inventory to player inventory
            else if (playerWords[0].equalsIgnoreCase("pick") && playerWords[1].equalsIgnoreCase("up")) {
                StringBuilder sbItemName = new StringBuilder(playerWords[2]);
                for (int i = 3; i < playerWords.length; i++) {
                    sbItemName.append(" ").append(playerWords[i]);
                }
                String itemName = sbItemName.toString();
                if (player.getRoom().items.containsKey(itemName)) {
                    player.getInventory().put(itemName, player.getRoom().items.get(itemName));
                    player.getRoom().items.remove(itemName);
                    System.out.println(itemName + " has been added to your inventory");
                    System.out.println("Your inventory: " + player.getInventory());
                }
                else System.out.println("There is no " + itemName + " to pick up!");
            }

            //& Drop item: item moves from player inventory to area inventory
            else if (playerWords[0].equalsIgnoreCase("drop")) {
                StringBuilder sbItemName = new StringBuilder(playerWords[1]);
                for (int i = 2; i < playerWords.length; i++) {
                    sbItemName.append(" ").append(playerWords[i]);
                }
                String itemName = sbItemName.toString();
                if (player.getInventory().containsKey(itemName)) {
                    Item droppedItem = player.getInventory().get(itemName);
                    player.getInventory().remove(itemName);
                    player.getRoom().items.put(itemName, droppedItem);
                }
                else System.out.println("There is no " + itemName + " in your inventory!");
            }
            System.out.println("Enter a command: ");
            command = action.nextLine();
        }
    }
    
}