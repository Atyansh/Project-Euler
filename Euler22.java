import java.io.*;
import java.util.*;

class Euler22
{
  public static void main(String arg[]) throws IOException
  {
    File file = new File("Euler22.txt");

    BufferedReader br = new BufferedReader(new FileReader(file));

    String name = br.readLine();

    name = name.replaceAll("\"", "");

    String[] names = name.split(",");

    long sum = 0;

    Arrays.sort(names);

    for(int i = 0; i < names.length; i++)
      sum += (i+1) * getValue(names[i]);
    
    System.out.println(sum);
  }

  public static int getValue(String str)
  {
    int length = str.length();
    int sum = 0;

    for(int i = 0; i < length; i++)
      sum += str.charAt(i)-64;

    return sum;
  }
}
