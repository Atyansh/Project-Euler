import java.math.*;

class Euler20 {
  public static void main(String arg[]) {
    BigInteger b = new BigInteger("100");
    BigInteger c = new BigInteger("1");

    for(int i = 0; i < 100; i++) {
      c = c.multiply(b);
      b = b.add(new BigInteger("-1"));
    }

    String str = c.toString();
    int sum = 0;

    for(int i = 0; i < str.length(); i++)
      sum += str.charAt(i)-48;

    System.out.println(sum);
  }
}
