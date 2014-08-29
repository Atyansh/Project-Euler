import java.io.*;
import java.util.*;

class Euler187 {
  public static void main(String[] arg) {
    int size = 3001134;
    int limit = 100000000;

    long answer = 0;

    int[] primes = new int[size];

    File file = new File("primes");

    Scanner scan;

    try {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e) {
      System.err.println("File Not Found");
      return;
    }

    for(int i = 0; i < size; i++) {
      primes[i] = Integer.parseInt(scan.nextLine());
    }
    
    int pair = 0;

    for(int i = 0; i < size; i++) {
      if(primes[i] * primes[i+1] >= limit) {
        pair = i;
        break;
      }
    }

    answer += pair*(pair+1)/2;

    int square = 0;

    for(int i = pair; i >= 0; i--) {
      if(primes[i]*primes[i] < limit) {
        square = i;
        break;
      }
    }

    answer += (square+1);

    for(int i = pair + 1, edge = pair + 1; i < size; i++) {
      while(primes[i] * primes[edge] > limit) {
        edge--;
      }

      answer += edge + 1;
    }

    System.out.println(answer);
  }
}
