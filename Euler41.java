import java.util.*;

class Euler41
{
  public static void main(String[] arg)
  {
    int max = 0;
    int num;

    for(int i = 101; i < 1000000000; i += 2)
    {
      if(isPandigital(i) && isPrime(i))
        max = i;
    }

    System.out.println(max);
  }


  public static boolean isPrime(int n)
  {
    int sqrt = (int) Math.sqrt(n);

    for(int i = 3; i <= sqrt; i+= 2)
      if(n % i == 0)
        return false;

    return true;
  }


  public static boolean isPandigital(int n)
  {
    TreeSet<Integer> digits = new TreeSet<Integer>();
    int num = n;
    int count = 0;

    while(num != 0)
    {
      count++;
      num /= 10;
    }

    while(n != 0)
    {
      if(!(n % 10 <= count && n % 10 > 0 && digits.add(n % 10)))
        return false;
      n /= 10;
    }

    return true;
  }
}
