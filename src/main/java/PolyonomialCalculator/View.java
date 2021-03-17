// this is only for the user interface
// the appearance

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame{
    JFrame frame = new JFrame("Polynomial Calculator");

    JPanel panelInput1 = new JPanel(new FlowLayout());                     // the first panel contains a label and the first textfield
    JLabel lblInput1 = new JLabel("Insert first Polynomial: ");       // where the user is going to write the first polynomial
    JTextField txtInput1 = new JTextField(15);

    JPanel panelInput2 = new JPanel(new FlowLayout());                     // same as before
    JLabel lblInput2 = new JLabel("Insert second Polynomial: ");
    JTextField txtInput2 = new JTextField(15);

    JPanel panelInput = new JPanel();

    JPanel panelBaseOperations = new JPanel();

    JButton btnAdd = new JButton("+");
    JButton btnSub = new JButton("-");
    JButton btnMul = new JButton("*");
    JButton btnDiv = new JButton("/");
    JButton btnDeriv = new JButton("Derivative");
    JButton btnIntegr = new JButton("Integration");

    JPanel panelOperations = new JPanel();

    JPanel panelOutput = new JPanel(new FlowLayout());

    JLabel lblOutput = new JLabel("Result: ");
    JLabel lblShowOutput = new JLabel();

    JSeparator separator = new JSeparator();
    JPanel mainPanel = new JPanel();

    public View(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 200);

        // ------------------------------------- INPUT PANEL

        panelInput1.setBackground(Color.decode("#191919"));
        lblInput1.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblInput1.setForeground(Color.decode("#f9d43d"));
        panelInput1.add(lblInput1);
        panelInput1.add(txtInput1);

        panelInput2.setBackground(Color.decode("#191919"));
        lblInput2.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblInput2.setForeground(Color.decode("#f9d43d"));
        panelInput2.add(lblInput2);
        panelInput2.add(txtInput2);

        panelInput.add(panelInput1);
        panelInput.add(panelInput2);

        // -------------------------------------------------

        // ------------------------------------- BUTTONS PANEL

        panelBaseOperations.setBackground(Color.decode("#191919"));

        btnAdd.setBackground(Color.decode("#e09b2b"));
        btnAdd.setFont(new Font("Open Sans", Font.BOLD, 20));

        btnSub.setBackground(Color.decode("#e09b2b"));
        btnSub.setFont(new Font("Open Sans", Font.BOLD, 20));

        btnMul.setBackground(Color.decode("#e09b2b"));
        btnMul.setFont(new Font("Open Sans", Font.BOLD, 20));

        btnDiv.setBackground(Color.decode("#e09b2b"));
        btnDiv.setFont(new Font("Open Sans", Font.BOLD, 20));

        btnDeriv.setBackground(Color.decode("#f9d43d"));
        btnDeriv.setFont(new Font("Open Sans", Font.BOLD, 12));

        btnIntegr.setBackground(Color.decode("#f9d43d"));
        btnIntegr.setFont(new Font("Open Sans", Font.BOLD, 12));

        panelBaseOperations.add(btnAdd);
        panelBaseOperations.add(btnSub);
        panelBaseOperations.add(btnDeriv);

        panelBaseOperations.add(btnMul);
        panelBaseOperations.add(btnDiv);
        panelBaseOperations.add(btnIntegr);

        panelBaseOperations.setLayout(new GridLayout(2, 2));

        panelOperations.add(panelBaseOperations);

        panelOperations.setLayout(new BoxLayout(panelOperations, BoxLayout.Y_AXIS));

        // -------------------------------------------------

        // ------------------------------------- RESULT PANEL

        panelOutput.setBackground(Color.decode("#191919"));

        lblOutput.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblOutput.setForeground(Color.decode("#f9d43d"));
        lblShowOutput.setFont(new Font("Open Sans", Font.BOLD, 18));
        lblShowOutput.setForeground(Color.decode("#e09b2b"));

        panelOutput.add(lblOutput);
        panelOutput.add(lblShowOutput);

        // -------------------------------------------------


        mainPanel.add(panelInput);
        mainPanel.add(separator);
        mainPanel.add(panelOperations);
        mainPanel.add(separator);
        mainPanel.add(panelOutput);

        mainPanel.setBackground(Color.decode("#191919"));
        frame.setContentPane(mainPanel);
        frame.setVisible(true);

    }

    public String getInput1() {
        return txtInput1.getText();
    }

    public String getInput2() {
        return txtInput2.getText();
    }

    public void setTxtOutput(String output) {
        this.lblShowOutput.setText(output);
    }

    // ------------------------------------- ADD BUTTON LISTENERS

    public void addAdditionListener(ActionListener actionListener){
        btnAdd.addActionListener(actionListener);
    }

    public void addSubtractionListener(ActionListener actionListener){
        btnSub.addActionListener(actionListener);
    }

    public void addMultiplicationListener(ActionListener actionListener){
        btnMul.addActionListener(actionListener);
    }

    public void addDivisionListener(ActionListener actionListener){
        btnDiv.addActionListener(actionListener);
    }

    public void addDerivativeListener(ActionListener actionListener){
        btnDeriv.addActionListener(actionListener);
    }

    public void addIntegrationListener(ActionListener actionListener){
        btnIntegr.addActionListener(actionListener);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage, "Inane error", JOptionPane.ERROR_MESSAGE);
    }

}
