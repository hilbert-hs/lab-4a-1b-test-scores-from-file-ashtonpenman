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
        String name = line[0];
        String[] tempAnswers = new String[line.length-1];
        for(int j = 1; j < line.length; j++){
          tempAnswers[j-1] = line[j];
        }
        studentAnswers[i] = new StudentAnswer(name, tempAnswers);
        i++;
      }
      scan.close();
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  // instance methods
  public StudentAnswer[] getStudentAnswers(){
    return studentAnswers;
  }

  public int totalCorrect(String name){
    int correct = 0;
    for(StudentAnswer student : studentAnswers){
      if(student.getName().equals(name)){
        String[] answers = student.getAnswers();
        for (int i = 0; i < answers.length; i++){
          if(answers[i].toUpperCase().equals(answerKey[i])){
            correct++;
          }
        }
      }
      }
      return correct;
  }

  public int totalMistakes(String name){
    return -totalCorrect(name) + 20;
  }

  public boolean isPassing(String name){
    return totalCorrect(name) >= 14;
  }
  
}


