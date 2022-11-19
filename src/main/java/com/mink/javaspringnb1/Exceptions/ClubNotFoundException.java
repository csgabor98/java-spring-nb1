package com.mink.javaspringnb1.Exceptions;

public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException(int id){
        super("A " + id + " azonosítójú csapat nem található!");
    }
}
