package com.company;

import java.util.Scanner;

public class Controller {
    private Scanner sc;



    public void trænerMenu(){
        String recieved = sc.nextLine();
        switch (recieved){
            //case "1" -> seRekorder();
            //case "2" -> seKonkurenceMedlemmer();
            //case "3" -> mainMenu();


        }
    }

    public void kassérMenu(){
        String answer = sc.nextLine();
        switch (answer){
            default -> System.out.println("invalid input");
            //case "1"-> restance();
            //case "2" -> indkomst();
            //case "0" -> mainMenu();
        }
    }

    public void formandMenu() {
        String choice = sc.nextLine();
        /*switch (choice) {
            case "1" -> medlemsliste();
            case "2" -> tilføjMedlem();
            case "3" -> fjernMedlem();
            default -> ui.invalidInput();
         */
        }
    }
