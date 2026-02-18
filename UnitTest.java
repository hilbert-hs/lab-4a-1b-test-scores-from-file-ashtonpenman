import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnitTest {

  // instance variables
  private String[] answerKey = {"B", "D", "C", "A", "E", "A", "B", "A", "E", "B", "B", "E", "E", "D", "D", "A", "C", "C", "A", "E" };
  private StudentAnswer[] studentAnswers = new StudentAnswer[14];
  // constructor
  public UnitTest(String csv) throws FileNotFoundException{
    File f = new File(csv);
    try{
      Scanner scan = new Scanner(f);
      scan.nextLine();
      int i = 0;
      while(scan.hasNext()) {
        String[] line = scan.nextLine().split(",");
        String[] tempAnswers = new String[line.length-1];
        for(int j = 1; j < line.length; j++){
          tempAnswers[j] = line[j];
        }
        studentAnswers[i] = new StudentAnswer(line[0], tempAnswers);
        i++;
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  // instance methods
  // private int findNumStudents(Scanner s) {
  //   int i = 0;
  //   while(s.hasNext()) {
  //     s.nextLine();
  //     i++;
  //   }
  //   return i-1;
  // }

  
}


