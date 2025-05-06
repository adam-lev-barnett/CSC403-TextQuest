package com.textquest.Utilities;



public class OutputPause {
    
    public static void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
