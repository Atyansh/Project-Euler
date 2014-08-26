import java.util.*;

class Euler23 {
  LinkedList<Integer> abundant = new LinkedList<Integer>();

  public static void main(String arg[]) {
    long sum = 0;
    
    int sum1 = 1;

    int sqrt = 0;
    double sqrt1 = 0;

    Euler23 obj = new Euler23();

    for(int i = 1; i < 28123; i++) {
      sqrt1 = Math.sqrt(i);
      sqrt = (int) sqrt1;

      for(int j = 2; j <= sqrt; j++)
        if(i % j == 0) {  
          if(j == sqrt && sqrt == sqrt1)
            sum1 += j;
          else 
            sum1 += j + i/j;
        }
          
      if(sum1 > i)
        obj.abundant.add(i);

      if(!obj.abundantSum(i))
        sum += i;

      sum1 = 1;

    }

    System.out.println(sum);
  }


  boolean abundantSum(int n) {
    Object[] a = abundant.toArray();
    Integer[] arr = Arrays.copyOf(a, a.length, Integer[].class);

    int size = arr.length;

    for(int i = 0; i < size; i++) {
      for(int j = size-1; j >= i; j--) {
        if((arr[i] + arr[j]) < n)
          break;
        else if((arr[i] + arr[j]) == n)
          return true;
      }
    }

    return false;
  }
}
