// 4) К калькулятору из предыдущего ДЗ добавить логирование.
// 3+4=7
// 1+2=3
// 6/3=2
//package Seminar3;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*; 

public class Task4 {
    public static void main(String[] args) throws IOException{


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

        Logger log = Logger.getLogger(Task4.class.getName());
        String logsPath = "logTask4.txt";
        FileHandler fileInfo = new FileHandler(logsPath, true);
        log.addHandler(fileInfo);
        SimpleFormatter formatter = new SimpleFormatter();
        fileInfo.setFormatter(formatter);
        

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
       log.info(inNum1 +" " + oper + " " + inNum2 + " = " + res);
       System.out.println("Ответ равен: " + res);
    }

}