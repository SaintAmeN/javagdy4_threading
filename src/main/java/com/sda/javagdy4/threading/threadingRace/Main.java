package com.sda.javagdy4.threading.threadingRace;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                bank.dodajZleceniePrzelewuPrzychodzacego(10);
            } else {
                bank.dodajZleceniePrzelewuWychodzacego(10);
            }
        }

        Scanner scanner = new Scanner(System.in);
        String command;
        do{
            System.out.println("Komenda:");
            command = scanner.nextLine();
            if(command.startsWith("saldo")){
                bank.saldo();
            }
        }while (!command.equalsIgnoreCase("quit"));
    }
}
