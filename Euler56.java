import java.math.BigInteger;

class Euler56 {
  public static void main(String[] arg) {
    int a = 1;
    int b;

    BigInteger num;
    BigInteger exp;

    int sum = 0;
    int temp;

    while(a < 100) {
      a++;
      b = 1;
      num = new BigInteger("" + a);

      while(b < 100) {
        b++;

        exp = num.pow(b);

        temp = digitSum(exp.toString());

        if(temp > sum)
          sum = temp;
      }
    }

    System.out.println(sum);
  }

  public static int digitSum(String num) {
    int length = num.length();
    int sum = 0;

    for(int i = 0; i < length; i++)
      sum += (num.charAt(i) - 48);
    
    return sum;
  }
}
