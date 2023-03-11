package homePets;

import javax.naming.Name;

public class Pet {
  /*
  В классе должны быть:

+enum Kind для вида животного (DOG, CAT, OTHER);
 поля:
"вид животного" (тип Kind),
"кличка" (тип String),
"дата рождения" (тип String),
вес (тип double);
конструктор, сеттеры, геттеры;
статический метод для создания животного при прочтении данных из строки
"dog,кличка", "cat,кличка,вес", "turtle,кличка,вес,дата рождения".
   */
  enum Kind {
    DOG,
    CAT,
    OTHER,
  }

  private Kind type;
  private String name = null;
  private String date = null;
  private Double weight = 0.0;

  public setName(String name) {
    this.name = petName;
  }
  private setDate(String date) { //дата рождения неизменна, поэтому приват?
    this.date = petDate;
  }
  public setWeight(Double weight) {
    this.weight = petWeight;
  }





}
