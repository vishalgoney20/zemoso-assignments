import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class Range {
    private static Logger logger = Logger.getLogger(Range.class.getName());

    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");


    /**
     * The date will be splitted based on '-' .
     *
     * @param date specifies the date i.e, signUp date or Current date.
     * @return arr that contains date , month and year .
     */
    public int[] textSplit(String date){
        String[] splittedText = date.split("-");
        int[] arr = new int[3];
        int index = 0;
        for (String dateText : splittedText) {
            arr[index++] = Integer.parseInt(dateText);
        }
        return arr;
    }


    /**
     * calculates the range within +30 or -30 to the date of anniversary.
     * The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
     *
     * @param testCases number of tests to calculate Range.
     * @throws IOException it is thrown when an input or output operation is failed i.e, readLine() method throws IOException.
     */

    public void calculateRange(int testCases)  {

        while (testCases > 0) {
            String text[] = new String[0];
            try {
                text = bufferedReader.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Calendar signUpDate = Calendar.getInstance();
            Calendar currentDate = Calendar.getInstance();

            int[] signUp=textSplit(text[0]);

            signUpDate.set(Calendar.DATE, signUp[0]);
            signUpDate.set(Calendar.MONTH, signUp[1] - 1);
            signUpDate.set(Calendar.YEAR, signUp[2]);

            int[] current=textSplit(text[1]);

            currentDate.set(Calendar.DATE, current[0]);
            currentDate.set(Calendar.MONTH, current[1] - 1);
            currentDate.set(Calendar.YEAR, current[2]);


            if (signUpDate.getTime().after(currentDate.getTime())) {
                logger.info("No range");
                testCases = testCases - 1;
                continue;
            }
            signUpDate.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));

            signUpDate.add(Calendar.DATE, -30);
            logger.info(sdf.format(signUpDate.getTime()));
            signUpDate.add(Calendar.DATE, +60);

            displayRange(signUpDate,currentDate);
            testCases = testCases - 1;
        }
    }

    /**
     * displays the Range of dates for KYC
     *
     * @param signUpDate
     * @param currentDate
     * The KYC form can be filled in between those days.
     *  */

    public void displayRange(Calendar signUpDate,Calendar currentDate){

        if (signUpDate.getTime().after(currentDate.getTime()))
            logger.info(sdf.format(currentDate.getTime()));
        else
            logger.info(sdf.format(signUpDate.getTime()));
    }


    /**
     * Input for no of testCases is taken and invokes calculateRange method
     *
     * @throws IOException it is thrown when an input or output operation is failed i.e, readLine() method throws IOException.
     */
    public void testCalculateRange()  {
        System.out.println("Enter no of test cases ");
        int testCases = 0;
        try {
            testCases = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        calculateRange(testCases);
    }

    public static void main(String[] args)  {
        Range range = new Range();
        range.testCalculateRange();
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