import java.util.*;

class PrimeGenerator
{
  public static void main(String[] arg)
  {
    System.out.println(2);

    for(long i = 3; ; i += 2)
      if(prime(i))
        System.out.println(i);
  }

  public static List<Integer> generate(long n) {
    List<Integer> primes = new LinkedList<>();
  
    if(n < 2)
      return primes;

    primes.add(2);

    for(int i = 3; i <= n; i += 2) {
      if(prime(i))
        primes.add(i);
    }

    return primes;
  }

  public static boolean prime(long n)
  {
    long sqrt = (long) Math.sqrt(n);

    for(long i = 3; i <= sqrt; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
}
