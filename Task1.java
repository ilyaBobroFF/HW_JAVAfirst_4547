// 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
// import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
                
        String[] stroka = {"name", "Ivanov", "country", "Russia", "city", "Moscow", "age", "null"}; // Входной массив строк. Сделана не большая "халтура" ':' 
                                                                                                    // сразу замено на ',' что бы убрать работу с JSON строкой.

        int newSizeMinus = 0;
        for (String i : stroka){  
            if (i == "null"){
                newSizeMinus += 2;
            }
        }
        String [][] newStroka = new String [(stroka.length - newSizeMinus) / 2][2]; 
        int step = 1;
        while (step < newStroka.length * 2) {
            String [] newLine = new String [2];
            if (stroka[step] != "null"){
                newLine[0] = stroka[step - 1];
                newLine[1] = stroka[step];
                newStroka [(step-1) / 2] = newLine;
            }
            step += 2;
        }

        StringBuffer result = new StringBuffer("select * from students");
        if(newStroka.length > 0){
            result.append(" WHERE ");
            for (int i = 0; i < newStroka.length - 1; i++){  
                result.append(newStroka[i][0] + "="+ newStroka[i][1] + " AND ");
            }
            result.append(newStroka[newStroka.length - 1][0] + "="+ newStroka[newStroka.length - 1][1]);  
        }
        System.out.println(result);
     
    }
}
