package com.sda.javagdy4.threading.startPulaWatkow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        ExecutorService pulaWatkow = Executors.newSingleThreadExecutor();
//        - pula składająca się z jednego wątku, który wykonuje krótkie zadania
//        - wątek żyje wiecznie

//        ExecutorService pulaWatkow = Executors.newCachedThreadPool();
//        - pula składająca się ze zmiennej ilości wątków
//        - ilość wątków uzależniona jest od ilości zadań (im więcej zadań, tym więcej wątków startuje pula)
//        - kryterium zabicia wątku jest 60 s nieaktywności

//        ExecutorService pulaWatkow = Executors.newFixedThreadPool(5);
//        - stała ilość wątków (5)
//        - nigdy nie umierają (trzeba uśmiercić pulę żeby zamknąć program)

//        ScheduledExecutorService pulaWatkow = Executors.newScheduledThreadPool(2);
//        - pula wątków = 2
//        - do wykonywania zadań cyklicznych

        ScheduledExecutorService pulaWatkow = Executors.newScheduledThreadPool(1);
        pulaWatkow.scheduleAtFixedRate(() -> {
                    System.out.println("Heloł!");
                },
                2L, // ile na początku czekamy
                1L, // co ile ma się wykonać
                TimeUnit.SECONDS);
    }
}
