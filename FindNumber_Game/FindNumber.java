import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваша задача - угадать число!");
        int range = 100;
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
        scanner.close();
    }
}
