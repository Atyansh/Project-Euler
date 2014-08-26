import java.util.*;

class Euler26 {
  public static void main(String[] arg) {
    int a = 1;
    int d = 0;
    int max = 0;

    TreeSet<Integer> remainders;

    outer: for(int i = 2; i < 1000; i++) {
      remainders = new TreeSet<Integer>();
      a = 1;
      while(true) {
        while(a - i < 0) {
          a *= 10;
        }

        if(a % i == 0)
          continue outer;

        if(!remainders.add(a%i)) {
          if(max < remainders.size()) {
            max = remainders.size();
            d = i;
          }
          continue outer;
        }

        a = a % i;
      }
    }
    
    System.out.println(d);
  }
}
