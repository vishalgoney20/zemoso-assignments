import java.util.Scanner;

class Exception1 extends Exception
{
    public Exception1(String s)
    {
        super(s);
    }
}
class Exception2 extends Exception
{
    public Exception2(String s)
    {
        super(s);
    }
}
class Exception3 extends Exception
{
    public Exception3(String s)
    {
        super(s);
    }
}
public class ThreeExceptions {

    public void exceptionCheck(int a,int b,float c) throws Exception1, Exception2, Exception3 {
        try {
            if (a > 0)
                throw new Exception1("Positive value exception");
            if (b < 0)
                throw new Exception2("Negative value exception");
            if (c != 10)
                throw new Exception3("Floating point exception");
            String s1=null;
            s1.equals("vishal");
        }
        catch(Exception1|Exception2|Exception3 e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("Finally block executed......");
        }
    }

    public void tester() throws Exception3, Exception2, Exception1 {
        int a,b,c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a,b,c as a<0 b>0 c==10 :");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        exceptionCheck(a,b,c);
    }
    public static void main(String[] args) throws Exception3, Exception2, Exception1 {
        ThreeExceptions exceptions=new ThreeExceptions();
        exceptions.tester();
    }
}
