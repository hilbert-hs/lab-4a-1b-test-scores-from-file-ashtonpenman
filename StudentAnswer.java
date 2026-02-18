public class StudentAnswer{

    private String studentName;
    private String[] answers = new String[14];

    public StudentAnswer(String studentName, String[] ans){
        this.studentName = studentName;
        this.answers = new String[ans.length];
        for(int i = 0; i < ans.length; i++){
            this.answers[i] = ans[i];
        }
    }
    public String getName(){
        return studentName;
    }

    public String[] getAnswers(){
        return answers;
    }


}