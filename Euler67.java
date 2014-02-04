import java.io.*;
import java.util.*;

class Node
{
  int value;
  Node touch1;
  Node touch2;

  long distance;

  Node(int value)
  {
    this.value = value;
  }
}


class Euler67
{
  
  
  public static void main(String arg[]) throws IOException
  {
    File file = new File("Euler67.txt");

    Scanner scan = new Scanner(file);

    Node[][] pattern = new Node[100][];
    
    int length = 100;
    
    long max = 0;

    
    for(int i = 0; i < length; i++)
    {
      pattern[i] = new Node[i+1];
      
      for(int j = 0; j <= i; j++)
        pattern[i][j] = new Node(scan.nextInt());
    }


    for(int i = 0; i < length-1; i++)
      for(int j = 0; j <= i; j++)
      {
        pattern[i][j].touch1 = pattern[i+1][j];
        pattern[i][j].touch2 = pattern[i+1][j+1];
      }

    
    pattern[0][0].distance = pattern[0][0].value;

    Euler18.setDistance(pattern[0][0]);

    for(int j = 0; j < length; j++)
        if(pattern[length-1][j].distance > max)
          max = pattern[length-1][j].distance;

    System.out.println(max);
  }


  public static void setDistance(Node n)
  {
    Node travel;
    Queue<Node> q = new LinkedList<Node>();

    q.add(n);

    while(q.peek() != null)
    {
      travel = q.remove();
      
      if(travel.touch1 == null)
        continue;

      if(travel.touch1.distance < (travel.distance + travel.touch1.value))
      {
        travel.touch1.distance = travel.distance + travel.touch1.value;
        q.add(travel.touch1);
      }
      
      if(travel.touch2.distance < (travel.distance + travel.touch2.value))
      {
        travel.touch2.distance = travel.distance + travel.touch2.value;
        q.add(travel.touch2);
      }
    }
  }
}
