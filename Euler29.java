import java.util.*;
import java.math.*;

class Euler29
{
  public static void main(String[] arg)
  {
    TreeSet<BigInteger> set = new TreeSet<BigInteger>();

    BigInteger A = new BigInteger("2");
    BigInteger inc = new BigInteger("1");

    for(int a = 2; a < 101; a++, A = A.add(inc))
      for(int b = 2; b < 101; b++)
        set.add(A.pow(b));

    int size = set.size();

    System.out.println(size);
  }
}
