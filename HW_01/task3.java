package ExceptionsHomeWork.HW_01;

import java.util.Arrays;
import java.util.Random;
/*
* 3) (Дополнительно) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
* каждый элемент которого равен частному элементов двух *входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
* Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
*/
public class task3 {
    static Random random = new Random();
    public static void main(String[] args) {      
        
        int[] array1 = createRandomArray();
        int[] array2 = createRandomArray();

        arrayLonger(array1, array2);

        double[] divArr = divArrays(array1, array2);
        System.out.printf("%s / %s = %s\n", (Arrays.toString(array1)), 
                            (Arrays.toString(array2)), (Arrays.toString(divArr)));
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

    /** Метод проверяет равны ли массивы:
     * @param arr1
     * @param arr2
     * @return возвращает ошибку или true;
     */
    public static boolean arrayLonger(int[]arr1, int[]arr2){
        boolean arrayLonger;
        if (arr1.length !=  arr2.length) {
            arrayLonger = false;
            throw new RuntimeException("Ошибка! Некорректная размерность массива!");            
        }else {
            arrayLonger = true;            
        }
        return arrayLonger;
    }

    /** Метод делить один массивы на другой.
     * @param array1
     * @param array2
     * @return
     */
    public static double[]divArrays(int[]array1, int[]array2) {        
        double[]subArrays = new double[array1.length];
        
        for (int i = 0; i < subArrays.length; i++){
            if(array2[i] == 0)
                throw new RuntimeException("Ошибка! На 0 делить нельзя!");
            else subArrays[i] = Math.round((double)array1[i] / ((double)(array2[i])));                
        }
        return subArrays;
    }         
}
