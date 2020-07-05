package com.sda.javagdy4.threading.zad3;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(
                new DirectoryChecker(".", new CheckerNewFiles()),
                0L,
                1L,
                TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(
                new DirectoryChecker(".", new CheckerRemovedFiles()),
                0L,
                1L,
                TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(
                new DirectoryChecker(".", new CheckerModifiedFiles()),
                0L,
                1L,
                TimeUnit.SECONDS);

        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            command = scanner.nextLine();
            System.out.println("Echo: " + command);

        } while (!command.equalsIgnoreCase("quit"));

    }
}
