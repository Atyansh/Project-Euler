import java.io.*;
import java.util.*;

class Node {
  int value;

  Node up;
  Node down;
  Node left;
  Node right;

  long distance = Long.MAX_VALUE;

  Node(int value) {
    this.value = value;
  }
}

class Euler83 {
  public static void main(String[] arg) {
    File file = new File("Euler83.txt");

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
        if(i != 0)
          pattern[i][j].up = pattern[i-1][j];
        if(i != length - 1)
          pattern[i][j].down = pattern[i+1][j];
        if(j != 0)
          pattern[i][j].left = pattern[i][j-1];
        if(j != length - 1)
          pattern[i][j].right = pattern[i][j+1];
      }
    }

    pattern[0][0].distance = pattern[0][0].value;

    setDistance(pattern[0][0]);

    System.out.println(pattern[length-1][length-1].distance);
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

      if(travel.left != null)
        if(travel.left.distance > (travel.distance + travel.left.value)) {
          travel.left.distance = travel.distance + travel.left.value;
          q.add(travel.left);
        }

      if(travel.right != null)
        if(travel.right.distance > (travel.distance + travel.right.value)) {
          travel.right.distance = travel.distance + travel.right.value;
          q.add(travel.right);
        }
    }
  }
}
