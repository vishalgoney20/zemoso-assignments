public class MethodOverload {
    MethodOverload(String s) {
        System.out.println("The parameter String is " + s);
    }
    MethodOverload(int a,String s)
    {
        this(s);
        System.out.println("Value of a is:"+a);
        System.out.println("Value of s is:"+s);
    }

    public static void main(String[] args) {
        MethodOverload methodOverload = new MethodOverload(2,"This is text...");
    }
}