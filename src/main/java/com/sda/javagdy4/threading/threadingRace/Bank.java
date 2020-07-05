package com.sda.javagdy4.threading.threadingRace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {
    private KontoBankowe kontoBankowe = new KontoBankowe();
    private ExecutorService pula = Executors.newFixedThreadPool(4);

    public void dodajZleceniePrzelewuWychodzacego(double kwota) {
        ZleceniePrzelewu zleceniePrzelewu = new ZleceniePrzelewu(kontoBankowe, KierunekPrzelewu.WYCHODZACY, kwota);
        pula.submit(zleceniePrzelewu);
    }

    public void dodajZleceniePrzelewuPrzychodzacego(double kwota) {
        ZleceniePrzelewu zleceniePrzelewu = new ZleceniePrzelewu(kontoBankowe, KierunekPrzelewu.PRZYCHODZACY, kwota);
        pula.submit(zleceniePrzelewu);
    }

    public void saldo() {
        kontoBankowe.sprawdzSaldo();
    }
}
