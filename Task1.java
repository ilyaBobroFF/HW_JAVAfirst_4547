package HomeWork5;


// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример меню:
// 1) Добавить контакт
// 2) Вывести всех
// 3) Выход

// Иванов 123432
// Иванов 546457
// Иванов 788354

// Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325, 45674]}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    

    
    public static void main(String[] args) {

        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>(); // Основной список контактов
        phoneBook = FirstInput();
        Boolean work = true;
        while(work){
            Scanner sc = new Scanner(System.in, "cp866");
            System.out.println("Введите режим работы: \n1. Добавить контакт. \n2. Вывести всех. \n3. Выход.");
            System.out.print("Ваш ввод: ");
            int mode = Integer.parseInt(sc.nextLine());
            switch (mode) {
                case 1: {
                    AddName(phoneBook);
                    break;
                }
                case 2:{
                    ArrayList<String> sort = new ArrayList<String>(); //Сортировка
                    sort = SortedPhone(phoneBook);
                    Printbook(phoneBook, sort); // Вывод на печать
                    break;
                }
                default:
                work = false;
                System.out.println("Выполнен выход");
                    break;
            }
            
        }
        
    
    }

    // Первая запись списка контактов
    public static Map<String, ArrayList<Integer>> FirstInput (){   // Первая запись списка контактов
        Map<String, ArrayList<Integer>> result = new HashMap<>();

        result.put("Достоевский", new ArrayList<Integer>()
            {{add(781454);}});

        result.put("Тютчев", new ArrayList<Integer>()
            {{add(456987); add(987456); add(569741);}});

        result.put("Фет", new ArrayList<Integer>()
            {{add(456987); add(369852);}});

        result.put("Крылов", new ArrayList<Integer>()
            {{add(698142); add(954365); add(698471); add(852369);}});
        return result;
    }

    // Сортировка списка контактов по по убыванию количества номеров
    public static ArrayList<String> SortedPhone (Map<String, ArrayList<Integer>> input){ 
        int max = 0;
        int step = 0;
        String maxName = "";
        ArrayList<String> result = new ArrayList<String>();
        while (step < input.size()){
            for (String el: input.keySet()){
                if(!result.contains(el)){
                    if(input.get(el).size() >= max) {
                        max = input.get(el).size();
                        maxName = el;
                    }
                }
            }
            max = 0;
            result.add(maxName);
            step++;
        }
        return result;  
    }
    // Вывод на печать всего списка контактов
    public static void Printbook(Map<String, ArrayList<Integer>> input, ArrayList<String> sorted){
        for (String el: sorted){
            System.out.print(el + ": ");
            System.out.println(input.get(el));
            
        }
        System.out.println("Список контактов выведен!\n");
    }
    // Добавление нового контакта
    public static Map<String, ArrayList<Integer>> AddName (Map<String, ArrayList<Integer>> input) {
        Map<String, ArrayList<Integer>> result = new HashMap<>();
        result = input;
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите фамилию для добавления");
        String newName = sc.nextLine();
        System.out.println("Введите новые номера телефонов для добавления. Через пробел");
        String innumbers = sc.nextLine();
        if (input.containsKey(newName)) System.out.println("Это имя уже есть. Номера будут перезаптсанны");
        String[] numbers = innumbers.split(" ");
        ArrayList<Integer> numbersint = new ArrayList<>();
        for (String el: numbers) {
            numbersint.add(Integer.parseInt(el)) ;
        }
        result.put(newName, numbersint);
        
        return result;
        
        
    }
}
    
