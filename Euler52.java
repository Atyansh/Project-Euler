import java.util.*;

class Euler52
{
  public static void main(String arg[])
  {
    TreeSet<Integer> digits;

    int i = 1;
    int num;
    int count;


a:  while(true)
    {
      digits = new TreeSet<Integer>();

      num = i;

      while(num != 0)
      {
        digits.add(num % 10);
        num /= 10;
      }
      
      count = 2;

      while(count <= 6)
      {
        num = i * count;

        while(num != 0)
        {
          if(digits.add(num % 10))
          {
            i++;
            continue a;
          }
          num /= 10;
        }
        count++;
      }

      break;
    }

    System.out.println(i);
  }
}
