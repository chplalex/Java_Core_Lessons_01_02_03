package lesson0108;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class BattleMap extends JPanel implements Constants {
    int fieldSize, winSize;
    JLabel labelLeft, labelRight, labelStatus;
    int playerRight;
    int countMove;
    int dot = DOT_PLAYER_LEFT;
    boolean gameEnded = false;
    int[][] map;
    Move moveWin;
    Move vectorWin;

    public BattleMap(int playerRight, int fieldSize, int winSize, JLabel labelLeft, JLabel labelRight, JLabel labelStatus) {
        this.playerRight = playerRight;
        this.fieldSize = fieldSize;
        this.winSize = winSize;
        this.labelLeft = labelLeft;
        this.labelRight = labelRight;
        this.labelStatus = labelStatus;

        countMove = fieldSize * fieldSize;

        map = new int[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameEnded) {
                    return;
                }

                Move move = new Move(fieldSize * e.getX() / getWidth(), fieldSize * e.getY() / getHeight());
                Move vector = new Move();

                if (map[move.x][move.y] == DOT_EMPTY) {
                    humanMove(move);

                    if (checkWin(move, vector, map[move.x][move.y])) {
                        if (map[move.x][move.y] == DOT_PLAYER_LEFT) {
                            gameOver(HUMAN_LEFT_WIN, move, vector);
                        } else {
                            gameOver(HUMAN_RIGHT_WIN, move, vector);
                        }
                        return;
                    }

                    if (countMove == 0) {
                        gameOver(DRAW);
                        return;
                    }

                    if (playerRight == HUMAN) {
                        return;
                    }

                    computerMove(move);

                    if (checkWin(move, vector, map[move.x][move.y])) {
                        gameOver(COMPUTER_WIN, move, vector);
                        return;
                    }

                    if (countMove == 0) {
                        gameOver(DRAW);
                    }
                }
            }
        });
    }

    private void humanMove(Move move) {
        if (gameEnded) {
            return;
        }

        makeMove(move);
    }

    private void computerMove(Move move) {
        if (makeMoveToWin(move, DOT_COMPUTER)) {           // проверяем, есть ли ход, при котором выигрывает робот
        } else if (makeMoveToWin(move, DOT_PLAYER_LEFT)) { // проверяем, есть ли ход, при котором выигрывает человек
        } else if (makeMoveToLine(move)) {                 // ищем линию с перспективой выигрыша
        } else {
            makeMoveToRandom(move);                        // делаем случайный ход
        }

        makeMove(move);
    }

    private void makeMove(Move move) {
        map[move.x][move.y] = dot;
        repaint();

        if (dot == DOT_PLAYER_LEFT) {
            dot = DOT_PLAYER_RIGHT;
            labelLeft.setBorder(BorderFactory.createEmptyBorder());
            labelRight.setBorder(BorderFactory.createLineBorder(Color.red));
            labelStatus.setText("Move of " + labelRight.getText() + " is expected");
        } else {
            dot = DOT_PLAYER_LEFT;
            labelLeft.setBorder(BorderFactory.createLineBorder(Color.red));
            labelRight.setBorder(BorderFactory.createEmptyBorder());
            labelStatus.setText("Move of " + labelLeft.getText() + " is expected");
        }

        --countMove;
    }

    // Ищем точку move, при которой выигрывает фишка dot.
    // Если такой ход находится, то его координаты сохраняются в move
    private boolean makeMoveToWin(Move move, int newDot) {
        move.setMove(0, 0);
        Move vector = new Move();
        if (map[move.x][move.y] != DOT_EMPTY) {
            makeMoveToNext(move);
        }
        do {
            if (checkWin(move, vector, newDot)) {
                return true;
            }
        } while (makeMoveToNext(move));
        return false;
    }

    // ищем ход, который создает новую или удлиняет имеющуюся строку символов DOT_O
    // с возможностью выигрыша по этой строке
    // Если такой ход находится, то его координаты сохраняются в move
    private boolean makeMoveToLine(Move move) {
        int count;
        int countMax;
        Move moveMax = new Move(0, 0);

        move.setMove(0, 0);
        if (map[move.x][move.y] != DOT_EMPTY) {
            makeMoveToNext(move);
        }

        Move vector = new Move();
        do {
            vector.setMove(0, -1); // 0' + 180'
            countMax = countSame(move, vector, DOT_COMPUTER, DOT_EMPTY);
            moveMax.copyMove(move);

            vector.setMove(+1, -1); // 45' + 135'
            count = countSame(move, vector, DOT_COMPUTER, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.copyMove(move);
            }

            vector.setMove(+1, 0); // 90' + 270'
            count = countSame(move, vector, DOT_COMPUTER, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.copyMove(move);
            }

            vector.setMove(+1, +1); // 135' + 315'
            count = countSame(move, vector, DOT_COMPUTER, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.copyMove(move);
            }
        } while (makeMoveToNext(move));

        if (countMax == 1) {
            return false;
        } else {
            move.copyMove(moveMax);
            return true;
        }
    }

    // Поиск следующего хода. Поиск делается по map от точки move "вправо"
    // Если такой ход находится, то его координаты сохраняются в move
    private boolean makeMoveToNext(Move move) {
        boolean start = true;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (start) { // пропускаем таблицу ДО move, включительно
                    i = move.x;
                    j = move.y;
                    start = false;
                } else {
                    if (map[i][j] == DOT_EMPTY) {
                        move.setMove(i, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void makeMoveToRandom(Move move) {
        Move nextMove = new Move();
        Random random = new Random();
        do {
            nextMove.setMove(random.nextInt(fieldSize), random.nextInt(fieldSize));
        } while (map[nextMove.x][nextMove.x] != DOT_EMPTY);
        move.copyMove(nextMove);
    }

    private void gameOver(int gameResult) {
        gameEnded = true;
        labelLeft.setBorder(BorderFactory.createEmptyBorder());
        labelRight.setBorder(BorderFactory.createEmptyBorder());
        switch (gameResult) {
            case COMPUTER_WIN:
                labelStatus.setText("Game over. " + labelRight.getText() + " is winner");
                labelRight.setBorder(BorderFactory.createLineBorder(Color.red));
                break;
            case HUMAN_LEFT_WIN:
                labelStatus.setText("Game over. " + labelLeft.getText() + " is winner");
                labelLeft.setBorder(BorderFactory.createLineBorder(Color.red));
                break;
            case HUMAN_RIGHT_WIN:
                labelStatus.setText("Game over. " + labelRight.getText() + " is winner");
                labelRight.setBorder(BorderFactory.createLineBorder(Color.red));
                break;
            case DRAW:
                labelStatus.setText("Game over. Draw");
                break;
        }
    }

    private void gameOver(int gameRusult, Move move, Move vector) {
        gameOver(gameRusult);
        moveWin = new Move(move);
        vectorWin = new Move(vector);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int mapSize = Math.min(getWidth(), getHeight());

        // отрисовка поля
        for (int i = 1; i <= fieldSize; i++) {
            int c = i * mapSize / fieldSize;
            g.drawLine(c, 0, c, mapSize);
            g.drawLine(0, c, mapSize, c);
        }

        int cellSize = getWidth() / fieldSize;
        int decrease = cellSize / 5; // -20%

        // отрисовка фишек
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                switch (map[i][j]) {
                    case DOT_PLAYER_LEFT:
                        int x1 = cellSize * i + decrease;
                        int y1 = cellSize * j + decrease;
                        int x2 = cellSize * (i + 1) - decrease;
                        int y2 = cellSize * (j + 1) - decrease;
                        g.drawLine(x1, y1, x2, y2);
                        x1 = cellSize * i + decrease;
                        y1 = cellSize * (j + 1) - decrease;
                        x2 = cellSize * (i + 1) - decrease;
                        y2 = cellSize * j + decrease;
                        g.drawLine(x1, y1, x2, y2);
                        break;
                    case DOT_PLAYER_RIGHT:
                        g.drawOval(cellSize * i + decrease, cellSize * j + decrease, cellSize - 2 * decrease, cellSize - 2 * decrease);
                        break;
                }
            }
        }

        if (moveWin == null) {
            return;
        }

        // отрисовка победной линии
        int x1 = moveWin.x;
        int y1 = moveWin.y;

        while ((0 <= x1) && (x1 < fieldSize) && (0 <= y1) && (y1 < fieldSize)) {
            x1 += vectorWin.x;
            y1 += vectorWin.y;
        }

        int x2 = moveWin.x;
        int y2 = moveWin.y;

        while ((0 <= x2) && (x2 < fieldSize) && (0 <= y2) && (y2 < fieldSize)) {
            x2 -= vectorWin.x;
            y2 -= vectorWin.y;
        }

        g.drawLine(x1 * cellSize + cellSize / 2, y1 * cellSize + cellSize / 2,
                x2 * cellSize + cellSize / 2, y2 * cellSize + cellSize / 2);
    }

    // проверяет на победу ход newDot в координаты move
    // если есть победа, то направление линии сохраняется в vector
    private boolean checkWin(Move move, Move vector, int newDot) {

/* таблица векторов от точки (0 0)
 (-1 -1)  ( 0 -1) (+1 -1)

 (-1  0)  ( 0  0) (+1  0)

 (-1 +1)  ( 0 +1) (+1 +1)

 все линии, проходящие через (0 0) можно получить в направлениях 0' 45' 90' 135' в прямом и обратном направлениях
*/

        vector.setMove(0, -1); // 0' + 180'
        if (countSame(move, vector, newDot, newDot) >= winSize) return true;

        vector.setMove(+1, -1); // 45' + 135'
        if (countSame(move, vector, newDot, newDot) >= winSize) return true;

        vector.setMove(+1, 0); // 90' + 270'
        if (countSame(move, vector, newDot, newDot) >= winSize) return true;

        vector.setMove(+1, +1); // 135' + 315'
        if (countSame(move, vector, newDot, newDot) >= winSize) return true;

        return false;
    }

    // счет клеток, располагающихся на одной линии с точкой move по вектору vector с таким же значением,
    // как dot1 или dot2
    private int countSame(Move move, Move vector, int dot1, int dot2) {
        int count = 1;

        for (int i = 0; i < 2; i++) {

            int x = move.x + vector.x;
            int y = move.y + vector.y;

            while ((0 <= x) && (x < fieldSize) && (0 <= y) && (y < fieldSize)) {
                if ((map[x][y] == dot1) || (map[x][y] == dot2)) {
                    count++;
                } else {
                    break;
                }
                x += vector.x;
                y += vector.y;
            }

            vector.setMove(-vector.x, -vector.y); // инверсия для прохода в противоположном направлении
        }
        return count;
    }
}
