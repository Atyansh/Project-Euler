import java.util.*;
import java.io.*;

class Euler11 {
  public static void main(String arg[]) throws IOException {
    int arr[][] = new int[20][20];
    int max = 0, product;
    
    File file = new File("Euler11.txt");
    Scanner scan = new Scanner(file);

    for(int i = 0; i < 20; i++)
      for(int j = 0; j < 20; j++)
        arr[i][j] = scan.nextInt();

    for(int i = 0; i < 20; i++)
      for(int j = 0; j < 20-3; j++) {
        product = arr[i][j] * arr[i][j+1] * arr[i][j+2] * arr[i][j+3];
        if (product > max)
          max = product;
      }

    
    for(int i = 0; i < 20-3; i++)
      for(int j = 0; j < 20; j++) {
        product = arr[i][j] * arr[i+1][j] * arr[i+2][j] * arr[i+3][j];
        if (product > max)
          max = product;
      }


    for(int i = 0; i < 20-3; i++)
      for(int j = 0; j < 20-3; j++) {
        product = arr[i][j] * arr[i+1][j+1] * arr[i+2][j+2] * arr[i+3][j+3];
        if (product > max)
          max = product;

        product = arr[i][j+3] * arr[i+1][j+2] * arr[i+2][j+1] * arr[i+3][j];
        if (product > max)
          max = product;
      }

    System.out.println(max);
  }
}
