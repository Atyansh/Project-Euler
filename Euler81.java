import java.io.*;
import java.util.*;

class Node
{
  int value;
  Node touch1;
  Node touch2;

  long distance = Long.MAX_VALUE;

  Node(int value)
  {
    this.value = value;
  }
}

class Euler81
{
  public static void main(String[] arg)
  {
    File file = new File("Euler81.txt");

    Scanner scan;

    int length = 80;

    Node[][] pattern = new Node[length][length];

    try
    {
      scan = new Scanner(file);
      scan.useDelimiter(",");
    }
    catch(FileNotFoundException e)
    {
      System.err.println("File Not Found.");
      return;
    }

    for(int i = 0; i < length; i++)
      for(int j = 0; j < length; j++)
        pattern[i][j] = new Node(scan.nextInt());

    for(int i = 0; i < length; i++)
    {
      for(int j = 0; j < length; j++)
      {
        if(i != length - 1)
          pattern[i][j].touch1 = pattern[i+1][j];
        if(j != length - 1)
          pattern[i][j].touch2 = pattern[i][j+1];
      }
    }

    pattern[0][0].distance = pattern[0][0].value;

    setDistance(pattern[0][0]);

    System.out.println(pattern[length-1][length-1].distance);
  }


  public static void setDistance(Node n)
  {
    Node travel;
    Queue<Node> q = new LinkedList<Node>();

    q.add(n);

    while(q.peek() != null)
    {
      travel = q.remove();

      if(travel.touch1 != null)
        if(travel.touch1.distance > (travel.distance + travel.touch1.value))
        {
          travel.touch1.distance = travel.distance + travel.touch1.value;
          q.add(travel.touch1);
        }

      if(travel.touch2 != null)
        if(travel.touch2.distance > (travel.distance + travel.touch2.value))
        {
          travel.touch2.distance = travel.distance + travel.touch2.value;
          q.add(travel.touch2);
        }
    }
  }
}
