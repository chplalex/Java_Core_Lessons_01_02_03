package lesson0108;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {

     public StartFrame() throws HeadlessException {

        StartForm startForm = new StartForm();
        JComponent startPanel = startForm.$$$getRootComponent$$$();
        setContentPane(startPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("X / O Game");
        pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        setResizable(false);
        setVisible(true);
    }
}
