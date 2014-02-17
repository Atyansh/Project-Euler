import java.util.*;

class Euler50
{
  public static void main(String[] arg)
  {
    LinkedList<Integer> primes = new LinkedList<Integer>();

    primes.add(2);

    int maxPrime = 1000000;

    for(int i = 3; i < maxPrime; i+=2)
      if(isPrime(i))
        primes.add(i);

    Object[] a = primes.toArray();
    Integer[] arr = Arrays.copyOf(a, a.length, Integer[].class);
    
    int length = arr.length;
    int max = 0;
    int prime = 0;

    int sum;

    int consecutive = 0;

a:  for(int i = 0; i < length; i++)
    {
      sum = 0;
      for(int j = i; j < length; j++)
      {
        sum += arr[j];
        if(sum > maxPrime)
          continue a;

        if(Arrays.binarySearch(arr, sum) >= 0)
        {
          consecutive = j-i+1;
          
          if(consecutive > max)
          {
            max = consecutive;
            prime = sum;
          }
        }
      }
    }

    System.out.println(prime);
  }

  public static boolean isPrime(int n)
  {
    if(n == 2)
      return true;

    if(n % 2 == 0)
      return false;

    int sqrt = (int) Math.sqrt(n);

    for(int i = 3; i <= sqrt; i+=2)
      if(n % i == 0)
        return false;

    return true;
  }
}

