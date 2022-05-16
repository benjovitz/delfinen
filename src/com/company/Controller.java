package com.company;

import java.io.FileNotFoundException;
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

//FEJL I LOOP!
    public void mainMenu() throws FileNotFoundException {
        træner.setSvømmers(filehandler.loadRecords());
        ui.udskrivMainMenu();
        String choice = sc.nextLine();
        boolean kørProgram = true;
        while (kørProgram == true) {
            switch (choice) {
                case "1" -> trænerMenu();
                case "2" -> kassérMenu();
                case "3" -> formandMenu();
                case "0" -> kørProgram = false;
                default -> ui.invalidInput();
            }
        }
    }

    public void trænerMenu() throws FileNotFoundException {
        ui.udskrivTrænerMenu();
        String choice = sc.nextLine();
        switch (choice) {
            //case "1" -> seRekorder();
            case "2" -> filehandler.readFile();
            //case "3" -> opretRekord();
            case "0" -> mainMenu();
            default -> ui.invalidInput();

        }
    }

    public void kassérMenu() throws FileNotFoundException {
        ui.udskrivKassérMenu();
        String choice = sc.nextLine();
        switch (choice) {
            //case "1"-> restance();
            //case "2" -> indkomst();
            case "0" -> mainMenu();
            default -> ui.invalidInput();
        }
    }


    public void formandMenu() throws FileNotFoundException {
        ui.udskrivFormandMenu();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> filehandler.readFile();
            case "2" -> tilføjMedlem();
            //case "3" -> fjernMedlem();'
            case "4"-> filehandler.saveRecords(træner.getArray());
            case "0" -> mainMenu();
            default -> ui.invalidInput();

        }
    }

    public void tilføjMedlem() {
        ui.indtastNavn();
        String name = sc.nextLine();
        ui.indtatsAlder();
        int age = sc.nextInt();
        int medlemsNummer = opretMedlemsnummer(træner.senesteMedlemsnummer());
        ui.tilføjMedlem();
        int type = sc.nextInt();
        switch (type) {
            case 1 -> træner.tilføjMedlem(name, age, medlemsNummer);
            case 2 -> træner.tilføjKonkurrence(name, age, medlemsNummer);
            default -> ui.invalidInput();
        }
    }

        public int opretMedlemsnummer (int senesteMedlemsnummer) {
            int år = date.getYear();
            år = (år - 100) * 1000;
            int nytMedlemsnummer;
            if (senesteMedlemsnummer-år < 0) {
                nytMedlemsnummer = senesteMedlemsnummer - (år - 1000);
            } else {
                nytMedlemsnummer = senesteMedlemsnummer - år;
            };
            nytMedlemsnummer++;
            System.out.println(nytMedlemsnummer + år);
            return år + nytMedlemsnummer;
        }
    }



