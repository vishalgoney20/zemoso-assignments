import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IO {
    public void charCount(String filename) throws IOException {
        File f = new File(filename);
        FileReader fr = null;
        FileWriter fout = null;
        PrintWriter writer = null;
        try {

            fr = new FileReader(filename);
            HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
            int i;
            char ch = '\0';
            while ((i = fr.read()) != -1) {
                ch = (char) i;
                if (ch != ' ' && ch != '\0' && ch != '\t') {
                    if (!countMap.containsKey(ch))
                        countMap.put(ch, 1);
                    else
                        countMap.put(ch, countMap.get(ch) + 1);
                }
            }
            fout= new FileWriter("result.txt");
            writer=new PrintWriter(fout);
            writer.printf(" Character occurences \n");
            for(Map.Entry<Character,Integer> map:countMap.entrySet())
            {
                writer.printf("  \t"+map.getKey()+"\t \t"+ map.getValue()+"\n");
            }

        }
        catch (Exception e) {
            System.out.println("file not found...");
            e.printStackTrace();
        }
        finally {
            System.out.println("results are stored in results.txt");
            fr.close();
            fout.close();
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        IO io = new IO();
        io.charCount(args[0]);
    }
}
