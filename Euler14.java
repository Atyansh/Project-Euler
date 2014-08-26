class Euler14 {
  public static void main(String arg[]) {
    int count = 0;
    long max = 0;
    long index = 0;
    
    for(long i = 3; i < 1000000; i++) {
      count = chain(i);

      if(count > max) {
        max = count;
        index = i;
      }
    }

    System.out.println(index);
  }
  

  public static int chain(long n) {
    int count = 1;

    while(n != 1) {
      if(n % 2 == 0)
        n /= 2;
      else
        n = 3*n + 1;

      count++;
    }

    return count;
  }
}
