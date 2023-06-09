// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите число:  В расчетах оно используется включительно");
       String inNum = sc.nextLine();
       int number = Integer.parseInt(inNum);
       int result1 = 0;
       int result2 = 1;
       for (int i = 1; i < number + 1; i++) {
        result1 += i;
        result2 *= i;
       }
       System.out.println("Треугольное число = " + result1 + "; Произведение чисел = " + result2); 
       sc.close();
    }
}