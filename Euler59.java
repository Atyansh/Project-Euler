import java.io.*;
import java.util.*;

class Euler59 {
  public static void main(String[] arg) {
    File file = new File("Euler59.txt");
    
    Scanner scan;

    try {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e) {
      System.err.println("File not found.");
      return;
    }

    String line = scan.nextLine();

    String[] code = line.split(",");

    int[] tokens = new int[code.length];

    for(int i = 0; i < tokens.length; i++)
      tokens[i] = Integer.parseInt(code[i]);

    int total = 0;
    int temp;
    int answer = 0;
    int tempAnswer;
    int tempValue;

    for(int i = 97; i < 123; i++) {
      for(int j = 97; j < 123; j++) {
        for(int k = 97; k < 123; k++) {
          temp = 0;
          tempAnswer = 0;

          int x = 0;
          for(; x < tokens.length - 2; x += 3) {
            tempValue = tokens[x] ^ i;
            tempAnswer += tempValue;
            if(tempValue == 32)
              temp++;

            tempValue = tokens[x+1] ^ j;
            tempAnswer += tempValue;
            if(tempValue == 32)
              temp++;

            tempValue = tokens[x+2] ^ k;
            tempAnswer += tempValue;
            if(tempValue == 32)
              temp++;
          }

          if(x < tokens.length)
            tempAnswer += tokens[x] ^ i;
          if( (x+1) < tokens.length)
            tempAnswer += tokens[x+1] ^ j;

          if(temp > total) {
            total = temp;
            answer = tempAnswer;
          }
        }
      }
    }

    System.out.println(answer);
  }
}
