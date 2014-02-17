import java.util.*;

class Euler49
{
  public static void main(String arg[])
  {
    String str, prev;
    char[] arr;
    int count;
    int value;
    int diff;
    int prevValue;
    String nextDiff;

    for(int i = 1001; i < 9999; i += 2)
    {
      //System.out.println(i);
      if(isPrime(i))// && uniqueDigits(i))
      {
        str = "" + i;
        prev = str;
        nextDiff = str;

        arr = str.toCharArray();
        Euler24.next(arr, 3);
        
        while(!nextDiff.equals(new String(arr)))
        {
          str = "" + i;
          count = 1;
          diff = Integer.parseInt(new String(arr)) - i;
          prevValue = i;
          nextDiff = new String(arr);

          while(!prev.equals(new String(arr)))
          {
            value = Integer.parseInt(new String(arr));
            if(isPrime(Integer.parseInt(new String(arr))))
            {
              if((value - prevValue) == diff)
              {
                count++;
                str += new String(arr);
                prevValue = value;
              }
            }

            prev = new String(arr);
            Euler24.next(arr,3);
          }

          if(count >= 3)
            System.out.println(str);

          arr = nextDiff.toCharArray();
          Euler24.next(arr, 3);
        }
      }
    }
  }

  public static boolean isPrime(int n)
  {
    if(n % 2 == 0)
      return false;

    int sqrt = (int) Math.sqrt(n);

    for(int i = 3; i <= sqrt; i+=2)
      if(n % i == 0)
        return false;

    return true;
  }

  public static boolean uniqueDigits(int n)
  {
    TreeSet<Integer> digits = new TreeSet<Integer>();

    while(n != 0)
    {
      if(!digits.add(n % 10))
        return false;
      n /= 10;
    }

    return true;
  }
}
