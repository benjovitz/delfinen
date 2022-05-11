package com.company;

import java.util.Scanner;

public class Controller {
    private Scanner sc = new Scanner(System.in);
    private Træner træner = new Træner();

    public void mainMenu() {
        System.out.println("mainMenu");
        //ui.mainMenu
        String choice = sc.nextLine();
        boolean kørPogram = true;
        while (kørPogram == true) {
            switch (choice) {
                case "1" -> trænerMenu();
                case "2" -> kassérMenu();
                case "3" -> formandMenu();
                case "0" -> kørPogram = false;
                //default -> ui.invalidInput
            }
        }
    }

    public void trænerMenu() {
        System.out.println("træner menu");
        //ui.trænerMenu
        String choice = sc.nextLine();
        switch (choice) {
            //case "1" -> seRekorder();
            case "2" -> træner.viewArray();
            //case "0" -> mainMenu();
            //default -> ui.invalidInput();
        }
    }

    public void kassérMenu() {
        System.out.println("kasser manu");
        //ui.kassérMenu
        String choice = sc.nextLine();
        switch (choice) {
            //case "1"-> restance();
            //case "2" -> indkomst();
            //case "0" -> mainMenu();
            //default -> ui.invalidInput();
        }
    }


    public void formandMenu() {
        System.out.println("formand menu");
        //ui.formandMenu
        String choice = sc.nextLine();
        switch (choice) {
            //case "1" -> medlemsliste();
            case "2" -> tilføjMedlem();
            //case "3" -> fjernMedlem();
            case "0" -> mainMenu();


        }
    }

    private void tilføjMedlem() {
        System.out.print("navn: ");
        String name = sc.nextLine();
        System.out.print("alder: ");
        int age =  sc.nextInt();
        int medlemsNummer = 1;

        System.out.println("""
                tilføj medlem
                ---------
                1) motionist
                2) konkurrence
                """);
        int type = sc.nextInt();
        switch (type){
            case 1 -> træner.tilføjMedlem(name,age,medlemsNummer);
            case 2 -> træner.tilføjKonkurrence(name,age,medlemsNummer);
            //default -> ui.invalidInput();
        }


        }
    }

