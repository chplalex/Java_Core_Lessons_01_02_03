package lesson0107a;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements ActionListener {

    private JTextField text;
    private JLabel label;

    public Calculator(JTextField text, JLabel label) {
        this.text = text;
        this.label = label;

        text.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        doit();
    }

    private void doit() {
        String s = text.getText();

        Pattern pattern;
        Matcher matcher;

        final String PATTERN = "^(d)(+|-|*|/)(d)$";

        pattern = Pattern.compile(PATTERN);
        matcher = pattern.matcher(s);

    }

}
