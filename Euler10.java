class Euler10 {
  public static void main(String arg[]) {
    long sum = 2;

    for(long i = 3; i < 2000000; i += 2) {
      if(isPrime(i))
        sum += i;
    }

    System.out.println(sum);
  }

  public static boolean isPrime(long n) {
    long sqrt = (long) Math.sqrt(n);

    for(long i = 3; i <= sqrt; i += 2)
      if(n % i == 0)
        return false;

    return true;
  }
}
