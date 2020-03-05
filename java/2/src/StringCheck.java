/* Assignment -2
Question: Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
Write time and space complexity of your solution as comments in the source file.
Time Complexity : worst case : O(n)  , n=length of the input String
                  best case  : O(n)  , n=26
Space Complexity :O(1)
*/

import java.util.Scanner;

public class StringCheck {
    public boolean check(String str) {
        int[] arr = new int[26];
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
        if (count == 26)
            return true;
        return false;
    }

    public void tester() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to check whether it contains all the alphabets or not");
        String inputString = sc.next();
        boolean result = check(inputString);
        if (result == true)
            System.out.println(inputString + " contains all alphabets");
        else
            System.out.println(inputString + " doesn't contains all alphabets");
    }

    public static void main(String[] args) {
        StringCheck str = new StringCheck();
        str.tester();
    }
}
