import java.util.*;

class Euler92 {
  public static void main(String[] arg) {
    TreeSet<Integer> chain;

    int count = 0;
    int num;
    int sum;

    for(int i = 1; i < 10000000; i++) {
      chain = new TreeSet<Integer>();
      
      num = i;

      while(chain.add(num)) {
        if(num == 89)
          count++;

        sum = 0;
        
        while(num != 0) {
          sum += (num % 10)*(num % 10);
          num /= 10;
        }
        num = sum;
      }
    }
    
    System.out.println(count);
  }
}
