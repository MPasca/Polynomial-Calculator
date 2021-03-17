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

    private void getInput(){
        this.model = new Model(view.getInput1(), view.getInput2());
    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.addition());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: input1: '" + view.getInput1() + "; input2: " + view.getInput2() + "'");
            }
        }
    }

    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.subtraction());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: input1: '" + view.getInput1() + "; input2: " + view.getInput2() + "'");
            }
        }
    }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.multiplication());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: input1: '" + view.getInput1() + "; input2: " + view.getInput2() + "'");
            }
        }
    }

    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.division());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: input1: '" + view.getInput1() + "; input2: " + view.getInput2() + "'");
            }
        }
    }

    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.derivative());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + view.getInput1() + "'");
            }
        }
    }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getInput();
                view.setTxtOutput(model.integration());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + view.getInput1() + "'");
            }
        }
    }

}
