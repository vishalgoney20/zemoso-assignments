package Vishal.Assignment.main;

import Vishal.Assignment.data.Data;
import Vishal.Assignment.singleton.Singleton;

public class Main {

    /**
     * creates instance of data class and invokes printVariables method
     * creates instance of Singleton class and invokes setter and getter methods
     */
    public static void main(String[] args) {
        Data data = new Data();
        data.printVariables();

        Singleton singleton = Singleton.setMessage("This is String");
        singleton.getMessage();
    }
}
