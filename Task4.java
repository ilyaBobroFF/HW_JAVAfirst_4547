// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
// Под знаком вопроса - всегда одинаковая ЦИФРА.
// Введите уравнение: ?? + ?? = 44
// Решение: 22 + 22 = 44
// 
//Выполнено без оптимизаций для простого решения

import java.util.Scanner;


public class Task4 {
    public static int ChangeNumber(String input, int change){ // Метод для замены знака ? на цифру
        char[] charArray = input.toCharArray();
        char[] newchar;
        newchar = new char [charArray.length];
        for (int j = 0; j < charArray.length; j++){
            if (charArray[j] == '?'){
                newchar[j] = Character.forDigit(change, 10);
            } 
            else newchar[j] = charArray[j];
        }
        String out = new String(newchar);
        int result = Integer.parseInt(out);
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите уравнение в одну строку: ");
        String inpUt = sc.nextLine();
        sc.close();
        
        boolean ok = false;
        String[]elements = inpUt.split(" ");

        for (int i = 0; i < 10; i++) {
            int num1 = ChangeNumber(elements[0], i);
            int num2 = ChangeNumber(elements[2], i);
            int num3 = ChangeNumber(elements[4], i);
            
            if (num1 + num2 == num3){
                System.out.println("Вариант решения равен:");
                System.out.println(num1 + " + " + num2 + " = " + num3);
                ok = true;
                break;
                } 
        } 
        if (!ok) System.out.println("Решение не найдено");  
    }
    
}
