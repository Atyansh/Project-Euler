class Euler7
{
  public static void main(String arg[])
  {
    int n = 1;
    long i = 3;
    while(n != 10001)
    {
      if(isPrime(i))
        n++;
      i += 2;
    }

    System.out.println(i - 2);
  }

  public static boolean isPrime(long n)
  {
    long a = (long) Math.sqrt(n);

    if(n % 2 == 0)
      return false;
    

    for(int i = 3; i <= a; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
}

