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

  boolean programKører = true;

  public void program() throws FileNotFoundException {
    træner.setSvømmers(filehandler.loadRecords());

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
        //case "1" -> seRekorder();
        case "2" -> filehandler.readFile();
        //case "3" -> opretRekord();
        case "0" -> trænerBoo = false;
        default -> ui.invalidInput();
      }
    }
  }

  public void kassérMenu() throws FileNotFoundException {
    boolean kassérBoo = true;
    while (kassérBoo == true) {
      ui.udskrivKassérMenu();
      String choice = sc.nextLine();
      switch (choice) {
        //case "1"-> restance();
        //case "2" -> indkomst();
        case "0" -> kassérBoo = false;
        default -> ui.invalidInput();
      }
    }
  }


  public void formandMenu() throws FileNotFoundException {
    boolean formandBoo = true;
    while (formandBoo) {
      ui.udskrivFormandMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> filehandler.readFile();
        case "2" -> tilføjMedlem();
        //case "3" -> fjernMedlem();'
        case "4" -> filehandler.saveRecords(træner.getArray());
        case "0" -> formandBoo = false;
        default -> ui.invalidInput();
      }
    }
  }

  public void tilføjMedlem() {
    ui.indtastNavn();
    String name = sc.nextLine();
    ui.indtatsÅr();
    int år = sc.nextInt();
    ui.indtastMåned();
    int måned = sc.nextInt();
    ui.indtastDag();
    int dag = sc.nextInt();
    int medlemsNummer = opretMedlemsnummer(træner.senesteMedlemsnummer());
    ui.tilføjMedlem();
    int type = sc.nextInt();
    String scannerBug = sc.nextLine();
    switch (type) {
      case 1 -> træner.tilføjMedlem(name,år,måned,dag, medlemsNummer);
      case 2 -> træner.tilføjKonkurrence(name, age, medlemsNummer);
      default -> ui.invalidInput();
    }
  }

  public int opretMedlemsnummer(int senesteMedlemsnummer) {
    int år = date.getYear();
    år = (år - 100) * 1000;
    int nytMedlemsnummer;
    if (senesteMedlemsnummer - år < 0) {
      nytMedlemsnummer = senesteMedlemsnummer - (år - 1000);
    } else {
      nytMedlemsnummer = senesteMedlemsnummer - år;
    }
    ;
    nytMedlemsnummer++;
    return år + nytMedlemsnummer;
  }
}



