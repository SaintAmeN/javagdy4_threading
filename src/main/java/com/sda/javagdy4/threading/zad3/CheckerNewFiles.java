package com.sda.javagdy4.threading.zad3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckerNewFiles implements ICheckOperation {

    private List<File> fileList = new ArrayList<>();

    @Override
    public boolean check(String dir) {
        File folder = new File(dir);
        File[] tablica = folder.listFiles();

        List<File> currentState = new ArrayList<>(Arrays.asList(tablica));

        List<File> copyCurrentState = new ArrayList<>(currentState);
        currentState.removeAll(fileList);

        fileList = copyCurrentState;
        if (currentState.size() > 0) {
            // pojawiło się coś nowego.
            System.out.println("Nowe pliki: " + currentState);
            return true;
        }
        return false;
    }
}
