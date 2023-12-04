package br.com.escuderodev.vollmed_api.controller.exception;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}