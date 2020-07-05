package com.sda.javagdy4.threading.start1watek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // stworzenie zadania dla wątku bocznego/drugiego
        ActivityNotifyingRunnable activityNotifyingRunnable = new ActivityNotifyingRunnable(3);

        // Stworzenie wątku i przekazanie wcześniej stworzonego zadania
        Thread watek = new Thread(activityNotifyingRunnable);
//        watek.setDaemon(true);

        // start wątku
        watek.start();

        Scanner scanner = new Scanner(System.in);

        String command;
        do{
            command = scanner.nextLine();
            System.out.println("Echo: " + command);
            System.out.println("Alive: " + watek.isAlive());
            System.out.println("Daemon: " + watek.isDaemon());

            activityNotifyingRunnable.setJakisTekst(command);
        }while (!command.equalsIgnoreCase("quit"));

//        try {
//            watek.join(); // czekanie na zakończenie wątku
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // to się wydarzy, jeśli ktoś wybudzi nas z czekania na wątek boczny
//        }

        System.out.println("Program exits.");
    }
}
