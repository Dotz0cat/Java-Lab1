import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel InputPanel;
    private JTextField input;
    private PursePanel ChangePanel;

    private static Map<String, ChangeMaker> methods;

    static {
        methods = Map.of(
                "Least Change", new LeastChange(),
                "Randomized Change", new RandomizedChange(),
                "All Coins", new AllCoins()
        );
    }

    private JComboBox<String> changeMethod;

    private JLabel label;

    public class inputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //get text from text field then redraw gui
            String text = input.getText();
            double amt = 0.0;
            try {
                amt = Double.parseDouble(text);
                label.setText(text);
            }
            catch (Exception ex) {
                label.setText("Invalid Number");
            }
            ChangePanel.setPurse(register.makeChange(amt));
            ChangePanel.repaint();
            ChangePanel.revalidate();
            return;
        }
    }

    public RegisterPanel() {
        super();

        //make the objects
        this.InputPanel = new JPanel();
        this.input = new JTextField();
        this.ChangePanel = new PursePanel();
        this.register = new Register();
        this.changeMethod = new JComboBox<>(methods.keySet().toArray(new String[0]));

        this.label = new JLabel("Enter A number to make change", SwingConstants.CENTER);
        this.label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));

        this.setBackground(Color.green);

        //a very good but verbose layout style
        this.setLayout(new GridBagLayout());

        GridBagConstraints inputConstraints = new GridBagConstraints();
        GridBagConstraints inputFieldConstraints = new GridBagConstraints();
        GridBagConstraints labelConstraints = new GridBagConstraints();
        GridBagConstraints changeMethodConstraints = new GridBagConstraints();
        GridBagConstraints changeConstraints = new GridBagConstraints();

        inputConstraints.anchor = GridBagConstraints.PAGE_START;
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.gridy = 0;
        inputConstraints.weightx = 1.0;
        inputConstraints.weighty = 0.0;

        inputFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputFieldConstraints.weightx = 1.0;
        inputFieldConstraints.weighty = 1.0;

        labelConstraints.anchor = GridBagConstraints.PAGE_START;
        labelConstraints.gridy = 1;
        labelConstraints.fill = GridBagConstraints.HORIZONTAL;
        labelConstraints.weightx = 1.0;
        labelConstraints.weighty = 0.0;

        changeMethodConstraints.anchor = GridBagConstraints.PAGE_START;
        changeMethodConstraints.gridy = 2;
        changeMethodConstraints.fill = GridBagConstraints.HORIZONTAL;
        changeMethodConstraints.weightx = 1.0;
        changeMethodConstraints.weighty = 0.0;

        changeConstraints.anchor = GridBagConstraints.PAGE_START;
        changeConstraints.fill = GridBagConstraints.BOTH;
        changeConstraints.gridy = 3;
        changeConstraints.gridheight = 3;
        changeConstraints.weightx = 1.0;
        changeConstraints.weighty = 1.0;

        //add the objects to the jpanel and set options
        this.add(InputPanel, inputConstraints);
        this.InputPanel.setLayout(new GridBagLayout());
        this.InputPanel.setBackground(Color.gray);
        this.InputPanel.add(this.input, inputFieldConstraints);
        this.input.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        this.input.addActionListener(new inputListener());
        this.add(label, labelConstraints);
        this.add(changeMethod, changeMethodConstraints);
        this.add(ChangePanel, changeConstraints);

        this.changeMethod.addActionListener(_ -> {
            if (methods.containsKey(changeMethod.getSelectedItem())) {
                register.setMethod(methods.get(changeMethod.getSelectedItem()));
            }
        });

        this.register.setMethod(methods.get(changeMethod.getSelectedItem()));
    }
}
