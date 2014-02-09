class Euler34
{
  public static void main(String[] arg)
  {
    int[] fact = new int[10];
    int num;
    long sum = 0;
    long curious = 0;

    fact[0] = fact[1] = 1;

    for(int i = 2; i < 9; i++)
      fact[i] = fact[i-1]*i;

    for(int i = 3; i < 1000000; i++)
    {
      num = i;
      curious = 0;

      while(num != 0)
      {
        curious += fact[num % 10];
        num /= 10;
      }

      if(curious == i)
        sum += curious;
    }
  
    System.out.println(sum);
  }
}
