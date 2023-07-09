package ExceptionsHomeWork.HW_01;

import java.util.Arrays;
import java.util.Random;
/*
* 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
* каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
*/
public class task2 {
    static Random random = new Random();
    public static void main(String[] args) {
        
        int[] array1 = createRandomArray();
        int[] array2 = createRandomArray();
        int[] subArr = subArrays(array1, array2);
        System.out.printf("%s - %s = %s\n", (Arrays.toString(array1)), 
                            (Arrays.toString(array2)), (Arrays.toString(subArr)));
    }

    /** Метод создает новый массив из рандомных чисел и рандомного размера.
     * @return массив.
     */
    public static int[] createRandomArray(){
        int[] array = new int[random.nextInt(5) + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);               
        }        
        return array; 
    }        

    public static int[] subArrays(int[]array1, int[]array2) {
        int maxL;
        int minL;
        boolean arrayLonger;
                
        if ((array1.length) >= (array2.length)) {
            maxL = array1.length;
            minL = array2.length;
            arrayLonger = true;
        }else {
            maxL = array2.length;
            minL = array1.length;
            arrayLonger = false;
        }
        
        int[]subArrays = new int[maxL];
        
        if (array1.length != array2.length) {
            System.out.println("Массивы имеют разную длину.");        
        }

        for (int i = 0; i < minL; i++) {
            subArrays[i] = array1[i] - array2[i];            
        }
        
        for (int i = minL; i < subArrays.length; i++) {
            if (arrayLonger)
                subArrays[i] = array1[i];
            else{
                subArrays[i] = array2[i];
            }
        }
        return subArrays;      
    }    
}
    

