# TextQuest?

TextQuest is a text-based adventure game set in a haunted carnival in a world where everyone is assumed dead - well... undead.  
You succumbed to the same fate and find yourself at the carnival entrance among ghosts and floating mascot heads.  
Duckhead, the disembodied head of a duck costume (the rest of which is nowhere in sight) discovers the player and sends them on a quest to solve a puzzle, after which the gates to the rest of the park unlock, and you can discover what sinister secrets await in this new universe.  

For now, only the first area and puzzle are available for play.  
Items are also instantly available to pick up; in later versions, you'll need to look for them!  

# Download and run
[Download TextQuest.jar](https://github.com/adam-lev-barnett/CSC403-TextQuest/releases/download/csc403/csc403-termProject-Adam-Barnett-TextQuest.jar)  
  
Run the game with
```bash
java -jar TextQuest.jar
```

# Tutorial
_Note: All interaction happens through the terminal and is case-insensitive_

1. At the start of the game, create your character when prompted
2. Duckhead has a yes/no question for you 
3. You're provided with a list of "available actions" (detailed below) that can be reaccessed by typing **`help`** in the terminal
4. Talk to Duckhead for a free shirt and idea of what you need to do to continue the game
5. Solve Duckhead's puzzle by picking up items available in the room and placing them in a specific order
6. See if you satisfied his requirements! If you didn't, you have to try again. 

## Available actions
- `Talk to Duckhead` - Talk to Duckhead to find out how to get out of here. He might even give you a present!
- `Solve puzzle` - Enter Puzzle Mode! Give Duckhead the items in the order you enter them. Hopefully they're in the correct order!
- `Pick up [item name]` - Pick up an item in the room and add it to your inventory. 
    - Once you pick it up, you can't pick it up again unless you drop it.  
    - Available items at the beginning: Duck Bill; Duck Call; Candy String  
- `Drop [item name]` - Drop an item if it's in your inventory. _There's no real reason to do this in this version._
-  `Inventory` - View the items in your inventory  
-  `Give up` - Exit the game and just accept this new reality.  

## Pseudo-tests
You can also enter the following, but these exist to test the game mechanics in the early stages of the game
- `Description` - Prints your character's description
- `Name` - Prints your character's name
- `DuckheadInventory` - Prints Duckhead's inventory
- `RoomInventory` - Prints room inventory. You can 'pick up' any of these items to solve the puzzle.

## Solving the puzzle
`Submit [item name]` - Add an item to the puzzle; puzzle will be shown to DuckHead in the order you submit items  
`Undo` - Removes the last item submitted to the puzzle and returns it to your inventory  
`Done` - Show DuckHead your completed puzzle  
`Leave` - Leave the puzzle for now; everything will be right where you left it when you return  
`Restart` - Remove all items from the puzzle and return them to your inventory  

# For Developers
## Accessing source code
TextQuest was built in VS Code using Maven with the entire project rooted under the folder 'textquest_csc403'  
The pom file can be accessed directly from this folder: `textquest_csc403/pom.xml`    
**To run the game** execute the `Main.java` class located at: `textquest_csc403/src/main/java/com/textquest/Main.java`  

**Main.java** is the game's starting point that:
- Initiates player creation
- Introduces the game via narration
- Activates user input loop via Interpreter.java

### Class files
Organized in folders within `textquest_csc403/src/main/java/com/textquest`

### Automated tests 
Located under `textquest_csc403/src/test`

## Folder Organization

- **Characters** - NPC and user player creation and management; Static NPCs declared in CharacterList
- **InputOutput** - General user input logic to be used across the game
- **Inventory_and_items** - Inventories, puzzles containers, and input parsing/logic for puzzle interaction. Static items declared in ItemCatalog
- **Rooms** - Interactive story environments. Static Rooms declared in GameMap
- **Utilities** - Test toggles, output pauses, and output control

## Testing
The program can be run in **two modes** that can be toggled by accessing the following class and adjusting the `TESTTOGGLE` boolean variable:  
`textquest_csc403/src/main/java/com/textquest/Utilities/TestToggle.java`

### To run junit tests as well as for faster in-game testing: 
Set `TestToggle.TESTTOGGLE` to `true`

**What this does:**
- Ignores user input prompts to avoid testing hangups for automated tests on certain components
- Removes all programmed narrative pauses to output for immediate testing feedback
- Creates a "test player" to skip player creation module while still being able to test components that require a Player instance
- Adds an additional section to the `help` menu to track changes to Player attributes as well as the inventories of Player, GameCharacter, and Room after different Player interactions

Tests can be run through your IDE if junit compatible, or with the command
```bash
$ mvn test
```

### For testing a full playthrough: 
set `TestToggle.TESTTOGGLE` to `false`

**What this does:**
- <ins>Some junit tests will hangup in this state due to expected user input</ins>
- Game will begin with input-based Player character creation instead of default test player
- Includes narrative pauses for output for paced and easier reading for the user
- Includes additional dialog and story elements for a full player experience
