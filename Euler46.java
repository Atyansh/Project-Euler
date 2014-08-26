import java.util.*;

class Euler46 {
  public static void main(String arg[]) {
    LinkedList<Integer> primes = new LinkedList<Integer>();

    primes.add(2);
    primes.add(3);
    primes.add(5);
    primes.add(7);

    Iterator<Integer> it;
    
    int i = 9;
    int j;
    int prime, sum;

a:  while(true) {
      i += 2;
      if(!isPrime(i)) {
        it = primes.iterator();
        
        while(it.hasNext()) {
          prime = it.next();
          
          j = 1;
          sum = prime + 2*j*j;

          while(sum < i) {
            j++;
            sum = prime + 2*j*j;
          }

          if(sum == i)
            continue a;
        }

        break a;
      }
      else
        primes.add(i);
    }

    System.out.println(i);
  }

  public static boolean isPrime(int n) {
    int sqrt = (int) Math.sqrt(n);
    for(int i = 3; i <= sqrt; i+=2)
      if(n % i == 0)
        return false;
    
    return true;
  }
}
