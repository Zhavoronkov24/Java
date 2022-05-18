package PasswordGen;

import java.util.*;

public class Generator {
    public static void main(String[] args) {

        // Ввод в консоль
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите длину пароля: ");

        int length = scanner.nextInt();

        // Проверка на минимальную длину
        if (length < 2) {
            System.out.println("Длина пароля минимум 2 символа!");
        } else {
            System.out.println(password(length));
        }
    }

    static char[] password(int len) {
        System.out.println("|Генерируем новый пароль|");
        System.out.println("Ваш новый пароль :");

        // Используемые данные
        String Up_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Do_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String symbols = "!(*?@[_";

        String res = Up_chars + Do_chars + numbers + symbols;

        // Генерация рандомного пароля
        Random random = new Random();

        char[] psw = new char[len];

        for (int i = 0; i < len; i++) {
            psw[i] = res.charAt(random.nextInt(res.length()));
        }
        return psw;
    }
}
