class Euler71 {
  public static void main(String[] arg) {
    double difference = 0;
    int num = 0;

    for(int i = 8; i <= 1000000; i++) {
      int j = 3*i/7;

      if(hcf(i,j) == 1) {
        double temp = ((double)j)/i;
        if(temp > difference) {
          difference = temp;
          num = j;
        }
      }
    }

    System.out.println(num);
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
