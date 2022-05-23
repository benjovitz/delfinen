package com.company;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    private Filehandler filehandler = new Filehandler();
    private Scanner sc = new Scanner(System.in);
    private Træner træner = new Træner();
    private UI ui = new UI();
    private Date date = new Date();
    private NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.getDefault());

    boolean programKører = true;

    public void program() throws FileNotFoundException {
        træner.setSvømmers(filehandler.loadRecords());
        træner.setKonkurrenceTider(filehandler.loadKonkurrenctider());

        while (programKører) {
            ui.udskrivMainMenu();
            String choice = sc.nextLine();
            mainMenu(choice);
        }
    }

    public void mainMenu(String choice) throws FileNotFoundException {
        switch (choice) {
            case "1" -> trænerMenu();
            case "2" -> kassérMenu();
            case "3" -> formandMenu();
            case "0" -> programKører = false;
            default -> ui.invalidInput();
        }
    }

    public void trænerMenu() throws FileNotFoundException {
        boolean trænerBoo = true;
        while (trænerBoo) {
            ui.udskrivTrænerMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> seRekorder();
                case "2" -> filehandler.readFile();
                case "3" -> opretRekord();
                case "4" -> opretKonkurrencetid();
                case "5" -> System.out.println(træner.getKonkurrenceTider());
                case "0" -> trænerBoo = false;
                default -> ui.invalidInput();
            }
        }
    }

    private void seRekorder() {
        //Disciplin tmp = vælgDisciplin();
        træner.findRekorder();

    }

    private void opretRekord() throws FileNotFoundException {
        ui.indtastMedlemsNummer();
        int medlem = readInteger();
        Konkurrence svømmer = (Konkurrence) træner.findSvømmer(medlem);
        if (svømmer != null) {
            ui.indtastTid();
            double tid = readDouble();
            String scannerbug = sc.nextLine();
            ui.indtastDato();
            String dato = sc.nextLine();
            træner.nyRekord(svømmer, tid, dato);
        }
        filehandler.saveRecords(træner.getArray());
    }

    public void kassérMenu() throws FileNotFoundException {
        boolean kassérBoo = true;
        while (kassérBoo == true) {
            ui.udskrivKassérMenu();
            String choice = sc.nextLine();
            switch (choice) {
                //case "1"-> restance();
                case "2" -> indkomst();
                case "0" -> kassérBoo = false;
                default -> ui.invalidInput();
            }
        }
    }

    public void indkomst() {
        int samletIndkomst = 0;
        for (Svømmer svømmer : træner.getArray()) {
            int år = svømmer.getÅr();
            int måned = svømmer.getMåned();
            int dag = svømmer.getDag();
            boolean erAktiv = svømmer.getErAktiv();
            int alder = træner.udregnAlder(år, måned, dag);
            samletIndkomst += træner.udregnkontingent(alder, erAktiv);

        }
        System.out.println(fmt.format(samletIndkomst));
    }
    public int indkomst2() {
        int samletIndkomst = 0;
        for (Svømmer svømmer : træner.getArray()) {
            int år = svømmer.getÅr();
            int måned = svømmer.getMåned();
            int dag = svømmer.getDag();
            boolean erAktiv = svømmer.getErAktiv();
            int alder = træner.udregnAlder(år, måned, dag);
            samletIndkomst += træner.udregnkontingent(alder, erAktiv);

        }
        return samletIndkomst;
    }

    public void formandMenu() throws FileNotFoundException {
        boolean formandBoo = true;
        while (formandBoo) {
            ui.udskrivFormandMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> filehandler.readFile();
                case "2" -> tilføjMedlem();
                case "3" -> fjernMedlem();
                case "4" -> redigerMedlem();
                case "0" -> formandBoo = false;
                default -> ui.invalidInput();
            }
        }
    }

    private void fjernMedlem() throws FileNotFoundException {
        ui.indtastMedlemsNummer();
        int medlemsNummer = sc.nextInt();
        Svømmer svømmer = træner.findSvømmer(medlemsNummer);
        træner.fjernMedlem(svømmer);
        filehandler.saveRecords(træner.getArray());
    }

    public void tilføjMedlem() throws FileNotFoundException {
        ui.indtastNavn();
        String name = sc.nextLine();
        ui.indtatsÅr();
        int år = readInteger();
        ui.indtastMåned();
        int måned = readInteger();
        ui.indtastDag();
        int dag = readInteger();
        int medlemsNummer = opretMedlemsnummer(træner.senesteMedlemsnummer());
        ui.tilføjMedlem();
        int type = readInteger();
        String scannerBug = sc.nextLine();
        switch (type) {
            case 1 -> træner.tilføjMedlem(name, år, måned, dag, medlemsNummer);
            case 2 -> {
                Disciplin disciplin = vælgDisciplin();
                træner.tilføjKonkurrence(name, år, måned, dag, medlemsNummer, disciplin);
            }

            default -> ui.invalidInput();
        }
        filehandler.saveRecords(træner.getArray());
    }

    private Disciplin vælgDisciplin() {
        ui.vælgDisciplin();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> {
                return Disciplin.BUTTERFLY;
            }
            case "2" -> {
                return Disciplin.FRI;
            }
            case "3" -> {
                return Disciplin.BRYST;
            }
            case "4" -> {
                return Disciplin.RYG;
            }
            default -> ui.invalidInput();
        }
        return null;
    }

    public int opretMedlemsnummer(int senesteMedlemsnummer) {
        int år = date.getYear();
        år = (år - 100) * 1000;
        int nytMedlemsnummer;
        if (senesteMedlemsnummer == 0) {
            nytMedlemsnummer = 0;
        } else if (senesteMedlemsnummer - år < 0) {
            nytMedlemsnummer = senesteMedlemsnummer - (år - 1000);
        } else {
            nytMedlemsnummer = senesteMedlemsnummer - år;
        }
        nytMedlemsnummer++;
        return år + nytMedlemsnummer;
    }

    public int readInteger() {
        while (!sc.hasNextInt()) {
            String text = sc.next();
            ui.invalidInput();
        }
        return sc.nextInt();
    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {
            String text = sc.next();
            ui.invalidInput();
        }
        return sc.nextDouble();
    }

    public void opretKonkurrencetid() throws FileNotFoundException {
        ui.indtastTid();
        double tid = readDouble();
        ui.indtastPlacering();
        int placering = readInteger();
        ui.indtastStævne();
        String stævne = sc.nextLine();
        stævne = sc.nextLine();
        ui.indtastMedlemsNummer();
        int medlemsnummer = readInteger();
        Konkurrence konkurrence = (Konkurrence)træner.findSvømmer(medlemsnummer);
        Disciplin disciplin = konkurrence.getDisciplin();
        træner.tilføjKonkurrencetid(tid, placering, stævne, medlemsnummer,disciplin);
        sc.nextLine();
        filehandler.saveKonkurrencetider(træner.getKonkurrenceTider());
    }

    public void redigerMedlem() throws FileNotFoundException {
        ui.indtastMedlemsNummer();
        int medlem = readInteger();
        Svømmer svømmer = træner.findSvømmer(medlem);
        String scannerBug = sc.nextLine();
        if (svømmer != null) {
            ui.indtastNavn();
            String name = sc.nextLine();
            svømmer.setName(name);
        }
        filehandler.saveRecords(træner.getArray());

    }
}




