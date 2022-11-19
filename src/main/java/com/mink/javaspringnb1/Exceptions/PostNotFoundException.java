package com.mink.javaspringnb1.Exceptions;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(int id){
        super("A " + id + " azonosítójú poszt nem található!");
    }
}
