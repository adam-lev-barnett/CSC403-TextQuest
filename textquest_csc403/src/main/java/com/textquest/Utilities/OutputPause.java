package com.textquest.Utilities;


//& Added overloaded pause for default 1000ms or custom int
public class OutputPause {
    
    public static void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pause(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
