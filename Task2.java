// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4
// Выполнено без оптимизации. Количество итераций особо не контролируется.


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("logger.txt", true)){
                    writer.write("Новый запуск программы");
                    writer.write("\n");
                }
                catch(IOException ex){
                    System.out.println("Ошибка с файлом");
               }
        int[] numbers = {5, 7, 1, 4, 6, 2, 3};
        System.out.print("Входной массив: ");
        for (int el : numbers){
            System.out.print(el + ", ");
        }
        System.out.println();
        int step = 0;
        while(step < numbers.length){
            for (int i = 1; i < numbers.length; i++){
                try(FileWriter writer = new FileWriter("logger.txt", true)){
                    String text = (Arrays.toString(numbers));
                    writer.write(text);
                    writer.write("\n");
                }
                catch(IOException ex){
                    System.out.println("Ошибка с файлом");
                }
                if (numbers[i-1] > numbers[i]) {
                    step = 0;
                    int temp = numbers[i-1];
                    numbers[i-1] = numbers[i];
                    numbers[i] = temp;
                
                }
                else step++;
            }
       
        }
        System.out.print("Выходной массив: ");
        for (int el : numbers){
            System.out.print(el + ", ");
        }
        System.out.println();

    }
}