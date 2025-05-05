package com.textquest.Utilities;



public class OutputPause {
    
    public static void pause(int s){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
