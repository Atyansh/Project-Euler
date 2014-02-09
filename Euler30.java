class Euler30
{
  public static void main(String arg[])
  {
    long sum = 0;
    long num;
    long dSum;


    /*
     *  Note- The reason I'm looping only till a million and not beyond (even
     *        though I have to find all possible numbers) is because there won't
     *        be a number greater than 1 million whose sum of digits, each to
     *        the power 5, could be greater than or equal to the number itself.
     *        This is because numbers above 1 million are greater than 10^6,
     *        while sum of the digits to the power 5 simply cannot catch up with
     *        progression.
     */

    for(long i = 101; i < 1000000; i++)
    {
      num = i;
      dSum = 0;

      while(num != 0)
      {
        dSum += (long) Math.pow(num % 10, 5);
        num /= 10;
      }

      if(dSum == i)
        sum += i;
    }

    System.out.println(sum);
  }
}
