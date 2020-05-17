package Lab12;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

    ControlPanel controlPanel=new ControlPanel(this);;
    DesignPanel desingPanel=new DesignPanel(this);

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //components
        add(controlPanel, BorderLayout.NORTH);
        add(desingPanel, BorderLayout.CENTER);

        pack();
    }
}