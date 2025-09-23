package br.com.movieflix.exeption;

public class UserNameOrPassordInvalidException extends RuntimeException{

    public UserNameOrPassordInvalidException(String message) {
        super(message);
    }
}
