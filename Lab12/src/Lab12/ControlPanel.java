package Lab12;

import javax.swing.*;
import java.awt.*;



public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JButton createBtn = new JButton("Create");
    private JTextField nameText = new JTextField("Component text");
    private JTextField className = new JTextField("Class name");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new FlowLayout());

        //add buttons
        add(nameText);

        add(className);
        add(createBtn);

    }

}