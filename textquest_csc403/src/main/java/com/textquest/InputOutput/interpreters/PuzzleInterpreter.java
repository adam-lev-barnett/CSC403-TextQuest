package com.textquest.InputOutput.interpreters;

import com.textquest.Characters.GameCharacter;
import com.textquest.Inventory_and_Items.Item;
import com.textquest.Utilities.Words;
import com.textquest.errors.BadParameterException;

import static com.textquest.Main.player;

public class PuzzleInterpreter {
    GameCharacter player;

    public PuzzleInterpreter(GameCharacter player) throws BadParameterException {
        if (player == null) throw new BadParameterException("Player cannot be null");
        this.player = player;
    }

    void pickUpItemValidation(String[] playerWords) {
        if (playerWords.length == 1) System.out.println("Pick what? Your nose? Gross!");
        else if (playerWords.length == 2) {
            if (playerWords[1].equalsIgnoreCase("up")) System.out.println("Pick up what?");
            else System.out.println("Ya gotta \"pick up\" an item. Picking anything else won't work.");
        }

        else if (playerWords.length > 2 && playerWords[1].equalsIgnoreCase("up")) {
            pickUpItem(playerWords);
        }
    }

    void pickUpItem(String[] playerWords) {
        StringBuilder sbItemName = new StringBuilder(playerWords[2]);
        for (int i = 3; i < playerWords.length; i++) {
            sbItemName.append(" ").append(playerWords[i]);
        }
        String itemName = sbItemName.toString().toLowerCase();
        if (player.getRoom().getRoomInventory().hasItem(itemName)) {
            transferRoomInventoryToPlayer(itemName);
        }
        else System.out.println("There is no " + itemName + " to pick up!");
    }

    void transferRoomInventoryToPlayer(String itemName) {
        player.addToInventory(player.getRoom().getRoomInventory().getItem(itemName));
        player.getRoom().getRoomInventory().removeItem(itemName);
        Words.narrate(player.getInventory().getItem(itemName) + " description: " + player.getInventory().getItem(itemName).getDesc());
        System.out.println();
        player.printInventory();
    }

    void dropItem(String[] playerWords) {
        if (playerWords.length > 1) {
            StringBuilder sbItemName = new StringBuilder(playerWords[1]);
            for (int i = 2; i < playerWords.length; i++) {
                sbItemName.append(" ").append(playerWords[i]);
            }
            String itemName = sbItemName.toString().toLowerCase();
            if (player.getInventory().hasItem(itemName)) {
                Item droppedItem = player.getInventory().getItem(itemName);
                player.removeFromInventory(itemName);
                player.getRoom().getRoomInventory().addItem(droppedItem);
                System.out.println("You dropped: " + droppedItem);
                System.out.println();
                player.printInventory();
            }
            else System.out.println("There is no " + itemName + " in your inventory!");
        }
        else {
            System.out.println("Drop what? A phat beat? No problem!");
        }
    }
}
