import java.io.*;
import java.util.*;

class Node {
  int value;
  Node up;
  Node down;
  Node right;

  long distance = Long.MAX_VALUE;

  Node(int value) {
    this.value = value;
  }
}

class Euler82 {
  public static void main(String[] arg) {
    File file = new File("Euler82.txt");

    Scanner scan;

    int length = 80;

    Node[][] pattern = new Node[length][length];

    try {
      scan = new Scanner(file);
      scan.useDelimiter(",");
    }
    catch(FileNotFoundException e) {
      System.err.println("File Not Found.");
      return;
    }

    for(int i = 0; i < length; i++)
      for(int j = 0; j < length; j++)
        pattern[i][j] = new Node(scan.nextInt());

    for(int i = 0; i < length; i++) {
      for(int j = 0; j < length; j++) {
        if(i != length - 1)
          pattern[i][j].down = pattern[i+1][j];
        if(j != length - 1)
          pattern[i][j].right = pattern[i][j+1];
        if(i != 0)
          pattern[i][j].up = pattern[i-1][j];
      }
    }


    for(int i = 0; i < length; i++) {
      pattern[i][0].distance = pattern[i][0].value;
      setDistance(pattern[i][0]);
    }

    long min = Long.MAX_VALUE;

    for(int i = 0; i < length; i++) {
      if(pattern[i][length-1].distance < min)
        min = pattern[i][length-1].distance;
    }
    
    System.out.println(min);
  }


  public static void setDistance(Node n) {
    Node travel;
    Queue<Node> q = new LinkedList<Node>();

    q.add(n);

    while(q.peek() != null) {
      travel = q.remove();

      if(travel.up != null)
        if(travel.up.distance > (travel.distance + travel.up.value)) {
          travel.up.distance = travel.distance + travel.up.value;
          q.add(travel.up);
        }

      if(travel.down != null)
        if(travel.down.distance > (travel.distance + travel.down.value)) {
          travel.down.distance = travel.distance + travel.down.value;
          q.add(travel.down);
        }
      
      if(travel.right != null)
        if(travel.right.distance > (travel.distance + travel.right.value)) {
          travel.right.distance = travel.distance + travel.right.value;
          q.add(travel.right);
        }
    }
  }
}
