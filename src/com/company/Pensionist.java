package com.company;

public class Pensionist extends Svømmer {

    public Pensionist(String name,int age, int medlemsNummer){
        super(name, age, medlemsNummer);
        kontingent=1200;
    }
}
