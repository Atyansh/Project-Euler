import java.math.BigInteger;

class Euler55
{
  public static void main(String[] arg)
  {
    int count = 0;

    int num = 11;
    BigInteger regular;
    BigInteger reverse;

outer:while(num < 10000)
    {
      num++;
      regular = new BigInteger("" + num);

      for(int i = 0; i < 50; i++)
      {
        reverse = reverse(regular.toString());

        regular = regular.add(reverse);

        if(palindrome(regular.toString()))
          continue outer;
      }

      count++;
    }

    System.out.println(count);
  }

  public static BigInteger reverse(String num)
  {
    int length = num.length();
    String reverse = "";

    for(int i = length-1; i >= 0; i--)
      reverse += num.charAt(i);

    return new BigInteger(reverse);
  }

  public static boolean palindrome(String num)
  {
    int length = num.length();

    for(int i = 0; i < length/2; i++)
      if(num.charAt(i) != num.charAt(length-i-1))
        return false;

    return true;
  }
}
