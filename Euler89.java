import java.util.*;
import java.io.*;

class Roman {
  public static final Roman I = new Roman("I", 1);
  public static final Roman IV = new Roman("IV", 4);
  public static final Roman V = new Roman("V", 5);
  public static final Roman IX = new Roman("IX", 9);
  public static final Roman X = new Roman("X", 10);
  public static final Roman XL = new Roman("XL", 40);
  public static final Roman L = new Roman("L", 50);
  public static final Roman XC = new Roman("XC", 90);
  public static final Roman C = new Roman("C", 100);
  public static final Roman CD = new Roman("CD", 400);
  public static final Roman D = new Roman("D", 500);
  public static final Roman CM = new Roman("CM", 900);
  public static final Roman M = new Roman("M", 1000);

  public static final Roman[] arr = { I, IV, V, IX, X, XL, L, XC, C, CD, D, CM, M };

  public String roman;
  public int value;

  private Roman(String roman, int value) {
    this.roman = roman;
    this.value = value;
  }

  public static int value(char roman) {
    if(roman == 'I')
      return I.value;
    else if(roman == 'V')
      return V.value;
    else if(roman == 'X')
      return X.value;
    else if(roman == 'L')
      return L.value;
    else if(roman == 'C')
      return C.value;
    else if(roman == 'D')
      return D.value;
    else if(roman == 'M')
      return M.value;
    else
      throw new IllegalArgumentException("Not a valid roman numeral character: "
                                         + roman);
  }

  public static int romanToInteger(String roman) {
    int num = 0;

    num += value(roman.charAt(roman.length() - 1));

    for(int i = roman.length() - 2; i >= 0; i--) {
      int current = value(roman.charAt(i));
      int prev = value(roman.charAt(i + 1));
      if(current >= prev)
        num += current;
      else
        num -= current;
    }

    return num;
  }

  public static String integerToRoman(int num) {
    String roman = "";

    for(int i = arr.length - 1; i >= 0; i--) {
      while(num >= arr[i].value) {
        roman += arr[i].roman;
        num -= arr[i].value;
      }
    }
    return roman;
  }
}

class Euler89 {
  public static void main(String[] arg) {
    File file = new File("Euler89.txt");

    Scanner scan;

    try {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e) {
      System.err.println("File Not Found");
      return;
    }
    
    int answer = 0;

    while(scan.hasNextLine()) {
      String roman = scan.nextLine();

      String min = Roman.integerToRoman(Roman.romanToInteger(roman));

      answer += roman.length() - min.length();
    }

    System.out.println(answer);
  }
}
