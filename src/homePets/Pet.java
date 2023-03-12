package homePets;

import javax.naming.Name;
import java.io.BufferedReader;

public class Pet {
  /*
  В классе должны быть:

+enum Kind для вида животного (DOG, CAT, OTHER);
 поля:
+"вид животного" (тип Kind),
+"кличка" (тип String),
+"дата рождения" (тип String),
+вес (тип double);
конструктор, +сеттеры, +геттеры;
статический метод для создания животного при прочтении данных из строки
"dog,кличка", "cat,кличка,вес", "turtle,кличка,вес,дата рождения".
   */
  // атрибуты
  enum Kind {
    DOG,
    CAT,
    OTHER,
  }

  private Kind type;
  private String name = null;
  private String date = null;
  private Double weight = 0.0;

  //вопрос по сеттерам

  public void setName(String name) {
    this.name = name;
  }
  private void setDate(String date) { //дата рождения неизменна, поэтому приват?
    this.date = date;
  }
  public void setWeight(Double weight) {
    if (weight < 0){
      System.out.println("Вес не может быть отрицательным: " + weight);
      return;
    }
    this.weight = weight;
  }

  public Kind getType() {
    return type;
  }
  public String getName() {
    return name;
  }
  public String getDate() {
    return date;
  }
  public Double getWeight() {
    return weight;
  }
  /*
  статический метод для создания животного при прочтении данных из строки
  "dog,кличка", "cat,кличка,вес", "turtle,кличка,вес,дата рождения".
   */

  final private static char SEP = ',';
  public static Pet parsePet(String str) {
    int sepIndex = line.indexOf(SEP);
    if (sepIndex != -1) {
      String name = line.substring(0, sepIndex);
      String date = line.substring(sepIndex+1, line.lastIndexOf(SEP));
      return new Pet(name, date, weight);
    }
  }







}
