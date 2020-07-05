package com.sda.javagdy4.threading.start1watek;

public class ActivityNotifyingRunnable implements Runnable {
    private int howManyLoops;
    private String jakisTekst = "tekst";

    public ActivityNotifyingRunnable(int howManyLoops) {
        this.howManyLoops = howManyLoops;
    }

    public void setJakisTekst(String jakisTekst) {
        this.jakisTekst = jakisTekst;
    }

    @Override
    public void run() {
        while (--howManyLoops > 0 ){
            try {
                Thread.sleep(3000);

                System.out.println("Are we there Yet?! -- " + jakisTekst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello, I'm finished!");
    }
}
