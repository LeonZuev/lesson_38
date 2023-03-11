import students.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static students.Student.readFile;

public class Main {
  public static void main(String[] args) throws IOException {
    List<Map<String, String>> students = readFile();
    System.out.println();
  }
}