package com.company;

public class Junior extends Svømmer {
    public Junior(String name,int år,int måned,int dag, int medlemsNummer){
        super(name, år,måned,dag, medlemsNummer);
        kontingent=1000;
    }
}
