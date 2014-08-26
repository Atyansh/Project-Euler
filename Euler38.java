import java.util.*;

class Euler38 {
  public static void main(String[] arg) {
    TreeSet<Integer> digits;

    int max = 0;
    int n;
    int num;
    int count;
    String str;

a:  for(int i = 1; i < 10000; i++) {
      digits = new TreeSet<Integer>();
      count = 0;
      n = 1;
      str = "";

      while(count < 9) {
        num = n*i;
        str = str + num;
        while(num != 0) {
          if(num % 10 == 0 || !digits.add(num % 10))
            continue a;
          
          num /= 10;
          count++;
        }
        
        n++;
      }

      num = Integer.parseInt(str);
      
      if(num > max) {
        max = num;
        System.out.println(i);
      }
    }

    System.out.println(max);
  }
}
