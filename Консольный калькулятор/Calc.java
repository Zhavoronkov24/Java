package Dir1;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию: ");
        System.out.println("1.Вычитание");
        System.out.println("2.Сложение");
        System.out.println("3.Умножение");
        System.out.println("4.Деление");

        int operation = scanner.nextInt();
        System.out.println("Введите первое число - ");
        int int1 = scanner.nextInt();
        System.out.println("Введите второе число - ");
        int int2 = scanner.nextInt();

        int sum = int1 + int2;
        int subs = int1 - int2;
        int multipl = int1 * int2;
        int div = int1 / int2;

        switch (operation){
            case 1:
                System.out.println("Результат : " + subs);
                break;
            case 2:
                System.out.println("Результат : " + sum);
                break;
            case 3:
                System.out.println("Результат : " + multipl);
                break;
            case 4:
                System.out.println("Результат : " + div);
                break;
            default:
                System.out.println("Операция выбрана не корректно. Попробуйте снова");
        }
    }
}