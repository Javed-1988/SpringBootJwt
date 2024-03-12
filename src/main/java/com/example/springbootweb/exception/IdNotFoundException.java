package com.example.springbootweb.exception;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException()
    {
        super();
    }

    public IdNotFoundException(String msg)
    {
        super(msg);
    }
    public String nameNotFound()
    {
        return "name not found";
    }

}
