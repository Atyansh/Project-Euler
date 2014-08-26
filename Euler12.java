class Euler12 {
  public static void main(String arg[]) {
    long n = 1;
    long triangle = 0;
    long value = 0;

    while(value < 500) {
      triangle += n;
      n++;
      value = countFactors(triangle);
    }

    System.out.println(triangle);
  }


  public static long countFactors(long n) {
    long count = 1;
    long i = 3;
    long freq = 0;
    long next;

    while(n % 2 == 0) {
      n /= 2;
      freq++;
    }
    count *= freq+1;
    
    freq = 0;

    while(n > 1) {
      while(n % i == 0) {
        n /= i;
        freq++;
      }
      
      count *= freq+1;
      freq = 0;
      i += 2;
    }

    return count;
  }

}
