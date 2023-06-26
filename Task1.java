// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1] - пример Deque
// [5,4,3]- пример второго Deque
// 1) 123 * 345 = 42 435
// Ответ всегда - связный список, в обычном порядке
// [4,2,4,3,5] - пример ответа


package HomeWork4;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Минус хотя бы в одном элементе делает отрицательным все число!!!");   // Вводная фраза

        Deque<Integer> numbers1 = inputNumbersInDeque("Введите количество элементов первого числа: ");   // Получение  Deque в обратном порядке из введеных чисел (знак учитывается)
        Deque<Integer> numbers2 = inputNumbersInDeque("Введите количество элементов второго числа: ");
        

        int intNum1 = dequeInInt(numbers1); // Перевод списков в int
        int intNum2 = dequeInInt(numbers2);
    
    
        
        LinkedList<Character> result = intInLinkedList(intNum1 * intNum2);                       // Вычисление и вывод ответов
        System.out.println("Список равный уножению чисел приведен ниже: \n Ответ1 = " + result);     
        result = intInLinkedList(intNum1 + intNum2);
        System.out.println("Список равный сложению чисел приведен ниже: \n Ответ2 = " + result);
    }   
    
    
    public static Deque<Integer> inputNumbersInDeque(String nameInput) {   // Получение Deque в обраном порядке из вводимых элементов
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println(nameInput);
        int size = Integer.parseInt(sc.nextLine());
        Deque<Integer> numbers = new ArrayDeque<Integer>();
        for (int i = 0; i < size; i++) {
            System.out.println("Введите текущий элемент по одному числу: ");
            numbers.push(Integer.parseInt(sc.nextLine()));
        }
    //    sc.close();   // При втором вызове метода возникает ошибка. Пока оставленно так.
        return numbers;
        
    }
    
    public static int dequeInInt(Deque<Integer> numbers) {     // Преобразование Deque в число int
        int step = 1;
        int res = 0;
        boolean minus = false;
        for (int i : numbers) {
            if (i <0 ){
                i *= -1;
                minus = true;
            }
            res += step * i;
            step *= 10;
        }
        if (minus) res *= -1;
        return res;
    }
    
    public static LinkedList<Character> intInLinkedList(int number) { // Вывод ответа. Реализовано так, что минус отображается как отдельный символ. В задании про это не сказанно.
        String element = Integer.toString(number);
        char[] res = element.toCharArray();
        LinkedList<Character> result = new LinkedList<Character>();
        for (char el : res) {
            result.addLast(el);
        }
        return result;    
    }
    
}
