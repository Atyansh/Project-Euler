import java.util.*;

class Euler45
{
  public static void main(String arg[])
  {
    int size = 1000000;

    TreeSet<Long> pent = new TreeSet<Long>();
    TreeSet<Long> hex = new TreeSet<Long>();

    long[] triangle = new long[size];

    for(int i = 1; i <= size; i++)
    {
      triangle[i-1] = i*(i+1l)/2l;
      pent.add((long)(i*(3l*i-1l)/2l));
      hex.add((long)i*(2l*i-1l));
    }
    
    /* for(int i = 1; i <= 10; i++)
    {
      System.out.println(i*(i+1)/2);
      System.out.println(i*(3*i-1)/2);
      System.out.println(i*(2*i-1));
    }*/


    for(int i = 285; i < size; i++)
    {
      if(pent.contains(triangle[i]) && hex.contains(triangle[i]))
      {
        System.out.println(triangle[i]);
        break;
      }
    }
  }
}
