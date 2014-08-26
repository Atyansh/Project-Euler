import java.util.*;

class Euler62 {
  public static void main(String[] arg) {
    for(long a = 5014; a <= 6000; a++) {
      System.err.println(a);
      long n = a*a*a;
      
      String next = "" + n;
      
      char[] arr = next.toCharArray();

      Set<Long> set = new TreeSet<Long>();

      set.add(Long.parseLong(new String(arr)));

      Euler24.next(arr, arr.length - 1);

      while(!next.equals(new String(arr))) {
        next = new String(arr);
        long permutation = Long.parseLong(next);

        long cbrt = isPerfectCube(permutation);

        if(cbrt > 0) {
          set.add(permutation);
        }

        Euler24.next(arr, arr.length - 1);
      }

      if(set.size() == 5) {
        System.out.println(n);
        break;
      }
    }
  }

  public static long isPerfectCube(long n) {
    long cbrt = Math.round(Math.pow(n, 1.0/3));

    if(cbrt*cbrt*cbrt == n)
      return cbrt;
    else
      return -1;
  }
}
