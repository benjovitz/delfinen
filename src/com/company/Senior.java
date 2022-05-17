package com.company;

public class Senior extends Svømmer {

    public Senior(String name,int år,int måned,int dag, int medlemsNummer){
        super(name,år,måned,dag,medlemsNummer);
        kontingent=1600;
    }
}
