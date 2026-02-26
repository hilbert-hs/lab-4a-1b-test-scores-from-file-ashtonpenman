import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) throws FileNotFoundException{
    UnitTest test = new UnitTest("student-answers.csv");
    System.out.println(test.totalCorrect("Amari"));
    System.out.println(test.totalMistakes("Amari"));
    System.out.println(test.isPassing("Amari"));
    double totalCorrect = 0;
    double totalMistakes = 0;
    String studentPass = "";
    String studentFail = "";
    for(StudentAnswer student : test.getStudentAnswers()){
      System.out.println(student.getName() + ": " + test.totalCorrect(student.getName()) + " correct. Passed: " + test.isPassing(student.getName()));
      totalCorrect += test.totalCorrect(student.getName());
      totalMistakes += test.totalMistakes(student.getName());
      if(test.isPassing(student.getName())) studentPass += student.getName() + " ";
      else studentFail += student.getName() + " ";

    }
    System.out.println("Average number of correct answers:" + totalCorrect/14);
    System.out.println("Average number of incorrect answers:" + totalMistakes/14);
    System.out.println("Students that passed: " + studentPass);
    System.out.println("Students that failed: " + studentFail);
  }
}
