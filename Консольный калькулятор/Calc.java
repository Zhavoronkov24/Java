package Dir1;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию: ");  //|\
        System.out.println("1.Вычитание");          //| \
        System.out.println("2.Сложение");           //|  > Типы операций
        System.out.println("3.Умножение");          //| /
        System.out.println("4.Деление");            //|/

        int operation = scanner.nextInt();
        System.out.println("Введите первое число - ");      // Число 1
        float int1 = scanner.nextInt();
        System.out.println("Введите второе число - ");      // Число 2
        float int2 = scanner.nextInt();

        float sum = int1 + int2;          // Сложение
        float subs = int1 - int2;         // Вычитание
        float multipl = int1 * int2;      // Умножение
                                        //Деление в case 4

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
            case 4: try {
                System.out.println("Результат: " + int1 / int2);

            } catch (ArithmeticException e){
                System.out.println("На 0 делить нельзя!");
            } break;

            default:
                System.out.println("Операция выбрана не корректно. Попробуйте снова");
        }
        System.out.println("Благодарю за использование калькулятора!");
    }
}
