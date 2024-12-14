import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class QuizRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuizRoom extends Room
{
    private boolean completed = false;
    private String quiz;
    private ArrayList<String> answers;
    private int ans;
    
    public QuizRoom(int i, int a) {super(i); ans = a;}
    
    public void setAnswers(ArrayList<String> lis) {answers = lis;}
    
    public void setQuiz(String s) {quiz = s;}
    
    public void activateRoom() {
        Scanner inp = new Scanner(System.in);
        
    }
    
}
