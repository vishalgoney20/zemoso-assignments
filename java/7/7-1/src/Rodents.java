abstract class Rodents
{
    public Rodents()
    {
        System.out.println("This is Rodents abstract class");
    }
    abstract public void eat();
    abstract public void about();
}

class Mouse extends Rodents
{
    public Mouse()
    {
        System.out.println("This is mouse");
    }
    public void eat()
    {
        System.out.println("I like to eat fruits, seeds and grains.");
    }
    public void about()
    {
        System.out.println("I have legs with tail and i'm a family of rodents");
    }
}

class Gerbil extends Rodents
{
    public Gerbil()
    {
        System.out.println("This is Gerbil");
    }
    public void eat()
    {
        System.out.println("I like to eat seeds of various grasses,leaves and herbs , Fruits ,vegetables ");
    }
    public void about()
    {
        System.out.println("I have long tail .");
    }
}

class Hamster extends Rodents
{
    public Hamster()
    {
        System.out.println("This is Hamster");
    }
    public void eat()
    {
        System.out.println("I like to eat nuts, cracked corn .....");
    }
    public void about()
    {
        System.out.println("I'm rodent belonging to the subfamily Cricetinae. ");
    }
}


class Main
{
    public void tester()
    {
        Rodents[] obj=new Rodents[3];
        obj[0]=new Mouse();
        obj[0].eat();
        obj[0].about();
        System.out.println("\n");
        obj[1]=new Gerbil();
        obj[1].eat();
        obj[1].about();
        System.out.println("\n");
        obj[2]=new Hamster();
        obj[2].eat();
        obj[2].about();
    }

    public static void main(String args[])
    {
        Main mainRef=new Main();
        mainRef.tester();

    }
}