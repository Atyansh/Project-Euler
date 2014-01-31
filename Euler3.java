class Euler3
{

  public static void main(String arg[])
  {
    long num = 600851475143l;
    long i = 7;

    long answer = num;

    while(num > 1)
    {
      while(num % i == 0)
      {
        num /= i;
        answer = i;
      }
      
      i += 2;
    }

    System.out.println(answer);
  }

}
