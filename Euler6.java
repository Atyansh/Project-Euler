class Euler6 {
  public static void main(String arg[]) {
    long a = 0, b, c;

    for(int i = 1; i <= 100; i++)
      a += i*i;

    b = (100*101)*(100*101)/4;

    c = b-a;

    System.out.println(c);
  }
}
