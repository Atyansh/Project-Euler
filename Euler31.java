class Euler31
{
  public static void main(String[] arg)
  {
    int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

    int target = 200;

    long ways = counter(coins, coins.length-1, target);

    System.out.println(ways);
  }

  public static long counter(int[] coins, int index, int target)
  {
    int sum = 0;
    long count = 0;


    if(index == 0)
      return 1;    
    
    while(sum < target)
      sum += coins[index];

    if(sum == target)
      count++;

    while(sum > 0)
    {
      sum -= coins[index];
      count += counter(coins, index - 1, target - sum);
    }

    return count;
  }
}
