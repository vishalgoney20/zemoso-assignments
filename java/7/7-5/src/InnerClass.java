class Outer {
    Outer() {
        System.out.println("outer class constructor");
    }

    class Inner {
        Inner(int a) {
            System.out.println("inner class parameterized constructor ");
            System.out.println("The paramter Value is " + a);
        }
    }
}

class Outer1
{
    Outer1(){

    }
    class Inner1 extends Outer.Inner{
        int a;
        Inner1(int a) {
           new Outer().super(a);
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        new Outer1().new Inner1(1);
    }
}
