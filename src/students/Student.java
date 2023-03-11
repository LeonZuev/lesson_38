package students;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import  java.util.Map;

public class Student {

  // статический - общий для всех студентов - счётчик
  private static int counter = 0;

  // final - нельзя менять
  // private - доступен только внутри студента
  // static - общий для всех студентов
  final private static char SEP = ','; // определяем разделитель как символ запятой

  // final, потому что id у студента не меняется
  // не static, потому что у каждого студента свой
  final private int id; // идентификатор студента, должен заполняться автоматически
  // у каждого студента должен быть свой идентификатор
  private String name;
  private String group;
  private String eMail;

  public Student(String name, String group) {
    this.id = ++counter; // увеличиваем и записываем в id увеличенное значение
    this.name = name;
    this.group = group;
    this.eMail = null; // eMail'а нет
  }

  public Student(String name, String group, String eMail) {
    ++counter;
    this.id = counter;
    this.name = name;
    this.group = group;
    this.eMail = eMail;
  }
  // Добавить в базу данных студентов чтение данных из файла.
  public static List<Map<String, String>> readFile() throws IOException {
    List<Map<String, String>> studentsRecords = new ArrayList<>();

    try {
      File newFile = new File("~/IdeaProjects/lesson_38/lesson_38/res/studentsNames.txt"); //
      // создаём путь к файлу
      BufferedReader br = new BufferedReader(new FileReader(newFile));//читаем

      for (String line = br.readLine(); line!=null; line = br.readLine()) {
        int lastStep = line.lastIndexOf(SEP);
        String name = line.substring(0, lastStep);
        String group = line.substring(lastStep + 1, line.lastIndexOf(SEP));
        String eMail = line.substring(line.lastIndexOf(SEP) + 1);

        Map<String, String> entry = new HashMap<>();
        entry.put("name", name);
        entry.put("group", group);
        entry.put("eMail", eMail);
        studentsRecords.add(entry);
        System.out.println();
      }

      br.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }
    return studentsRecords;
  }

  public String getName() {
    return name;
  }

  public String getGroup() {
    return group;
  }

  public String getEMail() {
    return eMail;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setEMail(String eMail) {
    this.eMail = eMail;
  }

  // фабричный метод - производит объект из чего-то
  // - прочитать информацию о студентах - "имя" или "имя,e-mail" для каждого в отдельной строке
  // и вернуть получившегося студента
  // метод статический - вызывается сам по себе и возвращает нового прочитанного студента
  public static Student parseStudent(String group, String line) {
    int sepIndex = line.indexOf(SEP); // ищем запятую в переданной строке
    if (sepIndex != -1) {
      String name = line.substring(0, sepIndex);
      String eMail = line.substring(sepIndex + 1); // начинаем ПОСЛЕ разделителя
      return new Student(name, group, eMail);
    }
    // запятой нет - в строке line только имя
//    String name = line;
    return new Student(/*name*/line, group);
  }
}
