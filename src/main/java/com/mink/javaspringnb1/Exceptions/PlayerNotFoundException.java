package com.mink.javaspringnb1.Exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(int id){
        super("A " + id + " azonosítójú játékos nem található!");
    }
}
