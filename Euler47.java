import java.util.*;

class Euler47 {
  public static void main(String arg[]) {
    TreeSet<Long> primes;
    
    long num = 647;
    long div;
    long j;

a:  while(true) {
      for(int i = 0; i < 4; i++) {
        primes = new TreeSet<Long>();
        div = 3;
        j = num+i;
        
        if(j % 2 == 0)
          primes.add(2l);
        
        while(j % 2 == 0)
          j /= 2;

        while(j != 1) {
          if(j % div == 0)
            primes.add(div);
          
          while(j % div == 0)
            j /= div;

          div += 2;
        }

        if(primes.size() < 4) {
          num = num + i + 1;
          continue a;
        }
      }

      System.out.println(num);
      break;
    }
  }
}
