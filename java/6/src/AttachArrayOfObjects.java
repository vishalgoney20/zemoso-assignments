public class AttachArrayOfObjects {

    private String name;
    public AttachArrayOfObjects(String name)
    {
        this.name=name;
        System.out.println("Name: "+name);
    }
    public static void main(String args[])
    {
        AttachArrayOfObjects[] obj=new AttachArrayOfObjects[10];
        for(int i=0;i<10;i++)
        {
            obj[i]=new AttachArrayOfObjects("object at Index:"+i);
        }
    }
}