import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterPanel extends JPanel {
    Register register;
    JPanel InputPanel;
    JTextField input;
    PursePanel ChangePanel;

    JLabel label;

    public class inputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = input.getText();
            double amt = 0.0;
            try {
                amt = Double.parseDouble(text);
                label.setText(text);
            }
            catch (Exception ex) {
                label.setText("Invalid Number");
            }
            ChangePanel.purse = register.makeChange(amt);
            ChangePanel.paintComponent(ChangePanel.getGraphics());
            return;
        }
    }

    public RegisterPanel() {
        super();

        this.InputPanel = new JPanel();
        this.input = new JTextField();
        this.ChangePanel = new PursePanel();
        this.register = new Register();

        this.label = new JLabel("Enter A number to make change", SwingConstants.CENTER);
        this.label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));

        this.setBackground(Color.green);

        this.setLayout(new GridBagLayout());

        GridBagConstraints inputConstraints = new GridBagConstraints();
        GridBagConstraints inputFieldConstraints = new GridBagConstraints();
        GridBagConstraints labelConstraints = new GridBagConstraints();
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

        changeConstraints.anchor = GridBagConstraints.PAGE_START;
        changeConstraints.fill = GridBagConstraints.BOTH;
        changeConstraints.gridy = 2;
        changeConstraints.gridheight = 3;
        changeConstraints.weightx = 1.0;
        changeConstraints.weighty = 1.0;

        this.add(InputPanel, inputConstraints);
        this.InputPanel.setLayout(new GridBagLayout());
        this.InputPanel.setBackground(Color.gray);
        this.InputPanel.add(this.input, inputFieldConstraints);
        this.input.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        this.input.addActionListener(new inputListener());
        this.add(label, labelConstraints);
        this.add(ChangePanel, changeConstraints);
    }
}
