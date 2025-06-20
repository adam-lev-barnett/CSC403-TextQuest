package com.textquest.InputOutput;
import java.util.Scanner;
import com.textquest.Utilities.*;

public class InputScanner {
    public static final Scanner scanner = new Scanner(System.in);

    public static String strIn(String prompt) {
        System.out.println(prompt);
        OutputPause.pause(1000);
        return scanner.nextLine();
    }

    public static int num(String prompt){
        while (!scanner.hasNextInt()){
            System.out.println("Please enter a number: ");
            scanner.next();
        }
        System.out.println(prompt);    
        return scanner.nextInt();
    }
}
