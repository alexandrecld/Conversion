import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Converter extends JFrame {
    private JTextField rateField;
    private JTextField euroField;
    private JTextField poundField;
    private JTextField rubleField;
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JTextField kmhField;
    private JTextField mphField;

    public Converter() {
        super("Convertisseur");

        // Initialisation des composants de l'interface
        JLabel rateLabel = new JLabel("Taux de change : ");
        rateField = new JTextField("1.07", 10);
        JLabel euroLabel = new JLabel("Euro : ");
        euroField = new JTextField("0", 10);
        JLabel poundLabel = new JLabel("Livre sterling : ");
        poundField = new JTextField("0", 10);
        JLabel rubleLabel = new JLabel("Rouble : ");
        rubleField = new JTextField("0", 10);
        JLabel celsiusLabel = new JLabel("Celsius : ");
        celsiusField = new JTextField("0", 10);
        JLabel fahrenheitLabel = new JLabel("Fahrenheit : ");
        fahrenheitField = new JTextField("0", 10);
        JLabel kmhLabel = new JLabel("Kilomètres/heure : ");
        kmhField = new JTextField("0", 10);
        JLabel mphLabel = new JLabel("Miles/heure : ");
        mphField = new JTextField("0", 10);
        JButton euroPoundButton = new JButton("Euro => Livre Sterling");
        JButton euroRubleButton = new JButton("Euro => Rouble");
        JButton fahrenheitCelsiusButton = new JButton("Fahrenheit => Celsius");
        JButton mphKmhButton = new JButton("Miles/heure => Kilomètres/heure");

        // Ajout des composants à la fenêtre
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(5, 2));
        contentPane.add(rateLabel);
        contentPane.add(rateField);
        contentPane.add(euroLabel);
        contentPane.add(euroField);
        contentPane.add(poundLabel);
        contentPane.add(poundField);
        contentPane.add(rubleLabel);
        contentPane.add(rubleField);
        contentPane.add(euroPoundButton);
        contentPane.add(euroRubleButton);
        contentPane.add(fahrenheitLabel);
        contentPane.add(fahrenheitField);
        contentPane.add(celsiusLabel);
        contentPane.add(celsiusField);
        contentPane.add(fahrenheitCelsiusButton);
        contentPane.add(mphLabel);
        contentPane.add(mphField);
        contentPane.add(kmhLabel);
        contentPane.add(kmhField);
        contentPane.add(mphKmhButton);

        // Gestion de l'événement de clic sur le bouton Euro => Livre Sterling
        euroPoundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double rate = Double.parseDouble(rateField.getText());
                double euro = Double.parseDouble(euroField.getText());
                double pound = rate * euro * 0.86;
                poundField.setText(String.format("%.2f", pound));
            }
        });
        // Gestion de l'événement de clic sur le bouton Euro => Rouble
        euroRubleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double rate = Double.parseDouble(rateField.getText());
                double euro = Double.parseDouble(euroField.getText());
                double ruble = rate * euro * 73.14;
                rubleField.setText(String.format("%.2f", ruble));
            }
        });

        // Gestion de l'événement de clic sur le bouton Fahrenheit => Celsius
        fahrenheitCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusField.setText(String.format("%.2f", celsius));
            }
        });

        // Gestion de l'événement de clic sur le bouton Miles/heure => Kilomètres/heure
        mphKmhButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double mph = Double.parseDouble(mphField.getText());
                double kmh = mph * 1.60934;
                kmhField.setText(String.format("%.2f", kmh));
            }
        });

        // Affichage de la fenêtre
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Lancement de l'application
        new Converter();
    }
}