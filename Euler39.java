class Euler39 {
  public static void main(String[] arg) {
    long count;
    long max = 0;
    int p = 3;
    int maxP = 0;
    int A, B, C;

    while(p <= 1000) {
      count = 0;

      for(int a = 1; a < p-1; a++) {
        for(int b = 1; b < p-a-1; b++) {
          int c = p-a-b;
          
          A = a*a; B = b*b; C = c*c;

          if(A+B == C || B+C == A || A+C == B)
            count++;
        }
      }
      
      if(count > max) {
        max = count;
        maxP = p;
      }
      p++;
    }

    System.out.println(maxP);
  }
}
