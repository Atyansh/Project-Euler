import java.math.*;

class Euler16
{
  public static void main(String arg[])
  {
    BigInteger b = new BigInteger("2");

    for(int i = 2; i <= 1000; i++)
    {
      b = b.add(b);
    }

    String s = b.toString();
    int length = s.length();
    int sum = 0;

    for(int i = 0; i < length; i++)
      sum += (s.charAt(i) - 48);
    
    System.out.println(sum);
  }
}
