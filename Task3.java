// 3) Дана строка в файле(читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит строчку и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика. 


import java.io.*;


public class Task3 {
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader filer = new BufferedReader(new FileReader("infile.txt"))){
            String line = filer.readLine();
            String newLine = line.replace('"', '@');
            String[] words = newLine.split("@");
            StringBuilder lineBuilder = new StringBuilder();
            
            for (String el : words) {
                if(el.length() >  3 || el.equals("5")||el.equals("4")||el.equals("3")) {
                    el.replace(":", "");
                    if (el.equals("фамилия")) lineBuilder.append("\nСтудент ");
                    else if (el.equals("оценка")) lineBuilder.append("получил ");
                    else if (el.equals("предмет")) lineBuilder.append("по предмету ");
                    else lineBuilder.append(el + " ");
                }
            }
            System.out.println(lineBuilder + "\n");
        }
        catch(IOException ex){
            System.out.println("Ошибка работы с файлом");
        }
          
    


    }
}  
   
