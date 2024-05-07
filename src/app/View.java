package app;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private final JRadioButton bruttoNettoRadio;
    private final JRadioButton nettoBruttoRadio;
    private JTextField inputField;
    private JLabel inputLabel;
    private JTextField mwstField;
    private JTextField outputField;
    private JLabel outputLabel;
    private final JButton btn;

    public View(Controller controller) {

        //Frame Configuration
        getContentPane().setLayout(
                new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
        );
        this.setSize(new Dimension(640, 480));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Brutto-Netto-Rechner");

        //Component Initialization
        //JPanel container = new JPanel();
        bruttoNettoRadio = new JRadioButton();
        nettoBruttoRadio = new JRadioButton();
        inputField = new JTextField();
        mwstField = new JTextField();
        outputField = new JTextField();
        btn = new JButton();

        //Radio Buttons packed into group
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(bruttoNettoRadio);
        btnGroup.add(nettoBruttoRadio);

        //Component Centering
        bruttoNettoRadio.setAlignmentX(Component.CENTER_ALIGNMENT);
        nettoBruttoRadio.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mwstField.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Brutto -> Netto Radio Button Configuration
        bruttoNettoRadio.setText("Brutto -> Netto");
        bruttoNettoRadio.setFont(new Font("SansSerif", Font.PLAIN, 18));
        bruttoNettoRadio.setBorder(null);
        bruttoNettoRadio.setSelected(true);
        bruttoNettoRadio.addActionListener(e -> {
            this.inputLabel.setText("Brutto");
            this.outputLabel.setText("Netto");
            controller.actionPerformed(null);
        });

        //Netto -> Brutto Radio Button Configuration
        nettoBruttoRadio.setText("Netto -> Brutto");
        nettoBruttoRadio.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nettoBruttoRadio.setBorder(null);
        nettoBruttoRadio.addActionListener(e -> {
            this.inputLabel.setText("Netto");
            this.outputLabel.setText("Brutto");
            controller.actionPerformed(null);
        });

        //Input Field Configuration
        JPanel inputPanel = new JPanel();
        inputLabel = new JLabel("Brutto");
        inputLabel.setLabelFor(inputField);
        inputField.setPreferredSize(new Dimension(150, 30));
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        //Mwst Field Configuration
        JPanel mwstPanel = new JPanel();
        JLabel mwstLabel = new JLabel("Mwst");
        mwstLabel.setLabelFor(inputField);
        mwstField.setPreferredSize(new Dimension(150, 30));
        mwstField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        mwstField.setBackground(null);
        mwstField.setEditable(false);
        mwstField.setFocusable(false);
        mwstField.setBorder(null);
        mwstPanel.add(mwstLabel);
        mwstPanel.add(mwstField);


        //Output Field Configuration
        JPanel outputPanel = new JPanel();
        outputLabel = new JLabel("Netto");
        outputLabel.setLabelFor(inputField);
        outputField.setPreferredSize(new Dimension(150, 30));
        outputField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        outputField.setBackground(null);
        outputField.setEditable(false);
        outputField.setFocusable(false);
        outputField.setBorder(null);
        outputPanel.add(outputLabel);
        outputPanel.add(outputField);

        //Button Configuration

        btn.setText("Berechnen");
        btn.setSize(new Dimension(150, 50));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btn.addActionListener(controller);

        //Container JPanel Configuration
        /*container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.blue));
        container.setMaximumSize(new Dimension(640,480));*/

        //Components added to Frame / Panel
        this.add(Box.createVerticalGlue());
        this.add(bruttoNettoRadio);
        this.add(nettoBruttoRadio);
        this.add(Box.createVerticalGlue());
        this.add(inputPanel);
        this.add(Box.createVerticalGlue());
        this.add(mwstPanel);
        this.add(Box.createVerticalGlue());
        this.add(outputPanel);
        this.add(Box.createVerticalGlue());
        this.add(btn);
        this.add(Box.createVerticalGlue());

        this.setVisible(true);

    }

    public JRadioButton getBruttoNettoRadio() {
        return bruttoNettoRadio;
    }

    public JRadioButton getNettoBruttoRadio() {
        return nettoBruttoRadio;
    }

    JTextField getInputField() {
        return inputField;
    }

    JLabel getInputLabel() {
        return inputLabel;
    }

    JTextField getMwstField() {
        return mwstField;
    }

    JTextField getOutputField() {
        return outputField;
    }

    JLabel getOutputLabel() {
        return outputLabel;
    }

}
