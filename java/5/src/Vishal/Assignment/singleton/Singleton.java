package Vishal.Assignment.singleton;

public class Singleton {
    String message;
    public static Singleton setMessage(String message)
    {
        Singleton singleton=new Singleton();
        singleton.message=message;
        return singleton;
    }
    public void getMessage()
    {
        System.out.println(message);
    }
}
