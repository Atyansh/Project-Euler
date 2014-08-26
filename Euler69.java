class Euler69 {
  public static void main(String[] arg) {
    double totientMax = 0.0;
    int max = 0;

    for(int i = 2; i < 1000000; i+=2) {
      int totient = 0;
      for(int j = 1; j < i; j+=2) {
        if(hcf(i, j) == 1)
          totient++;
      }

      double totientTemp = ((double)i)/totient;

      if(((double) i)/totient > totientMax) {
        totientMax = totientTemp;
        max = i;
      }
    }
    
    System.out.println(max);
  }

  public static int hcf(int a, int b) {
    int c = a % b;
    while(c != 0) {
      a = b;
      b = c;
      c = a % b;
    }

    return b;
  }
}

// This is taking too long. I calculated the answer mathematically.
// Answer would be a number highly divisible to reduce the number of totient
// numbers. So I tried to get the largest possible number by multiplying only
// the smallest primes. Answer was 510510, which equals 2*3*5*7*11*13*17
