class Euler21
{
  public static void main(String arg[])
  {

    int sum1 = 0;
    int sum2 = 0;
    int sum = 0;

    for(int i = 100; i < 10000; i++)
    {
      for(int j = 1; j <= i/2; j++)
        if(i % j == 0)
          sum1 += j;

      for(int j = 1; j <= sum1/2; j++)
        if(sum1 % j == 0)
          sum2 += j;

      if(sum2 == i && sum1 != i)
        sum += i;

      sum1 = 0;
      sum2 = 0;
    }

    System.out.println(sum);
  }
}       
