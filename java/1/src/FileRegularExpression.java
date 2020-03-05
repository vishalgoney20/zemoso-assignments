import java.io.File;
import java.util.*;
import java.util.regex.*;

public class FileRegularExpression {
    public void findFilePath(File path, String expression) throws NullPointerException {
        if(path.listFiles() == null)
            return;
        for (File file : path.listFiles()) {
            if(file.isDirectory()) {
                findFilePath(file, expression);
            }
            else if (Pattern.matches(expression, file.getName()))
                System.out.println(file.getAbsolutePath());
        }

    }

    public static void main(String[] args) {

        FileRegularExpression file = new FileRegularExpression();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the regular expression that a filename to match or press q to quit");
            String expression = sc.nextLine();
            if (expression == "q")
                break;
            else
                file.findFilePath(new File(System.getProperty("user.home")), expression);
        }
    }
}
//  .*/*.java