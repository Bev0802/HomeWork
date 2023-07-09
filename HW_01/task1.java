
package ExceptionsHomeWork.HW_01;

import java.util.Scanner;
import java.util.Random;

/*
* 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
*/    
public class task1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        error_01();
        //error_02(5);
        //error_03();
    }   
        /*
         * выход за пределы массива: ArrayIndexOutOfBoundsException
         */
        public static void error_01() {
            int[] arrint = new int[10];
            System.out.println(arrint[11]);            
        }

        /*
         * Деление на ноль выдает исключение: ArithmeticException: / by zero
         */
        public static void error_02(int a){        
            System.out.println(a/0);
        }
        /*
         * // при введении строки (например: "5") или натурального числа (например: 5.5) выдает исключение: InputMismatchException
         */
        public static void error_03(){                    
            int[] array = new int[10];            
            
            System.out.println("Укажите число для поиска: ");
            int searchNumber = scanner.nextInt(); 
            
            for (int i = 0; i < array.length; i++) {                                
                array[i] = random.nextInt(10);
                System.out.printf("%d\t", array[i]);
                if(array[i] == searchNumber){
                    System.out.printf("Индекс числа где находится исковое значение: " + i + (" "));
                }
            }
                
           
        }   
   

   

     

}
