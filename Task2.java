// Вывести все простые числа от 1 до 1000

public class Task2 {
    public static void main(String[] args) { 
    int count = 0;
    int size = 1000;
    System.out.print("START: ");
    for (int el = 2; el < size + 1; el++) {
       for (int number = 2; number < el + 1; number++) {
        if (number < el && el % number == 0) break;
        else if (number == el && el / el == 1){
          System.out.print(el + ", ");
          count++;
        } 
       }   
     } 
     System.out.println(":FINISH");
     System.out.println("Количество простых чисел = " + count);
    }
}
