package Tik_Tak_Toe;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTakToe {

    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Scanner sc;
    Random random;

    public static void main(String[] args) {
        TicTakToe ttt = new TicTakToe();
        ttt.game();

    }

    TicTakToe() {
        table = new char[3][3];
        sc = new Scanner(System.in);
        random = new Random();
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("Вы выйграли!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Ничья!");
                break;
            }
            turnAi();
            printTable();
            if (isWin(SIGN_O)) {
                System.out.println("Вы проиграли!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Ничья!");
                break;
            }
        }

    }

    void initTable() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                table[y][x] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                System.out.print(table[y][x] + " ");
            }
            System.out.println("");
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Введи координаты x y через пробел: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    void turnAi() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;

    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2){
            System.out.println("Вы ввели что-то не то!");
            return false;
        }
            return table[y][x] == SIGN_EMPTY;
    }

    boolean isWin(char ch) {
        //вертикаль
        if (table[0][0] == ch && table[0][1] == ch && table[0][2] == ch) return true;
        if (table[1][0] == ch && table[1][1] == ch && table[1][2] == ch) return true;
        if (table[2][0] == ch && table[2][1] == ch && table[2][2] == ch) return true;
        //горизонталь
        if (table[0][0] == ch && table[1][0] == ch && table[2][0] == ch) return true;
        if (table[0][1] == ch && table[1][1] == ch && table[2][1] == ch) return true;
        if (table[0][2] == ch && table[1][2] == ch && table[2][2] == ch) return true;
        // диагональ 1
        if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
        //диагональ 2
        if (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;
        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                if (table[y][x] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


}

