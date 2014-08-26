import java.util.*;

class Euler51 {
  public static void main(String arg[]) {
    long num = 3;

    int count = 0;

    while(count != 8) {
      num += 2;

      if(!isPrime(num))
        continue;

      count = calculate("" + num);
    }
    
    System.out.println(num);
  }
  

  public static int calculate(String num) {
    int length = num.length();
    int pivots = (int) Math.pow(2, length);

    int count = 0;
    int temp;

    for(int i = 1; i < pivots; i++) {
      temp = 0;
      
      String bin = Integer.toBinaryString(i);
      ArrayList<Integer> arr = new ArrayList<Integer>(bin.length());
      for(int j = bin.length()-1, k = 0; j >= 0; j--, k++) {
        if(bin.charAt(j) == '1')
          arr.add(k);
      }
      for(char ch = '0'; ch <= '9'; ch++) {
        char[] digits = num.toCharArray();
        for(Integer index : arr)
          digits[length-index.intValue()-1] = ch;

        if(isPrime(Long.parseLong(new String(digits))) && digits[0] != '0') {
          temp++;
        }
      }
      if(temp == 8)
        System.err.printf("Pivots: %0" + length + "d%n", Integer.parseInt(Integer.toBinaryString(i)));

      if(temp > count)
        count = temp;
    }
    return count;
  }

  public static boolean isPrime(long n) {
    if(n < 2)
      return false;

    if(n == 2)
      return true;

    if(n % 2 == 0)
      return false;

    long sqrt = (long) Math.sqrt(n);

    for(long i = 3; i <= sqrt; i+=2)
      if(n % i == 0)
        return false;

    return true;
  }
}
