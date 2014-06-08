class Euler58
{
  public static void main(String[] arg)
  {
    int side = 1;
    int num = 1;
    int prime = 0;
    int total = 1;

    while(true)
    {
      side += 2;
      total += 4;

      for(int i = 0; i < 3; i++)
      {
        num += (side - 1);
        if(isPrime(num))
          prime++;
      }

      num += (side - 1);

      if(((double)prime)/total < 0.1)
        break;
    }

    System.out.println(side);
  }

  public static boolean isPrime(int n)
  {
    if(n % 2 == 0)
      return false;

    int sqrt = (int) Math.sqrt(n);

    for(int i = 3; i <= sqrt; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
}
