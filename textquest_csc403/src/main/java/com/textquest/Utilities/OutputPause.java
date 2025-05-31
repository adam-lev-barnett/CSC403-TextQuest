package com.textquest.Utilities;


public class OutputPause {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // //~ Default pause - comment out when testing for faster read-through

    // public static void pause(){
    //     try {
    //         Thread.sleep(1000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    // //~ Overloaded pause to specify delay ; comment out when testing

    // public static void pause(int millis){
    //     try {
    //         Thread.sleep(millis);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    //~ Uncomment the following method when testing

    public static void pause(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //~ Uncomment the following method when testing

    public static void pause(int millis){
        millis = 0;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    

}
