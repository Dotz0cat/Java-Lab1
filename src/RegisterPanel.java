import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterPanel extends JPanel {
    Register register;
    JPanel InputPanel;
    JTextField input;
    PursePanel ChangePanel;

    public class inputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ChangePanel.purse = register.makeChange(49.38);
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

        this.setBackground(Color.green);

        this.setLayout(new GridBagLayout());

        GridBagConstraints inputConstraints = new GridBagConstraints();
        GridBagConstraints inputFieldConstraints = new GridBagConstraints();
        GridBagConstraints changeConstraints = new GridBagConstraints();

        inputConstraints.anchor = GridBagConstraints.PAGE_START;
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.gridy = 0;
        inputConstraints.ipady = 1;
        inputConstraints.weightx = 1.0;
        inputConstraints.weighty = 1.0;

        inputFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputFieldConstraints.weightx = 1.0;
        inputFieldConstraints.weighty = 1.0;

        //changeConstraints.anchor = GridBagConstraints.CENTER;
        changeConstraints.fill = GridBagConstraints.BOTH;
        changeConstraints.gridy = 1;
        changeConstraints.weightx = 1.0;
        changeConstraints.weighty = 1.0;

        this.add(InputPanel, inputConstraints);
        this.InputPanel.setLayout(new GridBagLayout());
        this.InputPanel.setBackground(Color.gray);
        this.InputPanel.add(this.input, inputFieldConstraints);
        this.input.addActionListener(new inputListener());
        this.add(ChangePanel, changeConstraints);
    }
}
