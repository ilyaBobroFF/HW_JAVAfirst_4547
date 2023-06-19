// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее ариф. значение

package HomeWork3;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> inNumbers = new ArrayList<Integer>();
        
        
        for (int index = 0; index < 20; index++) {
            inNumbers.add(index, 1 + (int)(Math.random()*100));
        }
        System.out.println("Входной список: " + inNumbers);   // Вывод исходного списка чисел

        ArrayList<Integer> numbers1 = new ArrayList<Integer>(inNumbers);
        numbers1.removeIf(i -> i % 2 == 0);
        System.out.println("Список без четных элементов: " + numbers1);    // Вывод результата первого задания
        
        int max = inNumbers.get(0);
        int min = inNumbers.get(0);
        double sum = inNumbers.get(0);
        for (int i = 1; i < inNumbers.size(); i++) {
            sum += inNumbers.get(i);
            if (inNumbers.get(i) > max) max = inNumbers.get(i);
            if (inNumbers.get(i) < min) min = inNumbers.get(i);
        }
        sum /= inNumbers.size();

        System.out.println("Максимальное число = " + max);  // Вывод результата второго задания
        System.out.println("Максимальное число = " + min);  // Вывод результата третьего задания
        System.out.println("Среднее арифметическое = " + sum); // Вывод результата четвертого задания

    }
}

    