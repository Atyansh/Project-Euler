class Euler9
{
  public static void main(String arg[])
  {
    int sum = 1000;

    int a, b, c;



    a = 1;

outer:while(a != 1000)
      {
        b = 1;
        while (b != 1000-a)
        {
          c = 1000-a-b;

          if( (c*c) == ((a*a)+(b*b)))
          {
            System.out.println(a*b*c);
            break outer;
          }

          b++;
        }
      
      a++;
    }
  } 
}
