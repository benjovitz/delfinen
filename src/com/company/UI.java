package com.company;

public class UI {

  public void udskrivMainMenu() {
    System.out.printf("Hvilken menu ønsker du at tilgå? \n" +
        "1. Træner \n" +
        "2. Kassér \n" +
        "3. Formand \n" +
        "0. Exit \n");
  }

  public void udskrivTrænerMenu() {
    System.out.printf("Indtast valg: \n" +
        "1. Rekorder \n" +
        "2. Liste over svømmere \n" +
        "3. Opret ny rekord \n" +
        "0. Main menu \n");
  }

  public void udskrivKassérMenu() {
    System.out.printf("Indtast valg: \n" +
        "1. Restance \n" +
        "2. Indkomst \n" +
        "0. Main menu \n");
  }

  public void udskrivFormandMenu() {
    System.out.printf("Indtast valg: \n" +
        "1. Medlemsliste \n" +
        "2. Opret nyt medlem \n" +
        "3. Fjern medlem \n" +
        "0. Main menu \n");
  }

  public void indtastNavn() {
    System.out.println("Indtast navn: ");
  }

  public void indtatsAlder() {
    System.out.println("Indtast alder: ");
  }

  public void invalidInput() {
    System.out.println("Din indtastning matchede ingen muligheder");
  }
}
