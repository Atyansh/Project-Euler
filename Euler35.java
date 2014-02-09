class Euler35
{
  public static void main(String[] arg)
  {
    int count = 1;
    int num;

a:  for(int i = 3; i < 1000000; i += 2)
    {
      if(isPrime(i))
      {
        num = rotate(i);

        while(num != i)
        {
          if(!isPrime(num))
            continue a;

          num = rotate(num);
        }
        
        count++;
      }
    }

    System.out.println(count);
  }

  public static int rotate(int n)
  {
    int a = n % 10;
    n /= 10;
    int b = 1;

    while(n / b != 0)
      b *= 10;

    n += a*b;
    return n;
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
