package com.textquest.InputOutput;

import java.lang.IllegalArgumentException;
import java.io.InputStream;
import java.util.Scanner;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.GameMap;

import java.lang.StringBuilder;
import com.textquest.InputOutput.*;

public class Interpreter {

    Scanner action = new Scanner(System.in);
    Player player;

    public Interpreter(Player player) {
        this.player = player;
    }

    public void getAction() {
        if (player == null) throw new IllegalArgumentException("Player must be instantiated");

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

            else if (playerWords[0].equalsIgnoreCase("name")) {
                System.out.println(player.getDesc());
            }

            //^ Inventory actions

            //& Pick up item: item moves from area inventory to player inventory
            else if (playerWords[0].equalsIgnoreCase("pick") && playerWords[1].equalsIgnoreCase("up")) {
                StringBuilder sbItemName = new StringBuilder(playerWords[2]);
                for (int i = 3; i < playerWords.length; i++) {
                    sbItemName.append(" ").append(playerWords[i]);
                }
                String itemName = sbItemName.toString().toLowerCase();
                if (player.getRoom().getItems().containsKey(itemName)) {
                    player.getInventory().put(itemName, player.getRoom().items.get(itemName));
                    player.getRoom().getItems().remove(itemName);
                    System.out.println(itemName + " has been added to your inventory");
                    System.out.println(player.getInventory());
                }
                else System.out.println("There is no " + itemName + " to pick up!");
            }

            //& Drop item: item moves from player inventory to area inventory
            else if (playerWords[0].equalsIgnoreCase("drop")) {
                StringBuilder sbItemName = new StringBuilder(playerWords[1]);
                for (int i = 2; i < playerWords.length; i++) {
                    sbItemName.append(" ").append(playerWords[i]);
                }
                String itemName = sbItemName.toString().toLowerCase();
                if (player.getInventory().containsKey(itemName)) {
                    Item droppedItem = player.getInventory().get(itemName);
                    player.getInventory().remove(itemName);
                    player.getRoom().getItems().put(itemName, droppedItem);
                }
                else System.out.println("There is no " + itemName + " in your inventory!");
            }

            //^ Puzzles
    //! "you haven't added anything yet" - done when items in dq
    //! Can continue to add the same item after submission, but it doesn't accumulate in the dq

            else if (playerWords[0].equalsIgnoreCase("solve") && playerWords[1].equalsIgnoreCase("puzzle")) {
                String[] itemNameParse = InputScanner.strIn("Use an item from your inventory (use format \"Use [item name]\"). Type \"done\" when you want to submit. Type \"undo\" to take back the last item.").split(" ");
                //! While loop, conditional for if user enters nothing ""
                while (!itemNameParse[0].equalsIgnoreCase("done")) {

                    if (itemNameParse[0].equalsIgnoreCase("undo")) {
                        if (player.getRoom().getPuzzle().isEmpty()) { //& Fringe case: undo when there's nothing in the puzzle dq
                        System.out.println("You haven't added anything yet!");
                        }
                        else {
                            player.inventory.addItem(player.getRoom().getPuzzle().pop()); // last added item goes back to inventory //^ using the deque!
                            System.out.println(player.getRoom().getPuzzle());
                            System.out.println(player.getInventory());
                        }
                        
                    }
                    
                    else if (itemNameParse.length > 1) {
                        StringBuilder itemNameSB = new StringBuilder(itemNameParse[1]);
                        for (int i = 2; i < itemNameParse.length; i++) {
                            itemNameSB.append(" " + itemNameParse[i]);
                        }
                        String itemString = itemNameSB.toString();
                        if (player.getInventory().containsKey(itemString)) {
                            player.getRoom().getPuzzle().push(player.getInventory().get(itemString));
                            player.getInventory().remove(itemString);
                        }
                        else {
                            System.out.println(itemString + " is not in your inventory!");
                        }
                        System.out.println(player.getRoom().getPuzzle());
                    }
                itemNameParse = InputScanner.strIn("Use an item from your inventory (use format \"Use [item name]\"). Type \"done\" when you want to submit.").split(" "); 
                }
                if (player.getRoom().equals(GameMap.entrance)) {
                    PuzzleDQ playerPuzzleCopy = new PuzzleDQ();
                    playerPuzzleCopy.clone(player.getRoom().getPuzzle());
                    PuzzleList.duckPuzzle(playerPuzzleCopy, player);
                    System.out.println(player.getInventory());
                }
                else System.out.println("There is no puzzle in this room!");

                }
            System.out.println("Enter a command: ");
            command = action.nextLine();
            }
        }
    }
