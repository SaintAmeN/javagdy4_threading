package com.sda.javagdy4.threading.threadingRace;

public class ZleceniePrzelewu implements Runnable{
    private KontoBankowe kontoBankowe;
    private KierunekPrzelewu kierunekPrzelewu;
    private double kwota;

    public ZleceniePrzelewu(KontoBankowe kontoBankowe, KierunekPrzelewu kierunekPrzelewu, double kwota) {
        this.kontoBankowe = kontoBankowe;
        this.kierunekPrzelewu = kierunekPrzelewu;
        this.kwota = kwota;
    }

    @Override
    public void run() {
        switch (kierunekPrzelewu){
            case WYCHODZACY:
                kontoBankowe.przelewWychodzacy(kwota);
                break;
            case PRZYCHODZACY:
                kontoBankowe.przelewPrzychodzacy(kwota);
                break;
        }
    }
}
