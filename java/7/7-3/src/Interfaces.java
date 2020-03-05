interface Development {
    void develop1();

    void develop2();
}

interface Test {
    void test1();

    void test2();
}

interface Automate {
    void automate1();

    void automate2();
}

interface Integrate extends Development, Test, Automate {
    void integrate();
}

class JoiningLocation {
    String location = "Hyderabad";

    String getLocation() {
        return this.location;
    }
}

class Employee extends JoiningLocation implements Integrate {
    public void integrate() {
        System.out.println("Method from Integrate interface ");
    }

    public void develop1() {
        System.out.println("Method from Development interface : method 1 ");
    }

    public void develop2() {
        System.out.println("Method from Development interface : method 2");
    }

    public void test1() {
        System.out.println("Method from Test interface : method 1");
    }

    public void test2() {
        System.out.println("Method from Test interface : method 2");
    }

    public void automate1() {
        System.out.println("Method from Automate interface : method 1");
    }

    public void automate2() {
        System.out.println("Method from Automate interface : method 2");
    }
}

public class Interfaces {
    public static void m1(Development d) {
        d.develop1();
        d.develop2();
    }

    public static void m2(Test t) {
        t.test1();
        t.test2();
    }

    public static void m3(Automate a) {
        a.automate1();
        a.automate2();
    }

    public static void m4(Integrate i) {
       i.integrate();
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        m1(employee);
        System.out.println();
        m2(employee);
        System.out.println();
        m3(employee);
        System.out.println();
        m4(employee);
    }
}
