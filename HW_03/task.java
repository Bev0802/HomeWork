package ExceptionsHomeWork.HW_03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номертелефона

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования
Ввод всех элементов через пробел

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><номер_телефона>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class task {

   public static void main(String[] args) {
      Person user = user();
      File fileUser = new File("ExceptionsHomeWork/HW_03/" + user.lastName + ".txt");
      saveFile(user, fileUser);
   }

   /**
    * Метод сохранения полученных данных в файл. Вызывается метод проверка
    * checkingFile() есть ли файл с таким именем.
    * Если файла нет то создается файл createNewFile(), а если есть то данные
    * дописывается в файлWriterUserFile(user, fileUser).
    * Если писать кириллицей в файл записываются "калябы-молябы".
    * 
    * @param user     - данные пользователя.
    * @param fileUser - файл куда записываем.
    */
   public static void saveFile(Person user, File fileUser) {
      String lastname = user.lastName;
      if (checkingFile(fileUser) && lastname != null) {
         createNewFile(lastname);
         System.out.println("Создан файл: " + fileUser.toPath());
      } else {
         System.out.println("Файл с таким наименованием уже существует!");
      }
      WriterUserFile(user, fileUser);
      System.out.println("Данные записаны в файл: " + fileUser.toPath() + ".txt");
   }

   /**
    * Добавляет данные user в файл fileUser.
    * 
    * @param user     - тип Person данные для записи
    * @param fileUser - ссылка на файл.
    */
   private static void WriterUserFile(Person user, File fileUser) {
      if (fileUser.canWrite()) {
         Path path = Paths.get(fileUser.toString());
         try {
            Files.write(path, user.toString().getBytes(), StandardOpenOption.APPEND);
         } catch (IOException e) {
            System.out.println(e);
         }
      }
   }

   /**
    * Создает файл с название файла Фамилия.
    * 
    * @param lastName - получает String фамилию.
    */
   public static void createNewFile(String lastName) {
      File newUser = new File("ExceptionsHomeWork/HW_03/" + lastName + ".txt");
      try {
         newUser.createNewFile();
      } catch (Exception e) {
         System.out.println(e);
      }

   }

   /**
    * @return метод проверяет есть ли файл и есть ли в нем данные и возвращает
    *         true, если есть.
    */
   public static boolean checkingFile(File fileUser) {
      boolean checkingFile = false;
      if ((!fileUser.exists()) || ((fileUser.length() == 0))) {
         checkingFile = true;
      }
      return checkingFile;
   }

   /**
    * По коду ошибки выводит сообщение для пользователя.
    * 
    * @param user - Получает строку с ФИО и телефоном для проверки.
    */
   public static int codeProcessing(String user) {
      int ErrorCod = ErrorCod(user);
      switch (ErrorCod) {
         case 100:
            System.out.println("Ошибка! Вы ввели неверные данные!");
            user();
            break;
         case 200:
            System.out.println("Ошибка! Номер телефона введен не верно! Телефон должен состоять из 11 чисел.");
            user();
            break;
         case 300:
            System.out.println("Ошибка! Номер телефона введен не верно! Телефон должен состоять только из цифр.");
            user();
            break;
         default:
            System.out.println("Введенные данные корректны!");
      }
      return ErrorCod;
   }

   /*
    * Метод проверяет введенные данные
    */
   /**
    * Метод проверяет введенные данные на:
    * - количество слов(должно быть 4 - ФИО и телефон) и не должно быть пустых
    * значений или пробелов - 100
    * - длину телефона(должно быть 11 символов) - 200
    * - на символы в номере телефона отличные от цифр - 300
    * если все в порядке возвращает - 0.
    * 
    * @param user Получает строку с ФИО и телефоном для проверки.
    * @return код ошибки для дальнейшей обработки.
    */
   public static int ErrorCod(String user) {
      String[] userArray = user.split(" ");
      boolean emptyString = false;
      for (int i = 0; i < userArray.length; i++) {
         String each = userArray[i];
         if (each == null || each.length() == 0) {
            emptyString = true;
         }
      }
      if (userArray.length < 4 || userArray.length > 4 || emptyString) {
         return 100;
      } else if ((userArray[3]).length() < 11 || (userArray[3]).length() > 11) {
         return 200;
      } else {
         try {
            Long.parseLong(userArray[3]);
         } catch (NumberFormatException e) {
            return 300;
         }
      }
      return 0;
   }

   /**
    * Получение ФИО и телефон от пользователя, проверяет их на корректность и
    * записывает в Person
    * 
    * @return - возвращает данные о пользователе в виде типа Person.
    */
   public static Person user() {
      System.out.println(
            "Введите Ваши данные: фамилия, имя, отчество и номер телефона через пробел.\n(Например: Иванов Иван Иванович 89128000000): ");
      String[] userArr = new String[4];
      // String userString = "Богатырева Екатерина Вячеславовна 89128000000";
      // System.out.println("НЕ ЗАБУДЬ ЗАПУСТИТЬ СКАНЕР!!!");

      String userString = extracted().nextLine();
      int cod = codeProcessing(userString);
      if (cod == 0) {
         userArr = userString.split(" ");
      }

      return new Person(userArr[0], userArr[1], userArr[2], userArr[3]);
   }

   /**
    * метод создает новый объект Scanner.
    * 
    * @return объект типа Scanner.
    */
   private static Scanner extracted() {
      return new Scanner(System.in, "cp866");
   }

   /*
    * класс Person для для хранении и получения данных о пользователе.
    */
   public static class Person {
      public String lastName;
      public String firstName;
      public String patronymic;
      public String phoneNumber;

      public Person(String lastName, String firstName, String patronymic, String phoneNumber) {
         this.lastName = lastName;
         this.firstName = firstName;
         this.patronymic = patronymic;
         this.phoneNumber = phoneNumber;
      }

      @Override
      public String toString() {
         return "<" + lastName + ">" + "<" + firstName + ">" + "<" + patronymic + ">"
               + "<" + phoneNumber + ">\n";
      }

      public String getLastName() {
         return lastName;
      }
   }
}
