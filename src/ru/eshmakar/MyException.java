package ru.eshmakar;

import java.util.Scanner;

    public class MyException extends Exception {
        private int code;

        MyException(int n) {
            super();
            code = n;
        }

        @Override
        public String toString() {
            String message = "Пользовательское исключение. Код ошибки" + code;
            return message;
        }

        public static void main(String[] args) {
            while (true) {
                Scanner s = new Scanner(System.in);
                System.out.println("Enter the value:");
                String userInput = s.nextLine();
                int userData;
                try {
                    userData = Integer.parseInt(userInput);
                    if (userData % 2 == 0) throw new MyException(1);
                    else if (userData > 100) throw new MyException(2);
                } catch (NumberFormatException e) {
                    if (e.toString().contains("null")) System.exit(0);
                    else System.out.println("Введено не допустимое значение");
                } catch (MyException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
