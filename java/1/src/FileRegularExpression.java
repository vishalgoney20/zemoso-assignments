import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class FileRegularExpression {
    private static Logger logger = Logger.getLogger(FileRegularExpression.class.getName());

    /**
     * finds the path of the file that matches the filename with the mentioned regular expression.
     *
     * @param path       home directory path to start with
     * @param expression a regular expression to match with
     */
    public void findFilePath(File path, String expression) {
        if (path.listFiles() == null)
            return;
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                findFilePath(file, expression);
            } else if (Pattern.matches(expression, file.getName()))
                logger.info(file.getAbsolutePath());
        }
    }

    /**
     * main method execution starts from here i.e, instance of a class is created and findFilePath method is invoked.
     */

    public static void main(String[] args) {

        FileRegularExpression file = new FileRegularExpression();
        Scanner sc = new Scanner(System.in);
        while (true) {
            logger.info("Enter the regular expression that a filename to match or press q to quit");
            String expression = sc.nextLine();
            if (expression == "q")
                break;
            else
                file.findFilePath(new File(System.getProperty("user.home")), expression);
        }
    }
}

// sample expression ->  .*/*.java