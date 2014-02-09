class Euler28
{
  public static void main(String arg[])
  {
    int[][] spiral = new int[1001][1001];

    int row = 500, col = 500;

    int total = 1001*1001;

    long sum = 0;

    int move = 0;

    int i = 1;

    spiral[row][col] = i++;
    
    while(i <= total)
    {
      move++;

      for(int j = 0; j < move-1; j++)
        spiral[row][++col] = i++;

      if(i > total)
        break;
      else
        spiral[row][++col] = i++;

      for(int j = 0; j < move; j++)
        spiral[++row][col] = i++;

      move++;

      for(int j = 0; j < move; j++)
        spiral[row][--col] = i++;

      for(int j = 0; j < move; j++)
        spiral[--row][col] = i++;
    }
    
    for(i = 0; i < 1001; i++)
      sum += spiral[i][i] + spiral[i][1001-i-1];
    
    sum--;

    System.out.println(sum);
  }
}
