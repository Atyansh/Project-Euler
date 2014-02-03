class Euler4
{

  public static void main(String arg[])
  {
    long product;
    long max = 0;

    for(long i = 999; i >= 100; i--)
      for(long j = 999; j>= 100; j--)
      {
        product = i*j;
        if(check(product) && product > max)
          max = product;
      }


    System.out.println(max);

  }

  public static boolean check(long n)
  {
    String s = String.valueOf(n);

    int length = s.length();

    for(int i = 0; i < length/2; i++)
      if(s.charAt(i) != s.charAt(length - 1 - i))
        return false;

    return true;

  }
}
