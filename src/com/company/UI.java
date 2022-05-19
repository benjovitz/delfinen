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
        "3. Opret ny træningsrekord \n" +
        "4. Tilføj konkrruencetid \n" +
        "5. Se konkurrenceresultater \n" +
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

  public void indtatsÅr() {
    System.out.println("Indtast fødselsår: ");
  }
  public void indtastMåned(){
    System.out.println("Indtast fødselsmåned: ");
  }
  public void indtastDag(){
    System.out.println("Indtast fødselsdag: ");
  }

  public void invalidInput() {
    System.out.println("Din indtastning matchede ingen muligheder");
  }

  public void tilføjMedlem() {
    System.out.println("""
            tilføj medlem
            ---------
            1) motionist
            2) konkurrence
            """);
  }

  public void vælgDisciplin() {
    System.out.println("Vælg disciplin");
    System.out.println("1. Butterfly");
    System.out.println("2. Fri");
    System.out.println("3. Bryst");
    System.out.println("4. Ryg");
  }

  public void indtastTid() {
    System.out.println("Indtast tid: ");
  }

  public void indtastDato() {
    System.out.println("Indtast dato: ");
  }

  public void indtastMedlemsNummer() {
    System.out.println("Indtast medlemsnummer: ");
  }

  public void indtastPlacering() {
    System.out.println("Indtast placering: ");
  }

  public void indtastStævne() {
    System.out.println("Indtast stævne: ");
  }
}
