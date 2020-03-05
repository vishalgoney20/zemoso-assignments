import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class FileRegularExpression {
    public void findFilePath(String path, String expression) throws NullPointerException {
        try {
            File folder = new File(path);
            for (File file : folder.listFiles()) {
                if (file.isDirectory())
                    findFilePath(file.getAbsolutePath(), expression);
                if (Pattern.matches(expression, file.getName()))
                    System.out.println(file.getAbsolutePath());
            }
        }
        catch(Exception e){
            System.out.println(e);
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
                file.findFilePath("/home/", expression);
        }
    }
}
