import java.util.Arrays;
import java.util.HashMap;

public class Vampire {

    public boolean check(int num,int i,int j)
    {
        String s1=Integer.toString(num);
        String s2=Integer.toString(i);
        String s3=Integer.toString(j);
        if((s2.length()!=s1.length()/2)||(s2.length()!=s1.length()/2))
            return false;
        if(s2.charAt(s2.length()-1)=='0'&&s3.charAt(s3.length()-1)=='0')
            return false;

        char[] arr1=s1.toCharArray();
        String s4=s2+s3;
        char[] arr2=s4.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1,arr2))
            return true;
        else
            return false;
    }
    public HashMap<Integer,Integer> calculateNumbers()
    {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        int num=10;
        int count=1;
        while(true)
        {
            String s=Integer.toString(num);
            if((s.length()%2)!=0)
            {
                num++;
              continue;
            }
            for(int i=1;i<Math.sqrt(num);i++)
            {
                int j=num/i;
                if(num%i==0)
                {
                    if(check(num,i,j))
                    {
                        map.put(count,num);
                        count++;
                        break;
                    }
                }
            }
            num++;
            if(map.size()==100)
                break;
        }
        return map;
    }

    public void tester()
    {
        HashMap<Integer,Integer> result=calculateNumbers();
        System.out.println("First 100 Vampire numbers are...");
        for(Integer i:result.keySet())
        {
            System.out.println(i+" : "+result.get(i));
        }
    }
    public static void main(String[] args) {
        Vampire vampire=new Vampire();
        vampire.tester();

    }
}
