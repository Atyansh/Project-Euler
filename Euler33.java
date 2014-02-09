class Euler33
{
  public static void main(String arg[])
  {
    double value;

    int num1, num2, den1, den2;
    int I, J;

a:  for(int i = 11; i < 98; i++)
    {
      for(int j = i + 1; j < 99; j++)
      {
        if(j % 10 == 0)
          continue;
        else if(i % 10 == 0)
          continue a;
        
        num2 = i % 10;
        num1 = i / 10;
        den2 = j % 10;
        den1 = j / 10;

        if(num1 == den1)
        {
          I = num2;
          J = den2;
        }
        else if(num1 == den2)
        {
          I = num2;
          J = den1;
        }
        else if(num2 == den1)
        {
          I = num1;
          J = den2;
        }
        else if(num2 == den2)
        {
          I = num1;
          J = den1;
        }
        else
          continue;

        if( (((double) I)/J) == (((double) i)/j))
          System.out.println(i+"/"+j);
      }
    }
  }
}
