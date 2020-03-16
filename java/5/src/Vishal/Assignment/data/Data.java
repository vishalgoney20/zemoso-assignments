package Vishal.Assignment.data;

import Vishal.Assignment.singleton.Singleton;

import java.util.logging.Logger;

public class Data {
    int a;
    char b;
    private static Logger logger = Logger.getLogger(Data.class.getName());

    /**
     * prints the values of a and b.
     */
    public void printVariables() {
        logger.info(String.valueOf(a));
        logger.info(String.valueOf(b));
    }

    // Local variables must be initialized in java..
    // There is no garbage values concept in java.
    /*
    public void printLocalVariables()
    {
        int a;
        char b;
        System.out.println(a);
        System.out.println(b);

    }
     */
}
