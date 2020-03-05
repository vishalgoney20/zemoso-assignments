public class ArrayOfObjects {
    ArrayOfObjects(String objMessage)
    {
        System.out.println(objMessage);
    }
    public static void main(String[] args) {
        for(int i=0;i<5;i++)
        {
            new ArrayOfObjects("Obj :"+i);
        }
    }
}
