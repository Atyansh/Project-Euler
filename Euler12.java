import java.util.*;

class Euler12
{
  public static void main(String arg[])
  {
    long n = 1;
    long triangle = 0;
    long value = 0;

    while(value < 500)
    {
      triangle += n;
      n++;
      //System.out.println(triangle);
      value = countFactors(triangle);
    }

    System.out.println(triangle);
  }


  public static long countFactors(long n)
  {
    long count = 1;
    long i = 3;
    long freq = 0;
    long next;

    LinkedList<Long> list = new LinkedList<Long>();

    while(n % 2 == 0)
    {
      n /= 2;
      freq++;
    }
    if(freq != 0)
      list.add(freq);
    
    freq = 0;

    while(n > 1)
    {
      while(n % i == 0)
      {
        n /= i;
        freq++;
      }
      
      if(freq != 0)
        list.add(freq);
      freq = 0;
      i += 2;
    }


    Iterator<Long> it = list.iterator();

    while(it.hasNext())
    {
      next = it.next();
      count *= (next+1);
    }

    //System.err.println(count);
    return count;
  }
    

}
