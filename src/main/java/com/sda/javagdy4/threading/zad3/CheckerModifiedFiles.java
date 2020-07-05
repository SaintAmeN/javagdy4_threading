package com.sda.javagdy4.threading.zad3;

import java.io.File;
import java.util.*;

public class CheckerModifiedFiles implements ICheckOperation {

    private Map<File, Long> fileSizeMap = new HashMap<>();

    @Override
    public boolean check(String dir) {
        File folder = new File(dir);
        File[] tablica = folder.listFiles();

        List<File> currentState = new ArrayList<>(Arrays.asList(tablica));

        boolean zmiana = false;
        for (File file : currentState) {
            if(fileSizeMap.containsKey(file)){
                if(fileSizeMap.get(file) != file.length()){
                    System.out.println("Plik: " + file + " uległ zmianie.");
                    zmiana = true;
                }
            }
        }

        fileSizeMap.clear();
        for (File file : currentState) {
            fileSizeMap.put(file, file.length());
        }

        return zmiana;
    }
}
