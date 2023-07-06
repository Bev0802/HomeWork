package ExceptionsHomeWork.HW_02;

import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class task1 {  


    public static void main(String[] args) {
        gettingNumber();
}

    public static float gettingNumber() {        
        float num = 0;
        while (num==0) {                
            try {
                System.out.println("Введите натуральное число не равное нулю, если есть дробная часть, то через запятую: ");            
                num = extracted().nextFloat();                
                System.out.println(num);
            
                return num;      
            } 
            catch (InputMismatchException e) {
                System.out.println("Ошибка! Вы ввели не верное значение!");                                
            } finally{

            }      
        } 
        
        return num;
    }
//метод создает новый объект Scanner.
    private static Scanner extracted() {
        return new Scanner(System.in);
    }
}
