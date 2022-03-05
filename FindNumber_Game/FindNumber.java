package FindNumber_Game;

import java.util.Scanner;


public class FindNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        System.out.println("Ваша задача - угадать число!");
         for (int i = 20; i <= 60; i+=20) gameLevel(i);
        System.out.println("Игра окончена!");
        scanner.close();
    }

    private static void gameLevel(int range){
        int number = (int) (Math.random() * range);
        while (true) {
            System.out.println("Угадайте число от 0 до " + range);
            System.out.println("Введите его ниже!");
            int input_num = scanner.nextInt();
            if (input_num == number){
                System.out.println("Вы угадали число!");
                break;
            } else if (input_num > number){
                System.out.println("Загаданное число меньше, чем указанное");
            } else {
                System.out.println("Загаданное число больше, чем указанное");
            }
        }
    }
}
