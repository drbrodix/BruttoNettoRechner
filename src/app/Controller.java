package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private final View view;

    public Controller() {

        this.view = new View(this);

    }

    private double nettoToBrutto(double i) {
        return i + (i * 0.19);
    }

    private double bruttoToNetto(double i) {
        double mwst = i / 119 * 19;
        return i - mwst;
        //return String.format("%.2f", output);
    }

    private String toDecimalFormat(double i) {
        return String.format("%.2f €", i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!view.getInputField().getText().isEmpty()) {
            try{
                if (view.getBruttoNettoRadio().isSelected()) {
                    double inputField = Double.parseDouble(this.view.getInputField().getText().replaceAll(",", "."));
                    double netto = bruttoToNetto(inputField);
                    double mwst = inputField - netto;
                    view.getOutputField().setText(
                            toDecimalFormat(netto)
                    );
                    view.getMwstField().setText(
                            toDecimalFormat(mwst)
                    );
                } else {
                    double inputField = Double.parseDouble(this.view.getInputField().getText().replaceAll(",", "."));
                    double brutto = nettoToBrutto(inputField);
                    double mwst = brutto - inputField;
                    view.getOutputField().setText(
                            toDecimalFormat(brutto)
                    );
                    view.getMwstField().setText(
                            toDecimalFormat(mwst)
                    );
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte nur Zahlen eingeben!", "Ungültige Eingabe", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
