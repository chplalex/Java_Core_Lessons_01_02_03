package lesson0104;

import javax.naming.SizeLimitExceededException;
import java.util.Random;
import java.util.Scanner;

public class MainApp0104 {

    static final int SIZE = 5;
    static final int SIZE_WIN = 4;
    static final char DOT_X = 'X'; // фишка человека
    static final char DOT_O = 'O'; // фишка робота
    static final char DOT_EMPTY = '.';

    static int countMove = SIZE * SIZE;
    static char[][] map;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static class Move {
        int X;
        int Y;
    }

    public static void main(String[] args) {

        Move move = new Move();

        System.out.println("Играем в крестики-нолики!");
        System.out.printf("Основные условия: поле %d * %d, победная серия %d фишки.%n%n", SIZE, SIZE, SIZE_WIN);

        initMap();
        printMap();
        do {

            humanMove(move);
            printMap();

            if (--countMove == 0) {
                System.out.println("Ничья");
                break;
            }

            if (checkWin(move, DOT_X)) {
                System.out.println("Человек выиграл!");
                break;
            }

            robotMove(move);
            printMap();

            if (checkWin(move, DOT_O)) {
                System.out.println("Робот выиграл!");
                break;
            }

            --countMove;

        } while (true);

        System.out.println("Игра окончена!");
    }

    // первичная инициализация игроворго поля
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // печать игрового поля
    public static void printMap() {
        System.out.print(' ');
        for (int i = 0; i < SIZE; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%s ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanMove(Move move) {
        Move nextMove = new Move();
        int y;
        System.out.println("Сделай ход. Введи № СТРОКИ (enter) потом № СТОЛБЦА (enter): ");
        do {
            nextMove.X = scanner.nextInt(); // сделать проверку на корректность ввода
            nextMove.Y = scanner.nextInt();
        } while (map[nextMove.X][nextMove.Y] != DOT_EMPTY);
        move.X = nextMove.X;
        move.Y = nextMove.Y;
        map[move.X][move.Y] = DOT_X;
    }

    public static void robotMove(Move move) {
        if (makeMoveToWin(move, DOT_O)) {        // проверяем, есть ли ход, при котором выигрывает робот
        } else if (makeMoveToWin(move, DOT_X)) { // проверяем, есть ли ход, при котором выигрывает человек
        } else if (makeMoveToLine(move)) {       // ищем линию с перспективой выигрыша
        } else {
            makeMoveToRandom(move);              // делаем случайный ход
        }
        map[move.X][move.Y] = DOT_O;
    }

    // Ищем точку move, при которой выигрывает фишка dot. Если находим, то робот ходит на эту точку
    public static boolean makeMoveToWin(Move move, char dot) {
        move.X = 0;
        move.Y = 0;
        if (map[move.X][move.Y] != DOT_EMPTY) {
            makeMoveToNext(move);
        }
        do {
            if (checkWin(move, dot)) {
                map[move.X][move.Y] = DOT_O;
                return true;
            }
        } while (makeMoveToNext(move));
        return false;
    }

    // ищем ход, который создает новую или удлиняет имеющуюся строку символов DOT_O
    // с возможностью выигрыша по этой строке
    public static boolean makeMoveToLine(Move move) {
        int count;
        int countMax;
        Move moveMax = new Move();

        move.X = 0;
        move.Y = 0;
        if (map[move.X][move.Y] != DOT_EMPTY) {
            makeMoveToNext(move);
        }
        do {
            // 0' + 180'
            countMax = countSame(move, 0, -1, DOT_O, DOT_EMPTY);
            moveMax.X = move.X;
            moveMax.Y = move.Y;

            // 45' + 135'
            count = countSame(move, +1, -1, DOT_O, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.X = move.X;
                moveMax.Y = move.Y;
            }

            // 90' + 270'
            count = countSame(move, +1, 0, DOT_O, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.X = move.X;
                moveMax.Y = move.Y;
            }

            // 135' + 315'
            count = countSame(move, +1, +1, DOT_O, DOT_EMPTY);
            if (count > countMax) {
                countMax = count;
                moveMax.X = move.X;
                moveMax.Y = move.Y;
            }
        } while (makeMoveToNext(move));

        if (countMax == 1) {
            return false;
        } else {
            move.X = moveMax.X;
            move.Y = moveMax.Y;
            return true;
        }
    }

    // Поиск следующего хода. Поиск делается по map от точки move "вправо"
    // Если такой ход находится, то его координаты сохраняются в move
    public static boolean makeMoveToNext(Move move) {
        boolean start = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (start) { // пропускаем таблицу ДО move, включительно
                    i = move.X;
                    j = move.Y;
                    start = false;
                } else {
                    if (map[i][j] == DOT_EMPTY) {
                        move.X = i;
                        move.Y = j;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void makeMoveToRandom(Move move) {
        Move nextMove = new Move();
        do {
            nextMove.X = random.nextInt(SIZE);
            nextMove.Y = random.nextInt(SIZE);
        } while (map[nextMove.X][nextMove.Y] != DOT_EMPTY);
        move.X = nextMove.X;
        move.Y = nextMove.Y;
    }

    public static boolean checkWin(Move move, char dot) {

/* таблица векторов от точки (0 0)
 (-1 -1)  ( 0 -1) (+1 -1)

 (-1  0)  ( 0  0) (+1  0)

 (-1 +1)  ( 0 +1) (+1 +1)

 все линии, проходящие через (0 0) можно получить в направлениях 0' 45' 90' 135' в прямом и обратном направлениях
*/

        int count;

        // 0' + 180'
        count = countSame(move, 0, -1, dot, dot);
        if (count >= SIZE_WIN) return true;

        // 45' + 135'
        count = countSame(move, +1, -1, dot, dot);
        if (count >= SIZE_WIN) return true;

        // 90' + 270'
        count = countSame(move, +1, 0, dot, dot);
        if (count >= SIZE_WIN) return true;

        // 135' + 315'
        count = countSame(move, +1, +1, dot, dot);
        if (count >= SIZE_WIN) return true;

        return false;
    }

    // счет клеток, располагающихся на одной линии с точкой move по вектору dX dY с таким же значением,
    // как dot1 или dot2
    public static int countSame(Move move, int dX, int dY, char dot1, char dot2) {
        int count = 1;

        for (int i = 0; i < 2; i++) {

            int x = move.X + dX;
            int y = move.Y + dY;

            while ((0 <= x) && (x < SIZE) && (0 <= y) && (y < SIZE)) {
                if ((map[x][y] == dot1) || (map[x][y] == dot2)) {
                    count++;
                } else {
                    break;
                }
                x += dX;
                y += dY;
            }

            dX = -dX; // инверсия для прохода в противоположном направлении
            dY = -dY;
        }
        return count;
    }
}
