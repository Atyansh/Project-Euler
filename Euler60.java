import java.util.*;
import java.io.*;

class Euler60 {
  public static void main(String[] arg) {
    int primeCount = 1230;
    int num = 5;
    int offset = 0;

    int[] primes = new int[primeCount];
    int[] set = new int[num];

    int sum = 0;

    for(int i = 0, j = 3; i < primeCount; j += 2) {
      if(isPrime(j))
        primes[i++] = j;
    }

    pairSet(primes, set, num, offset);

    for(int i = 0; i < set.length; i++)
      sum += set[i];

    System.out.println(sum);
  }

  public static boolean pairSet(int[] primes, int[] set, int num, int offset) {
    if(offset >= num)
      return true;

x:  for(int i = offset; i < primes.length - (num - offset - 1); i++) {
      set[offset] = primes[i];
      
      for(int j = 0; j < offset; j++) {
        if(!isPrime(set[j] + "" + set[offset]) ||
           !isPrime(set[offset] + "" + set[j]))
          continue x;
      }
      
      if(pairSet(primes, set, num, offset + 1))
        return true;
    }
    return false;
  }
  
  public static boolean isPrime(long n) {
    long sqrt = (long) Math.sqrt(n);

    for(long i = 3; i <= sqrt; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
  
  public static boolean isPrime(String num) {
    return isPrime(Long.parseLong(num));
  }
}
