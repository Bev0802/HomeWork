package ExceptionsHomeWork.HW_02;
/*
 * 2. Если необходимо, исправьте данный код (задание 2 
 * https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit) * 
 */

import java.util.Arrays;
import java.util.Random;

public class task2 {
   static Random random = new Random();
   static int[] intArray = createRandomArray();
   
   public static void main(String[] args) {     
   
   try {
       int d = 0;
       double catchedRes1 = (intArray[8]/d);
       System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
       System.out.println("Catching exception: " + e);
    }
   }

   /** Метод создает новый массив из рандомных чисел.
     * @return массив.
     */
    public static int[] createRandomArray(){
      int[] array = new int[10];
      for (int i = 0; i < array.length; i++) {
          array[i] = random.nextInt(10);               
      }
      System.out.println(Arrays.toString(array));      
      return array; 
  }          
}
