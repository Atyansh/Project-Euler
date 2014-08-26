import java.util.*;

class Euler74 {
  public static final long ZERO = factorial(0);
  public static final long ONE = factorial(1);
  public static final long TWO = factorial(2);
  public static final long THREE = factorial(3);
  public static final long FOUR = factorial(4);
  public static final long FIVE = factorial(5);
  public static final long SIX = factorial(6);
  public static final long SEVEN = factorial(7);
  public static final long EIGHT = factorial(8);
  public static final long NINE = factorial(9);

  public static void main(String[] arg) {
    int answer = 0;

    for(int i = 1; i < 1000000; i++) {
      Set<Long> set = new HashSet<Long>();
      
      long value = i;


      while(!set.contains(value)) {
        set.add(value);

        long sum = 0;
        while(value != 0) {
          sum += digitFactorial((int) value % 10);
          value = value / 10;
        }

        value = sum;
      }

      if(set.size() == 60)
        answer++;
    }

    System.out.println(answer);
  }

  public static long factorial(long n) {
    return ((n == 0) ? 1 : (n * factorial(n-1)));
  }

  public static long digitFactorial(int digit) {
    switch(digit) {
      case 0: return ZERO;
      case 1: return ONE;
      case 2: return TWO;
      case 3: return THREE;
      case 4: return FOUR;
      case 5: return FIVE;
      case 6: return SIX;
      case 7: return SEVEN;
      case 8: return EIGHT;
      case 9: return NINE;
    }

    throw new IllegalArgumentException("Digit must be between 0-9");
  }
}
