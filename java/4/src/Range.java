import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class Range {
    private static Logger logger = Logger.getLogger(Range.class.getName());

    InputStreamReader i = new InputStreamReader(System.in);
    BufferedReader b = new BufferedReader(i);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");

    /**
     * calculate the range within +30 or -30 to the date of anniversary.
     *
     * @param testCases number of tests to calculate Range.
     * @throws IOException it is thrown when an input or output operation is failed.
     */

    public void calculateRange(int testCases) throws IOException {

        while (testCases > 0) {
            String text[] = b.readLine().split(" ");
            Calendar signupDate = Calendar.getInstance();
            Calendar currentDate = Calendar.getInstance();

            String[] text1 = text[0].split("-");
            int[] arr = new int[3];
            int i = 0;
            for (String s : text1) {
                arr[i++] = Integer.parseInt(s);
            }

            signupDate.set(Calendar.DATE, arr[0]);
            signupDate.set(Calendar.MONTH, arr[1] - 1);
            signupDate.set(Calendar.YEAR, arr[2]);

            String[] text2 = text[1].split("-");
            int[] arr1 = new int[3];
            i = 0;
            for (String s : text2) {
                arr1[i++] = Integer.parseInt(s);
            }

            currentDate.set(Calendar.DATE, arr1[0]);
            currentDate.set(Calendar.MONTH, arr1[1] - 1);
            currentDate.set(Calendar.YEAR, arr1[2]);


            if (signupDate.getTime().after(currentDate.getTime())) {
                logger.info("No range");
                continue;
            }
            signupDate.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));

            signupDate.add(Calendar.DATE, -30);
            logger.info(sdf.format(signupDate.getTime()));
            signupDate.add(Calendar.DATE, +60);

            if (signupDate.getTime().after(currentDate.getTime()))
                logger.info(sdf.format(currentDate.getTime()));
            else
                logger.info(sdf.format(signupDate.getTime()));

            testCases = testCases - 1;
        }
    }

    /**
     * invokes calculateRange method
     *
     * @throws IOException it is thrown when an input or output operation is failed.
     */
    public void tester() throws IOException {
        System.out.println("Enter no of test cases ");
        int testCases = Integer.parseInt(b.readLine());
        calculateRange(testCases);
    }

    public static void main(String[] args) throws IOException {
        Range range = new Range();
        range.tester();
    }
}
/*
Sample io

Input:

5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016

Output :

16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016

 */