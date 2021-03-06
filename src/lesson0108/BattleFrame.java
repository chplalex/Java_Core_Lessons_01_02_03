package lesson0108;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

import static lesson0108.MainApp.startFrame;

public class BattleFrame extends JFrame {

    private BattleMap battleMap;

    public BattleFrame(int playerRight, String nameLeft, String nameRight, int fieldSize, int winLine)
            throws HeadlessException {

        startFrame.setVisible(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("X / O Game");

        setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));

        final JLabel labelLeft = new JLabel(nameLeft);
        labelLeft.setHorizontalAlignment(0);
        labelLeft.setBorder(BorderFactory.createLineBorder(Color.red));
        add(labelLeft, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final JSeparator separator4 = new JSeparator();
        separator4.setOrientation(1);
        add(separator4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        final JLabel labelRight = new JLabel(nameRight);
        labelRight.setHorizontalAlignment(0);
        add(labelRight, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final JLabel labelStatus = new JLabel("Move of " + nameLeft + " is expected");
        labelStatus.setHorizontalAlignment(0);
        add(labelStatus, new GridConstraints(5, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final JSeparator separator1 = new JSeparator();
        add(separator1, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        battleMap = new BattleMap(playerRight, fieldSize, winLine, labelLeft, labelRight, labelStatus);
        battleMap.setBackground(new Color(-855310));
        add(battleMap, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(400, 400), null, 0, false));

        final JSeparator separator2 = new JSeparator();
        add(separator2, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        final JSeparator separator3 = new JSeparator();
        add(separator3, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void dispose() {
        startFrame.setVisible(true);
        super.dispose();
    }
}
