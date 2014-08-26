import java.io.*;
import java.util.*;

class Euler42 {
  public static void main(String[] arg) throws IOException {
    File file = new File("Euler42.txt");

    Scanner scan = new Scanner(file);

    String str = scan.nextLine();

    str = str.replaceAll("\"", "");

    String[] arr = str.split(",");
    int value;
    int count = 0;
    int triangle;

    for(int i = 0; i < arr.length; i++) {
      value = getValue(arr[i]);
      
      triangle = (int) Math.sqrt(value*2);

      if(((triangle) * (triangle + 1))/2.0 == value)
        count++;
    }

    System.out.println(count);
  }


  public static int getValue(String str) {
    int length = str.length();
    int value = 0;

    for(int i = 0; i < length; i++)
      value += (str.charAt(i)-64);

    return value;
  }
}
