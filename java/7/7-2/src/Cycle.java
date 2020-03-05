class Cycle {
    Cycle() {
        System.out.println("Cycle : super class");
    }
}

class UniCycle extends Cycle {
    public UniCycle() {
        System.out.println("UniCycle : sub class \n");
    }

    public void balance() {
        System.out.println("Unicycle balance method \n");
    }
}

class BiCycle extends Cycle {
    public BiCycle() {
        System.out.println("BiCycle : sub class \n");
    }

    public void balance() {
        System.out.println("Bicycle balance method \n");
    }
}

class TriCycle extends Cycle {
    public TriCycle() {
        System.out.println("TriCycle : sub class \n");
    }
}

class Main {
    public void tester() throws Exception {
        Cycle[] obj = new Cycle[3];
        obj[0] = new UniCycle();
        obj[1] = new BiCycle();
        obj[2] = new TriCycle();

        //upcast  --- error : Cycle class refernce has no method signature of 'balance'
        //obj[0].balance();
        // obj[1].balance();
        // obj[2].balance();
        System.out.println();
        //downcast
        ((UniCycle) obj[0]).balance();
        ((BiCycle) obj[1]).balance();
    }

    public static void main(String args[]) throws Exception {
        Main mainRef = new Main();
        mainRef.tester();
    }
}