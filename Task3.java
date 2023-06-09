// Реализовать простой калькулятор (+-/*)

import java.util.Scanner;
public class Task3 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите первое число");
       String inNum1 = sc.nextLine();
       double num1 = Double.parseDouble(inNum1);
       System.out.println("Введите операцию: +, -, /, *. ");
       String oper = sc.nextLine();
       System.out.println("Введите второе число");
       String inNum2 = sc.nextLine();
       double num2 = Double.parseDouble(inNum2);
       double res = -1;
        sc.close();
       switch (oper) {
        case "+":
            res = num1 + num2;
            break;
        case "-":
            res = num1 - num2;
            break;
        case "*":
            res = num1 * num2;
            break;
        case "/":
            res = num1 / num2;
            break;
        default:
            System.out.println("Неверно введен оператор. Ответ будет выведен по умолчанию");
            break;
       }
       System.out.println("Ответ равен: " + res);
    }
}
