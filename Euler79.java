import java.io.*;
import java.util.*;

class Euler79 {
  public static void main(String[] arg) {
    File file = new File("Euler79.txt");

    Scanner scan;

    String code = "";

    try {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e) {
      System.err.println("File Not Found");
      return;
    }

    String[] combinations = new String[50];

    for(int i = 0; i < combinations.length; i++)
      combinations[i] = scan.nextLine();

    Set<Character> done = new HashSet<Character>();
    
    int index = 0;

a:  while(index < combinations[0].length() - 1) {
      Set<Character> check = new HashSet<Character>();
      Set<Character> fail = new HashSet<Character>();

      for(int i = 0; i < combinations.length; i++) {
        Character c0 = new Character(combinations[i].charAt(index));
        Character c1 = new Character(combinations[i].charAt(index + 1));

        if(!done.contains(c0)) {
          check.add(c0);
          fail.add(c1);
        }
      }

      for(Character c : check) {
        if(!fail.contains(c)) {
          done.add(c);
          code += c.charValue();
          continue a;
        }
      }
      index++;
    }

    for(int i = 0; i < combinations.length; i++) {
      Character c = new Character(combinations[i].charAt(index));

      if(!done.contains(c)) {
        done.add(c);
        code += c;
      }
    }
    System.out.println(code);
  }
}
