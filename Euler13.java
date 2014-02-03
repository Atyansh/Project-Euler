import java.io.*;
import java.util.*;
import java.math.*;

class Euler13
{
  public static void main(String arg[]) throws IOException
  {
    File file = new File("Euler13.txt");

    Scanner scan = new Scanner(file);

    BigInteger b = new BigInteger("0");

    while(scan.hasNext())
    {
      b = b.add(scan.nextBigInteger());
    }

    System.out.println(b.toString());
  }

}
