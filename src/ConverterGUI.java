import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ConverterGUI extends JFrame implements ActionListener {
    private JTextField currentTextField;
    private JTextField converterTextField;
    private JTextField euroToDollarTextField;
    private JTextField euroToPoundTextField;
    private JTextField euroToRoubleTextField;
    private JButton convertButton;
    private JButton clearButton;
    private JComboBox<String> conversionComboBox;
    private JLabel resultLabel;
    private double euroToDollarRate = 1.07;
    private double euroToPoundRate = 0.85;
    private double euroToRoubleRate = 89.17;

    public static void main(String[] args) {
        ConverterGUI gui = new ConverterGUI();
        gui.setEuroToDollarRate(1.2);
        gui.setEuroToPoundRate(0.9);
        gui.setEuroToRoubleRate(100.0);
    }

    public ConverterGUI() {
        // Titre et taille de l'interface
        setTitle("Convertisseur");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Ajout des éléments à la partie supérieure de l'interface graphique
        JLabel titleLabel = new JLabel("Convertisseur de devises");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(titleLabel);
        container.add(topPanel, BorderLayout.NORTH);

        // Ajout des éléments à la partie centrale de l'interface graphique
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
        JLabel currentLabel = new JLabel("Saisir la valeur à convertir :");
        currentTextField = new JTextField(10);
        JLabel converterLabel = new JLabel("Résultat de la conversion :");
        converterTextField = new JTextField(10);
        converterTextField.setEditable(false);
        centerPanel.add(currentLabel);
        centerPanel.add(currentTextField);
        centerPanel.add(converterLabel);
        centerPanel.add(converterTextField);
        container.add(centerPanel, BorderLayout.CENTER);


        // Ajout des éléments à la partie inférieure de l'interface graphique
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel euroToDollarLabel = new JLabel("1 euro = " + euroToDollarRate + " dollar(s)");
        euroToDollarTextField = new JTextField(10);
        euroToDollarTextField.setEditable(true);
        euroToDollarTextField.addActionListener(this);
        euroToDollarLabel.setLabelFor(euroToDollarTextField);
        bottomPanel.add(euroToDollarLabel);
        bottomPanel.add(euroToDollarTextField);
        JLabel euroToPoundLabel = new JLabel("1 euro = " + euroToPoundRate + " livre(s) sterling(s)");
        euroToPoundTextField = new JTextField(10);
        euroToPoundTextField.setEditable(true);
        euroToPoundTextField.addActionListener(this);
        euroToPoundLabel.setLabelFor(euroToPoundTextField);
        bottomPanel.add(euroToPoundLabel);
        bottomPanel.add(euroToPoundTextField);
        JLabel euroToRoubleLabel = new JLabel("1 euro = " + euroToRoubleRate + " rouble(s) russe(s)");
        euroToRoubleTextField = new JTextField(10);
        euroToRoubleTextField.setEditable(true);
        euroToRoubleTextField.addActionListener(this);
        euroToRoubleLabel.setLabelFor(euroToRoubleTextField);
        bottomPanel.add(euroToRoubleLabel);
        bottomPanel.add(euroToRoubleTextField);
        container.add(bottomPanel, BorderLayout.SOUTH);

        // Ajout des éléments à la partie droite de l'interface graphique
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4, 1, 10, 10));
        conversionComboBox = new JComboBox<>(new String[]{
                "Euros -> Dollars",
                "Euros -> Livres sterling",
                "Euros -> Roubles",
                "Fahrenheit -> Celsius",
                "Miles -> Kilomètres"
        });
        conversionComboBox.addActionListener(this);
        convertButton = new JButton("Convertir");
        convertButton.addActionListener(this);
        clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        rightPanel.add(conversionComboBox);
        rightPanel.add(convertButton);
        rightPanel.add(clearButton);
        container.add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(), conversionComboBox)) {
            switch (conversionComboBox.getSelectedIndex()) {
                case 0 -> euroToDollarTextField.setText(String.valueOf(euroToDollarRate));
                case 1 -> euroToPoundTextField.setText(String.valueOf(euroToPoundRate));
                case 2 -> euroToRoubleTextField.setText(String.valueOf(euroToRoubleRate));
                case 3 -> {
                    currentTextField.setText("");
                    converterTextField.setText("");
                }
                default -> {
                }
            }
        } else if (Objects.equals(e.getSource(), convertButton)) {
            try {
                double current = Double.parseDouble(currentTextField.getText());
                double milesToKilometersRate = 1.61;
                double fahrenheitToCelsiusRate = 5.0 / 9.0;
                switch (conversionComboBox.getSelectedIndex()) {
                    case 0 -> converterTextField.setText(String.valueOf(current * euroToDollarRate));
                    case 1 -> converterTextField.setText(String.valueOf(current * euroToPoundRate));
                    case 2 -> converterTextField.setText(String.valueOf(current * euroToRoubleRate));
                    case 3 -> converterTextField.setText(String.valueOf((current - 32.0) * fahrenheitToCelsiusRate));
                    case 4 -> converterTextField.setText(String.valueOf(current * milesToKilometersRate));
                    default -> {
                    }
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "La valeur saisie est incorrecte.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else if (Objects.equals(e.getSource(), clearButton)) {
            currentTextField.setText("");
            converterTextField.setText("");
            euroToDollarTextField.setText("");
            euroToPoundTextField.setText("");
            euroToRoubleTextField.setText("");
        }
    }

    // Méthode pour modifier le taux de change du dollar
    public void setEuroToDollarRate(double rate) {
        euroToDollarRate = rate;
        euroToDollarTextField.setText(String.valueOf(euroToDollarRate));
    }

    // Méthode pour modifier le taux de change de la livre sterling
    public void setEuroToPoundRate(double rate) {
        euroToPoundRate = rate;
        euroToPoundTextField.setText(String.valueOf(euroToPoundRate));
    }

    // Méthode pour modifier le taux de change du rouble russe
    public void setEuroToRoubleRate(double rate) {
        euroToRoubleRate = rate;
        euroToRoubleTextField.setText(String.valueOf(euroToRoubleRate));
    }

}
