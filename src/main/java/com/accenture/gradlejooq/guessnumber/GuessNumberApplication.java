package com.accenture.gradlejooq.guessnumber;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberApplication {

    private static int min = 0;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        setNumbers(keyboard);

        if (max < min) {
            do {
                System.out.println("Максимальное значение не может быть меньше или равным минимальному! Попробуйте еще раз");
                setNumbers(keyboard);
            } while (max < min);
        }

        int randomNumber = random.nextInt(max - min) + min;

        System.out.println("Загадано число в диапозоне от " + min + " до " + max + ", угадайте его!");

        int result = keyboard.nextInt();
        if (result < min || result > max) {
            do {
                System.out.println("Вводимое число должно быть в диапазоне от " + min + " до " + max + "!");
                result = keyboard.nextInt();
            } while (result < min || result > max);
        }

        if (randomNumber != result) {
            do {
                System.out.println("Вы ошиблись, попробуйте снова");
                result = keyboard.nextInt();
            } while (result != randomNumber);
        }
        System.out.println("Вы угадали!");
    }

    private static void setNumbers(Scanner keyboard) {
        try {
            System.out.println("Введите минимальное значение:");
            min = keyboard.nextInt();
            System.out.println("Введите максимальное значение:");
            max = keyboard.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Разрешается вводить только цифры!");
            System.exit(0);
        }

    }
}
