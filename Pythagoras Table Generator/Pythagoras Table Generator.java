package Pythagoras Table Generator;

public class Generator {
    public static void main(String[] args) {
        printTable(10,10);              // Укажите размер
    }

    public static void printTable(int width, int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println("");
        }
    }
}

