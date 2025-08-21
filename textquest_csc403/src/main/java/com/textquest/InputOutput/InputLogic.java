package com.textquest.InputOutput;

import com.textquest.Characters.CharacterList;
import com.textquest.Characters.Player;
import com.textquest.Inventory_and_Items.Item;
import com.textquest.Utilities.Words;
import com.textquest.errors.InvalidUserInputException;

import java.util.Scanner;

public enum InputLogic {
    INSTANCE;

    Scanner action = new Scanner(System.in);
    Player player;

    public static InputLogic getInstance() {
        return INSTANCE;
    }

    public String pickUpItem(String[] userIn) throws InvalidUserInputException {
        if (userIn.length == 1) return "Pick what? Your nose? Gross!";
        else if (userIn.length == 2) {
            if (userIn[1].equalsIgnoreCase("up")) return "Pick up what?";
            else return "Ya gotta \"pick up\" an item. Picking anything else won't work.";
        } else if (userIn.length > 2 && userIn[1].equalsIgnoreCase("up")) {
            StringBuilder sbItemName = new StringBuilder(userIn[2]);
            for (int i = 3; i < userIn.length; i++) {
                sbItemName.append(" ").append(userIn[i]);
            }
            // TODO get the view to return the full inventory
            String itemName = sbItemName.toString().toLowerCase();
            if (player.getRoom().getRoomInventory().hasItem(itemName)) {
                player.addToInventory(player.getRoom().getRoomInventory().getItem(itemName));
                player.getRoom().getRoomInventory().removeItem(itemName);
                return player.getInventory().getItem(itemName) + " description: " + player.getInventory().getItem(itemName).getDesc();
            } else return "There is no " + itemName + " to pick up!";
        }
        else throw new InvalidUserInputException();
    }

    public String dropItem(String[] userIn) throws InvalidUserInputException {
        if (userIn[0].equalsIgnoreCase("drop")) {
            if (userIn.length > 1) {
                StringBuilder sbItemName = new StringBuilder(userIn[1]);
                for (int i = 2; i < userIn.length; i++) {
                    sbItemName.append(" ").append(userIn[i]);
                }
                String itemName = sbItemName.toString().toLowerCase();
                if (player.getInventory().hasItem(itemName)) {
                    Item droppedItem = player.getInventory().getItem(itemName);
                    player.removeFromInventory(itemName);
                    player.getRoom().getRoomInventory().addItem(droppedItem);
                    return ("You dropped: " + droppedItem + "\n" + player.printInventory() + "\n" + player.printInventory());
                }
                else return "There is no " + itemName + " in your inventory!";
            }
            else {
                return "Drop what? A phat beat? No problem!";
                // StdAudioStereo.play("textquest_csc403/src/main/java/com/textquest/Phat beat.wav");
            }
        }
        throw new InvalidUserInputException();
    }

    //! Need to figure out how to incorporate returning Strings and speak
    public void talkToCharacter(String[] userIn) {
        if ((userIn.length > 2) && (userIn[1].equalsIgnoreCase("to") && (userIn[2].equalsIgnoreCase("duckhead")))) {
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
}
