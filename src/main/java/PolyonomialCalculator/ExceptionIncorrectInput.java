package PolyonomialCalculator;

public class ExceptionIncorrectInput extends Exception {
    public ExceptionIncorrectInput(String msg){
        super("Incorrect output: " + msg);
    }
}
