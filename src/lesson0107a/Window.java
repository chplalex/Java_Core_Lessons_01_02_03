package lesson0107a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window() {
        setBounds(600, 200, 500, 75); // на будущее: сделать расчет координат для размещения в центре
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Simplest Calculator");
        setLayout(new FlowLayout());

        JTextField text = new JTextField();
        text.setColumns(25);
        add(text);

        JLabel label = new JLabel("= ...");
        add(label);

        Calculator calculator = new Calculator(text, label);

        setVisible(true);
    }
}
