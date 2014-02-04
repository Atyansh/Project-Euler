import java.io.*;
import java.util.*;

class Euler22
{
  public static void main(String arg[]) throws IOException
  {
    File file = new File("Euler22.txt");

    Scanner scan = new Scanner(file);

    scan.useDelimiter("\",\"");

    String[] names;

    int size = 0;

    long sum = 0;

    while(scan.hasNext())
    {
      scan.next();
      size++;
    }

    names = new String[size];

    scan.close();
    
    scan = new Scanner(file);
    scan.useDelimiter("\",\"");

    for(int i = 0; i < size; i++)
      names[i] = scan.next();

    names[0] = names[0].substring(1, names[0].length());
    names[size-1] = names[size-1].substring(0, names[size-1].length()-1);

    Arrays.sort(names);

    for(int i = 0; i < size; i++)
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
