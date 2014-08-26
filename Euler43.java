class Euler43 {
  public static void main(String arg[]) {
    String a = "1023456789";

    char[] arr = a.toCharArray();

    int[] primes = {2, 3, 5, 7, 11, 13, 17};

    int num;
    long sum = 0;


loop:while(!(new String(arr)).equals("9876543210")) {
      Euler24.next(arr, 9);

      for(int i = 0; i < 7; i++) {
        num = Integer.parseInt(""+arr[i+1]+arr[i+2]+arr[i+3]);
        if(num % primes[i] != 0)
          continue loop;
      }
      
      a = new String(arr);
      sum += Long.valueOf(a);
    }

    System.out.println(sum);
  }
}
