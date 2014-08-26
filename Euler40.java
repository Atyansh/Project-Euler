import java.util.*;

class Euler40 {
  public static void main(String[] arg) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int size = 0;
    int i = 1;
    int num;
    int rev;
    while(size < 1000000) {
      num = i;
      rev = 0;

      while(num != 0) {
        rev = rev*10 + (num % 10);
        num /= 10;
      }
      
      num = i;

      while(rev != 0) {
        list.add(rev % 10);
        size++;
        rev /= 10;
        num /= 10;
      }
      
      while(num != 0) {
        num /= 10;
        list.add(0);
        size++;
      }

      i++;
    }

    Object[] a = list.toArray();
    Integer[] arr = Arrays.copyOf(a, a.length, Integer[].class);

    long product = arr[0] *
                   arr[9] *
                   arr[99] *
                   arr[999] *
                   arr[9999] *
                   arr[99999] *
                   arr[999999];
    
    System.out.println(product);
  }
}
