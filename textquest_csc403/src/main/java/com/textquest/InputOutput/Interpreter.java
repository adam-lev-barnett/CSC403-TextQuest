package com.textquest.InputOutput;

import java.lang.IllegalArgumentException;
import java.util.Scanner;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.GameMap;
import com.textquest.Utilities.TestToggle;
import com.textquest.Utilities.Words;

import java.lang.StringBuilder;

/* Input is parsed through a combination of splitting user input, array indexing, and a StringBuilder 
   to combine words when necessary to match multi-word String keys in Inventories to access their Item values */

public class Interpreter {

    Scanner action = new Scanner(System.in);
    Player player;

    public Interpreter(Player player) {
        this.player = player;
    }

    public void getAction() {
        if (player == null) throw new IllegalArgumentException("Player must be instantiated");
        System.out.println("");
        if (TestToggle.TESTMODE) {
            Words.printValidActionsTest();
        }
        else Words.printValidActions();
        System.out.println("Enter a command: ");
        String command = action.nextLine();
        while (!command.equalsIgnoreCase("give up")) {
            System.out.println();
            String[] playerWords = command.split(" ");

           /* Traversal - Unavailable this version
            if (playerWords[0].equalsIgnoreCase("go")) { 
                if (playerWords.length == 1) {
                    System.out.println("Go where?");
                }
                else player.traverse(playerWords[1].toLowerCase());
            } */

            // Player attributes for in-game testing ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if (playerWords[0].equalsIgnoreCase("description")) {
                System.out.println(player.getDesc());
            }

            else if (playerWords[0].equalsIgnoreCase("name")) {
                System.out.println(player.getName());
            }

            else if (playerWords[0].equalsIgnoreCase("inventory")) {
                System.out.println(player.getInventory());
            }

            // Other in-game checks for testing; no need to comment out unless deployed for user
            else if (playerWords[0].equalsIgnoreCase("duckHeadDesc")) {
                System.out.println(CharacterList.duckHead.getDesc());
            }

            else if (playerWords[0].equalsIgnoreCase("duckHeadInventory")) {
                System.out.println(CharacterList.duckHead.getInventory());
            }

            else if (playerWords[0].equalsIgnoreCase("roomInventory")) {
                System.out.println(player.getRoom().getRoomInventory());
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //~ Prints list of available actions; description, name, duckheadinventory, roominventory aren't listed in user mode, but you can still type them in

            //~ Outputs list of available input commands for player
            else if (playerWords[0].equalsIgnoreCase("help")) {
                if (TestToggle.TESTMODE) {
                    Words.printValidActionsTest();
                }
                else Words.printValidActions();
            }

            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            // Inventory actions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            //& Pick up item: item moves from area inventory to player inventory ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //! Cases created for unavailable items as well as incomplete input without throwing errors

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
                    if (player.getRoom().getRoomInventory().hasItem(itemName)) {
                        player.addToInventory(player.getRoom().getRoomInventory().getItem(itemName));
                        player.getRoom().getRoomInventory().removeItem(itemName);
                        Words.narrate(player.getInventory().getItem(itemName) + " description: " + player.getInventory().getItem(itemName).getDesc());
                        System.out.println();
                        player.printInventory();
                    }
                    else System.out.println("There is no " + itemName + " to pick up!");
                }
            }

