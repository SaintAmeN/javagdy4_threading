package com.sda.javagdy4.threading.start1watek;

public class ActivityNotifyingRunnable implements Runnable {
    private int howManyLoops;

    public ActivityNotifyingRunnable(int howManyLoops) {
        this.howManyLoops = howManyLoops;
    }

    @Override
    public void run() {
        while (--howManyLoops > 0 ){
            try {
                Thread.sleep(1);

                System.out.println("Are we there Yet?!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello, I'm finished!");
    }
}
