package PolyonomialCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model in_model, View in_view){
        view = in_view;
        model = in_model;

        view.addAdditionListener(new AdditionListener());
        view.addSubtractionListener(new SubtractionListener());
        view.addMultiplicationListener(new MultiplicationListener());
        view.addDivisionListener(new DivisionListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegrationListener(new IntegrationListener());
    }

    private void getInput() throws ExceptionIncorrectInput{
        if(!view.getInput1().equals("")){
            if(!view.getInput2().equals("")){
                this.model = new Model(view.getInput1(), view.getInput2());
            }else{
                throw new ExceptionIncorrectInput("2nd polynomial");
            }
        }else{
            throw new ExceptionIncorrectInput("1st polynomial");
        }

    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.addition());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.subtraction());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.multiplication());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.division());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.derivative());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.integration());
            }catch(Exception error){
                error.printStackTrace();
                view.errorMessage(error.getMessage());
            }
        }
    }

}
