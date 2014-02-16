import java.util.*;

class Euler44
{
  public static void main(String arg[])
  {
    int min = Integer.MAX_VALUE;

    int[] arr = new int[10000];
    int sum, diff;

    TreeSet<Integer> pent = new TreeSet<Integer>();

    for(int i = 1; i <= 10000; i++)
    {
      arr[i-1] = i*(3*i-1)/2;
      pent.add(arr[i-1]);
    }

    for(int i = 0; i < 10000; i++)
    {
      for(int j = i+1; j < 10000; j++)
      {
        sum = arr[i]+arr[j];
        diff = arr[j] - arr[i];

        if(min < diff)
          continue;

        if(pent.contains(sum) && pent.contains(diff))
          min = diff;
      }
    }

    System.out.println(min);
  }

  public static int pentagon(int n)
  {
    return n*(3*n-1)/2;
  }
}
