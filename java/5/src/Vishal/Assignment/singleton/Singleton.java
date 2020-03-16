package Vishal.Assignment.singleton;

import java.util.logging.Logger;

public class Singleton {
    private static Logger logger = Logger.getLogger(Singleton.class.getName());

    String message;

    /**
     * @param message takes message string as input
     * @return singleton i.e, object of the class
     */
    public static Singleton setMessage(String message) {
        Singleton singleton = new Singleton();
        singleton.message = message;
        return singleton;
    }

    public void getMessage() {
        logger.info(message);
    }
}