            //& Drop item: item moves from player inventory to area inventory ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            else if (playerWords[0].equalsIgnoreCase("drop")) {
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
                    // StdAudioStereo.play("textquest_csc403/src/main/java/com/textquest/Phat beat.wav");
                }
            }

            //& Talk to Duckhead to obtain duck shirt ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //! Method in GameCharacter added to prevent repeat of full dialog and item exchange 

            else if ((playerWords[0].equalsIgnoreCase("talk"))) {
                if ((playerWords.length > 2) && (playerWords[1].equalsIgnoreCase("to") && (playerWords[2].equalsIgnoreCase("duckhead")))) {
                    CharacterList.duckHead.speak("I'm not - QUACK - gonna let you go very far unless you present me with three items in the correct order that'll show me you know how to quack with the best of us!");
                    if (CharacterList.duckHead.getInventory().hasItem("duck shirt")) {
                        CharacterList.duckHead.speak("But here's a little something to get you - QUACK - started.");
                        Words.narrate("Duckhead opens his beak to reveal a t-shirt. It reads \"I \u2665 \uD83E\uDD86s\"");
                        String putOnShirt = InputScanner.strIn("Do you put it on?");
                        while (!putOnShirt.equalsIgnoreCase("yes")) {
                            putOnShirt = InputScanner.strIn("I'm just going to keep asking you until you say \"yes\".");
                        }
                        CharacterList.duckHead.giveItem(CharacterList.duckHead.getInventory().getItem("duck shirt"), player);
                        player.putOnDuckShirt();
                        //& Fun, cosmetic change to character description - can be tested by inputting "description" 
                    }
                    CharacterList.duckHead.speak("Now go find me those items! When you're ready, say \"solve puzzle\". Don't - QUACK - give up that shirt, though, or I'll call you an idiot!");
                    }
                else System.out.println("The only way you can speak right now is if you \"talk to Duckhead.\"");
            }

            // Puzzles ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            else if (playerWords[0].equalsIgnoreCase("solve")) {
                if (playerWords.length > 1 && playerWords[1].equalsIgnoreCase("puzzle")) {

                    if (player.getRoom().getPuzzle() != null) {
                    //! Boolean check to prevent puzzle access after successful completion
                        if (player.getRoom().solvedPuzzle == false) {
                            String[] itemNameParse = InputScanner.strIn("Submit an item from your inventory (use format \"Submit [item name]\"). Type \"done\" when you're ready to give the items to Duckhead. You can also \"undo,\" \"leave,\" or \"restart.\" \n" + "You can submit: " + player.getInventory()).split(" ");
                            // Words.narrate("You can submit the following items to solve the puzzle: " + player.getInventory());                            
                            while (!itemNameParse[0].equalsIgnoreCase("done") && !itemNameParse[0].equalsIgnoreCase("leave")) {
                                
                                //& Single-word puzzle actions (undo, restart) to avoid outOfBounds
                                if (itemNameParse.length == 1) {
                                    if (itemNameParse[0].equalsIgnoreCase("undo")) {
                                        if (player.getRoom().getPuzzle().isEmpty()) { //& Fringe case: undo when there's nothing in the puzzle dq
                                        System.out.println("You haven't added anything yet!");
                                        }
                                        else {
                                            player.getInventory().addItem(player.getRoom().getPuzzle().undo()); // last added item (item in the back of the dq) goes back to user inventory
                                        }
                                    }

                                    else if (itemNameParse[0].equalsIgnoreCase("restart")) {
                                        while (!player.getRoom().getPuzzle().isEmpty()) {
                                            player.getInventory().addItem(player.getRoom().getPuzzle().poll());
                                        }
                                        System.out.println("All items have been returned to your inventory, and the puzzle is empty.");
                                    }
                                    else System.out.println("\"Submit\" an item!");
                                    System.out.println(player.getRoom().getPuzzle());
                                    // Words.narrate("You can submit the following items to solve the puzzle: " + player.getInventory());
                                    System.out.println("");
                                }
                                
                                //& Add an item to PuzzleDeque ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                else if (itemNameParse[0].equals("submit") && itemNameParse.length > 1) {
                                    StringBuilder itemNameSB = new StringBuilder(itemNameParse[1]);
                                    for (int i = 2; i < itemNameParse.length; i++) {
                                        itemNameSB.append(" " + itemNameParse[i]);
                                    }
                                    String itemString = itemNameSB.toString();

                                    // Add new items to the back of the deque to display puzzle order, only if item is in the player inventory
                                    if (player.getInventory().hasItem(itemString)) {
                                        player.getRoom().getPuzzle().add(player.getInventory().getItem(itemString)); 
                                        player.getInventory().removeItem(itemString);

                                    // Item is no longer in player inventory and cannot be added again
                                    // Previous item deposit can be undone through "undo" -- use of modified pollLast() through ArrayDeque in PuzzleDeque

                                    }
                                    else {
                                        System.out.println();
                                        System.out.println(itemString + " is not in your inventory!");
                                    }
                                    System.out.println(player.getRoom().getPuzzle());
                                    // Words.narrate("You can use the following items to solve the puzzle: " + player.getInventory());
                                    System.out.println("");
                                }

                                itemNameParse = InputScanner.strIn("Use an item from your inventory (use format \"Submit [item name]\"). Type \\\"done\\\" when you're ready to give the items to Duckhead. You can also \"undo,\" \"leave,\" or \"restart.\" \n" + "You can submit: " + player.getInventory()).split(" ");
                            }
                            
                            // Done with building puzzle deque and ready to solve the puzzle ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                            if (itemNameParse[0].equalsIgnoreCase("done")) {
                                if (player.getRoom().equals(GameMap.entrance)) {
                                    Puzzles.duckPuzzle(player.getRoom().getPuzzle(), player);
                                }
                                // Words.narrate("There are no other rooms right now, so how can you not be at the entrance??");
                            }

                            else if (itemNameParse[0].equalsIgnoreCase("leave")) {
                                System.out.println("The puzzle still has your items. Please return at any time.");
                            }

                        }
                        
                        //!Can't solve the same puzzle twice

                        else if (player.getRoom().solvedPuzzle == true) System.out.println("You've already solved this puzzle!");
                    }
                    else System.out.println("There is no puzzle in this room!");
                }
                else System.out.println("Solve what?");
            }
            if (player.getRoom().getSolvedPuzzle() == true) {
                System.out.println("You beat the game, kind of! At least the current version. Quack.");
                break;
            }

            System.out.println("");
            System.out.println("Enter a command: ");
            command = action.nextLine();
            }
        }
    }
