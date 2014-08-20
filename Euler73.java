class Euler73
{
  public static void main(String[] arg)
  {
    int answer = 0;

    for(int i = 5; i <= 12000; i++)
      for(int j = i/3+1; j <= i/2; j++)
        if(hcf(i,j) == 1)
          answer++;

    System.out.println(answer);
  }

  public static int hcf(int a, int b)
  {
    int c = a % b;
    while(c != 0)
    {
      a = b;
      b = c;
      c = a % b;
    }

    return b;
  }
}
