package com.sda.javagdy4.threading.zad3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckerRemovedFiles implements ICheckOperation {

    private List<File> fileList = new ArrayList<>();

    @Override
    public boolean check(String dir) {
        File folder = new File(dir);
        File[] tablica = folder.listFiles();

        List<File> currentState = new ArrayList<>(Arrays.asList(tablica));

        List<File> copyCurrentState = new ArrayList<>(currentState);
        fileList.removeAll(currentState);

        if (fileList.size() > 0) {
            // pojawiło się coś nowego.
            System.out.println("Usunięte pliki: " + fileList);
            fileList = copyCurrentState;
            return true;
        }
        fileList = copyCurrentState;
        return false;
    }
}
