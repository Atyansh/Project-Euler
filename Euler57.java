import java.math.BigInteger;

class Euler57
{
  public static void main(String[] arg)
  {
    BigInteger num = new BigInteger("" + 1);
    BigInteger den = new BigInteger("" + 2);
    
    BigInteger temp;

    int count = 0;

    for(int i = 0; i < 1000; i++)
    {
      if(num.add(den).toString().length() > den.toString().length())
        count++;

      temp = num.add(den.add(den));
      num = den;
      den = temp;
    }

    System.out.println(count);
  }
}
