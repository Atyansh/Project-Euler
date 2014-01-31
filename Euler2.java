class Euler2
{

  public static void main(String arg[])
  {
    long sum = 0;

    int a = 0, b = 1, c = 1;

    while(c <= 4000000)
    {
      if(c % 2 == 0)
        sum += c;
      
      a = b;
      b = c;

      c = a + b;
    }

    System.out.println(sum);
  }
}
