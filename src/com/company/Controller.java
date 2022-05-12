package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Filehandler filehandler = new Filehandler();
    Scanner sc = new Scanner(System.in);
    Træner træner = new Træner();
    UI ui = new UI();
    Date date = new Date();


    public void mainMenu() {
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

    public void trænerMenu() {
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

    public void kassérMenu() {
        ui.udskrivKassérMenu();
        String choice = sc.nextLine();
        switch (choice) {
            //case "1"-> restance();
            //case "2" -> indkomst();
            case "0" -> mainMenu();
            default -> ui.invalidInput();
        }
    }


    public void formandMenu() {
        ui.udskrivFormandMenu();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> filehandler.readFile();
            case "2" -> tilføjMedlem();
            //case "3" -> fjernMedlem();
            case "0" -> mainMenu();
            default -> ui.invalidInput();

        }
    }

    public void tilføjMedlem() {
        ui.indtastNavn();
        String name = sc.nextLine();
        ui.indtatsAlder();
        int age = sc.nextInt();
        int medlemsNummer = opretMedlemsnummer();
        filehandler.saveRecords(name, age);
        ui.tilføjMedlem();
        int type = sc.nextInt();
        switch (type) {
            case 1 -> træner.tilføjMedlem(name, age, medlemsNummer);
            case 2 -> træner.tilføjKonkurrence(name, age, medlemsNummer);
            default -> ui.invalidInput();
        }
    }

        public int opretMedlemsnummer () {
            int år = date.getYear();
                år = (år - 100) * 1000;
            //int senesteMedlemsnummer = træner.senesteMedlemsnummer;
            int senesteMedlemsnummer = 1;
            senesteMedlemsnummer++;
            return år + senesteMedlemsnummer;
        }
    }



