class Euler36
{
  public static void main(String[] arg)
  {
    long sum = 0;
    String num;
    String bin;


    for(int i = 1; i < 1000000; i++)
    {
      num = Integer.toString(i);
      bin = Integer.toBinaryString(i);

      if(checkPalindrome(num) && checkPalindrome(bin))
        sum += i;
    }

    System.out.println(sum);
  }

  public static boolean checkPalindrome(String str)
  {
    int length = str.length();

    for(int i = 0; i < length/2; i++)
      if(str.charAt(i) != str.charAt(length - i - 1))
        return false;

    return true;
  }
}
