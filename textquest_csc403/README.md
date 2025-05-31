README

Run the full program through .src/main/java/com/textquest/Main.java
    • Progression relies on user input, so keep your eyes on the terminal!
    • **IF YOU NEED TO RUN TESTS** please see the instructions below; 

Testing

**Testing blocks uncommented by default**
*For a full playthrough and before deployment, comment/uncomment the same blocks*

Automated junit tests can be accessed in .src/main/java

BEFORE TESTING JUNITS (AND TO BREEZE THROUGH INTENTIONALLY DELAYED OUTPUT)

Go to the following classes, search for "//~" and comment out/uncomment the indicated text blocks.
    • Avoids hangups from testing user input
    • Skips pauses implemented for reading narrative dialog for faster run-through
    • Creates test player to skip character creation

**Classes with testing blocks**
• Main.java - 2 blocks - (can also search for "test player test" and "duckhead dialog test")
• Interpreter.java - 1 block - (can also search for "help test")
• Puzzles.java - 1 block - (can also search for "puzzle success test")
• OutputPause.java - comment out top two blocks for testing; uncomment bottom two
• Words.java - optional testing block to uncomment for in-game state testing - comment out for deployment (can search for "in game help test")

junit vs testing in-game


