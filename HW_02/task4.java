package ExceptionsHomeWork.HW_02;

import java.util.Scanner;

/*
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class task4 {
    public static void main(String[] args) {
        gettingName();
    }

    public static String gettingName() {
        String myName = "";
        System.out.println("Введите Ваше имя: ");
        myName = extracted().nextLine();
        EmptyStringException(myName);
        System.out.printf("Привет, %s!", myName);       
        return myName;
    }

    public static void EmptyStringException(String name){        
        if(name == null || name.isEmpty()){
            try {
                throw new Exception("Имя не может быть пустым!");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        }        
    }
    
    //метод создает новый объект Scanner.
    private static Scanner extracted() {
        return new Scanner(System.in);
    }
}
