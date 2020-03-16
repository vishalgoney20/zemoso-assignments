/* Assignment -2
Question: Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
Write time and space complexity of your solution as comments in the source file.
Time Complexity : worst case : O(n)  , n=length of the input String
                  best case  : O(n)  , n=26
Space Complexity :O(1)
*/

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class StringCheck {
    private static Logger logger = Logger.getLogger(StringCheck.class.getName());

    /**
     * checks whether the given string contains alphabets or not.
     *
     * @param str string (combination of alphabets and letters ) that need to be checked.
     * @return True if contains all the alphabets , False if doesn't
     */
    public boolean check(String str) {
        /*int[] arr = new int[26];
        int count = 0;
        int index;
        for (char ch : str.toCharArray()) {
            ch = Character.toLowerCase(ch);
            index = ch - 'a';
            if (!(arr[index] > 0)) {
                arr[index]++;
                count++;
            }
            if (count == 26)
                break;
        }

         */

        int count1= (int) str.toLowerCase().chars().filter(c->c>='a'&&c<='z').distinct().count();
        if (count1 == 26)
            return true;
        return false;
    }

    /**
     * method to take input and invoke check method.
     */
    public void checkIfAllAlphabetsExist() {
        Scanner sc = new Scanner(System.in);
        logger.info("Enter the String to check whether it contains all the alphabets or not");
        String inputString = sc.next();
        boolean result = check(inputString);
        if (result == true)
            logger.info(inputString + " contains all alphabets");
        else
            logger.info(inputString + " doesn't contains all alphabets");
    }


    public static void main(String[] args) {
        StringCheck str = new StringCheck();
        str.checkIfAllAlphabetsExist();
    }
}
