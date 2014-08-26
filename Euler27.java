class Euler27 {
  public static void main(String[] arg) {
    long prime;
    long length; 
    long max = 0;

    int A = 0, B = 0;
    int n;

    long product;

    for(int a = -999; a < 1000; a++) {
      for(int b = 3; b < 1000; b += 2) {
        prime = b;
        length = n = 0;

        while(isPrime(prime)) {
          length++;
          n++;

          prime = n*n + a*n + b;
        }

        if(length > max) {
          max = length;
          A = a;
          B = b;
        }
      }
    }

    product = A * B;

    System.out.println(product);
  }

  public static boolean isPrime(long n) {
    if(n < 2)
      return false;

    if(n == 2)
      return true;

    if(n % 2 == 0)
      return false;

    long sqrt = (long) Math.sqrt(n);

    for(long i = 3; i <= sqrt; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
}
