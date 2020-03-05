import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    public boolean matchSentence(String sentence) {
        if (Pattern.matches("^[A-Z].*[.]", sentence))
            return true;
        else
            return false;
    }

    public void tester() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the sentence to match or q to quit");
            String sentence = sc.next();
            if (sentence.equals("q"))
                break;
            boolean result = matchSentence(sentence);
            System.out.println((result == true) ? "The sentence begins with capital letter and ends with period" :
                    "The sentence doesn't begins with capital letter and doesn't ends with period");
        }
    }

    public static void main(String[] args) {
        Regex regex = new Regex();
        regex.tester();
    }
}
