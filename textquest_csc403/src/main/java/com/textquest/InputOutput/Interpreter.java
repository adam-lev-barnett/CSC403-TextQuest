package com.textquest.InputOutput;

import java.lang.IllegalArgumentException;
import java.util.Scanner;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.GameMap;
import com.textquest.Utilities.Words;

import java.lang.StringBuilder;
import edu.princeton.cs.algs4.StdAudioStereo;

//! Need to catch overindexing for 1-word inputs but no follow-ups (examples: "go ", "solve ")

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
        while (!command.equalsIgnoreCase("give up")) {
            String[] playerWords = command.split(" ");

            //^ Traversal
            if (playerWords[0].equalsIgnoreCase("go")) { 
                if (playerWords.length == 1) {
                    System.out.println("Go where?");
                }
                else player.traverse(playerWords[1].toLowerCase());
            }

            //^ Self-checks
            else if (playerWords[0].equalsIgnoreCase("description")) {
                System.out.println(player.getDesc());
            }

            else if (playerWords[0].equalsIgnoreCase("name")) {
                System.out.println(player.getName());
            }

            else if (playerWords[0].equalsIgnoreCase("inventory")) {
                System.out.println(player.getInventory());
            }


            //^ Other checks
            else if (playerWords[0].equalsIgnoreCase("duckHeadInventory")) {
                System.out.println(CharacterList.duckHead.getInventory());
            }

            else if (playerWords[0].equalsIgnoreCase("roomInventory")) {
                System.out.println(player.getRoom().getItems());
            }


            //^ Inventory actions

            //& Pick up item: item moves from area inventory to player inventory
            else if (playerWords[0].equalsIgnoreCase("pick")) {
                if (playerWords.length == 1) System.out.println("Pick what? Your nose? Gross!");
                else if (playerWords.length == 2) {
                    if (playerWords[1].equalsIgnoreCase("up")) System.out.println("Pick up what?");
                    else System.out.println("Ya gotta \"pick up\" an item. Picking anything else won't work.");
                }

                else if (playerWords.length > 2 && playerWords[1].equalsIgnoreCase("up")) {
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
            }

            //& Drop item: item moves from player inventory to area inventory
            else if (playerWords[0].equalsIgnoreCase("drop")) {
                if (playerWords.length > 1) {
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
                else {
                    System.out.println("Drop what? A phat beat? No problem!");
                    StdAudioStereo.play("textquest_csc403/src/main/java/com/textquest/Phat beat.wav");
                }
            }

            //& Talk to Duckhead to obtain duck shirt
            else if ((playerWords[0].equalsIgnoreCase("talk"))) {

                if ((playerWords.length > 2) && (playerWords[1].equalsIgnoreCase("to") && (playerWords[2].equalsIgnoreCase("duckhead")))) {
                    CharacterList.duckHead.speak("I'm not - QUACK - gonna let you go very far unless you present me with three items in the correct order that'll show me you know how to quack with the best of us!");
                    if (CharacterList.duckHead.getInventory().containsKey("duck shirt")) {
                        CharacterList.duckHead.speak("But here's a little something to get you - QUACK - started.");
                        Words.narrate("Duckhead opens his beak to reveal a t-shirt. It reads \"I \u2665 \uD83E\uDD86s\"");
                        String putOnShirt = InputScanner.strIn("Do you put it on?");
                        while (!putOnShirt.equalsIgnoreCase("yes")) {
                            putOnShirt = InputScanner.strIn("I'm just going to keep asking you until you say \"yes\".");
                        }
                        CharacterList.duckHead.giveItem(CharacterList.duckHead.getInventory().get("duck shirt"), player);
                        player.putOnDuckShirt();
                    }
                    CharacterList.duckHead.speak("Now go find me those items! When you're ready, say \"solve puzzle\"");
                    }
                else System.out.println("The only way you can speak is if you \"talk to Duckhead.\"");
            }

            //^ Puzzles
    //! "you haven't added anything yet" - done when items in dq
    //! Can continue to add the same item after submission, but it doesn't accumulate in the dq
    //& Adding "restart" to clear puzzledq and return everything to player inventory

            else if (playerWords[0].equalsIgnoreCase("solve")) {
                if (playerWords.length > 1 && playerWords[1].equalsIgnoreCase("puzzle")) {
                    if (player.getRoom().getPuzzle() != null) {
                        String[] itemNameParse = InputScanner.strIn("Use an item from your inventory (use format \"Use [item name]\"). Type \"done\" when you want to submit. Type \"undo\" to take back the last item.").split(" ");
                        //! While loop, conditional for if user enters nothing ""
                        while (!itemNameParse[0].equalsIgnoreCase("done") && !itemNameParse[0].equalsIgnoreCase("leave")) {
                            if (itemNameParse.length == 1) {

                                if (itemNameParse[0].equalsIgnoreCase("undo")) {
                                    if (player.getRoom().getPuzzle().isEmpty()) { //& Fringe case: undo when there's nothing in the puzzle dq
                                    System.out.println("You haven't added anything yet!");
                                    }
                                    else {
                                        player.inventory.addItem(player.getRoom().getPuzzle().pollLast()); // last added item (item in the back of the dq) goes back to user inventory
                                    }
                                }

                                else if (itemNameParse[0].equalsIgnoreCase("restart")) {
                                    while (!player.getRoom().getPuzzle().isEmpty()) {
                                        player.inventory.addItem(player.getRoom().getPuzzle().pop());
                                    }
                                    System.out.println("All items have been returned to your inventory, and the puzzle is empty.");
                                }
                                else System.out.println("\"Use\" an item!");
                                System.out.println("Current puzzle order: " + player.getRoom().getPuzzle());
                                System.out.println("You can use: " + player.getInventory().printItemNicknames());
                            }

                            else if (itemNameParse[0].equals("use") && itemNameParse.length > 1) {
                                StringBuilder itemNameSB = new StringBuilder(itemNameParse[1]);
                                for (int i = 2; i < itemNameParse.length; i++) {
                                    itemNameSB.append(" " + itemNameParse[i]);
                                }
                                String itemString = itemNameSB.toString();
                                if (player.getInventory().containsKey(itemString)) {
                                    player.getRoom().getPuzzle().add(player.getInventory().get(itemString)); // Add new items to the back of the dq to display puzzle order
                                    player.getInventory().remove(itemString);
                                }
                                else {
                                    System.out.println(itemString + " is not in your inventory!");
                                }
                                System.out.println(player.getRoom().getPuzzle());
                                System.out.println("You can use: " + player.getInventory().printItemNicknames());
                            }
                            itemNameParse = InputScanner.strIn("Use an item from your inventory (use format \"Use [item name]\"). Type \"done\" when you want to submit. You can also \"undo,\" \"leave,\" or \"restart.\"").split(" "); 
                        }

                        if (itemNameParse[0].equalsIgnoreCase("done")) {
                            if (player.getRoom().equals(GameMap.entrance)) {
                                PuzzleList.duckPuzzle(player.getRoom().getPuzzle(), player);
                                System.out.println(player.getInventory());
                            }
                        }
                        else if (itemNameParse[0].equalsIgnoreCase("leave")) {
                            System.out.println("The puzzle still has your items. Please return at any time.");
                        }
                    }
                    else System.out.println("There is no puzzle in this room!");
                    }
                else System.out.println("Solve what?");
                }
            System.out.println("Enter a command: ");
            command = action.nextLine();
            }
        }
    }
