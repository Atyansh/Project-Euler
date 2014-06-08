import java.util.*;
import java.io.*;

class Euler54
{
  public static void main(String[] arg)
  {
    File file = new File("poker.txt");
    Scanner scan;
    try
    {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e)
    {
      System.err.println("File not found");
      return;
    }

    int count = 0;

    while(scan.hasNextLine())
    {
      String line = scan.nextLine();

      String[] tokens = line.split(" ");

      Card[] c1 = new Card[5];
      Card[] c2 = new Card[5];

      int tokenCount = 0;
      for(int i = 0; i < 5; i++, tokenCount++)
        c1[i] = new Card(tokens[tokenCount]);
      
      for(int i = 0; i < 5; i++, tokenCount++)
        c2[i] = new Card(tokens[tokenCount]);

      Poker poker = new Poker(c1, c2);
      count = poker.determineWinner() ? count + 1 : count;
    }

    System.out.println(count);
  }
}

class Card implements Comparable<Card>
{
  public int value;
  public int suit;

  public static final int HEARTS = 1;
  public static final int CLUBS = 2;
  public static final int SPADES = 3;
  public static final int DIAMONDS = 4;

  public static final int TWO = 2;
  public static final int THREE = 3;
  public static final int FOUR = 4;
  public static final int FIVE = 5;
  public static final int SIX = 6;
  public static final int SEVEN = 7;
  public static final int EIGHT = 8;
  public static final int NINE = 9;
  public static final int TEN = 10;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;

  public Card(String card)
  {
    char a1 = card.charAt(0);
    char a2 = card.charAt(1);

    if(a1 >= '2' && a1 <= '9')
      value = a1 - 48;
    else if(a1 == 'T')
      value = 10;
    else if(a1 == 'J')
      value = 11;
    else if(a1 == 'Q')
      value = 12;
    else if(a1 == 'K')
      value = 13;
    else if(a1 == 'A')
      value = 14;

    switch(a2)
    {
      case 'H': suit = HEARTS;
                break;
      case 'C': suit = CLUBS;
                break;
      case 'S': suit = SPADES;
                break;
      case 'D': suit = DIAMONDS;
                break;
    }
  }

  public int compareTo(Card c)
  {
    if(this.value < c.value)
      return -1;
    else if(this.value > c.value)
      return 1;
    else
      return 0;
  }

  public String toString()
  {
    return "{" + value + ", " + suit + "}";
  }
}

class Hand
{
  public Card[] c;
  public int p1, p2;

  public Hand(Card[] c)
  {
    this.c = c;
  }
}

class Poker
{
  Hand h1;
  Hand h2;

  public Poker(Card[] c1, Card[] c2)
  {
    Arrays.sort(c1);
    Arrays.sort(c2);

    System.err.println(Arrays.toString(c1) + "  " + Arrays.toString(c2));

    h1 = new Hand(c1);
    h2 = new Hand(c2);
  }

  public boolean determineWinner()
  {
    boolean case1, case2;

    case1 = straightFlush(h1);
    case2 = straightFlush(h2);

    if(case1 && case2)
      return winner();
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = fourOfAKind(h1);
    case2 = fourOfAKind(h2);

    if(case1 && case2)
    {
      if(h1.c[2].value > h2.c[2].value)
        return true;
      else if(h1.c[2].value < h2.c[2].value)
        return false;
      else
        return winner();
    }
      
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = fullHouse(h1);
    case2 = fullHouse(h2);

    if(case1 && case2)
    {
      if(h1.c[2].value > h2.c[2].value)
        return true;
      else if(h1.c[2].value < h2.c[2].value)
        return false;
      else if(h1.p1 > h2.p2)
        return true;
      else return false;
    }
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = flush(h1);
    case2 = flush(h2);

    if(case1 && case2)
    {
      return winner();
    }
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = straight(h1);
    case2 = straight(h2);

    if(case1 && case2)
    {
      return winner();
    }
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = threeOfAKind(h1);
    case2 = threeOfAKind(h2);

    if(case1 && case2)
    {
      if(h1.c[2].value > h2.c[2].value)
        return true;
      else
        return winner();
    }
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = twoPair(h1);
    case2 = twoPair(h2);

    if(case1 && case2)
    {
      if(h1.p1 > h2.p1)
        return true;
      else if(h1.p1 < h2.p1)
        return false;
      else if(h1.p2 > h2.p2)
        return true;
      else if(h1.p2 < h2.p2)
        return false;
      else
        return winner();
    }
    if(case1)
      return true;
    if(case2)
      return false;

    case1 = pair(h1);
    case2 = pair(h2);

    if(case1 && case2)
    {
      if(h1.p1 > h2.p1)
        return true;
      else if(h1.p1 < h2.p1)
        return false;
      else
        return winner();
    }
    if(case1)
      return true;
    if(case2)
      return false;

    return winner();
  }

  public boolean flush(Hand h)
  {
    return (h.c[0].suit == h.c[1].suit &&
           h.c[0].suit == h.c[2].suit &&
           h.c[0].suit == h.c[3].suit &&
           h.c[0].suit == h.c[4].suit);
  }

  private boolean straight(Hand h)
  {
    if(h.c[0].value == Card.TWO &&
       h.c[1].value == Card.THREE &&
       h.c[2].value == Card.FOUR &&
       h.c[3].value == Card.FIVE &&
       h.c[4].value == Card.ACE)
      return true;


    return (h.c[4].value - h.c[3].value == 1 &&
            h.c[3].value - h.c[2].value == 1 &&
            h.c[2].value - h.c[1].value == 1 &&
            h.c[1].value - h.c[0].value == 1);
  }

  private boolean fourOfAKind(Hand h)
  {
    return( (h.c[0].value == h.c[1].value &&
             h.c[1].value == h.c[2].value &&
             h.c[2].value == h.c[3].value) ||
            (h.c[1].value == h.c[2].value &&
             h.c[2].value == h.c[3].value &&
             h.c[3].value == h.c[4].value) );
  }

  private boolean threeOfAKind(Hand h)
  {
    return( (h.c[0].value == h.c[1].value &&
             h.c[1].value == h.c[2].value) ||
            (h.c[1].value == h.c[2].value &&
             h.c[2].value == h.c[3].value) ||
            (h.c[2].value == h.c[3].value &&
             h.c[3].value == h.c[4].value) );
  }

  private boolean pair(Hand h)
  {
    if(h.c[0].value == h.c[1].value &&
       h.c[1].value != h.c[2].value)
    {
      h.p1 = h.c[0].value;
      return true;
    }
    if(h.c[0].value != h.c[1].value &&
       h.c[1].value == h.c[2].value &&
       h.c[2].value != h.c[3].value)
    {
      h.p1 = h.c[1].value;
      return true;
    }
    if(h.c[1].value != h.c[2].value &&
       h.c[2].value == h.c[3].value &&
       h.c[3].value != h.c[4].value)
    {
      h.p1 = h.c[2].value;
      return true;
    }
    if(h.c[2].value != h.c[3].value &&
       h.c[3].value == h.c[4].value)
    {
      h.p1 = h.c[3].value;
      return true;
    }
    return false;
  }

  private boolean twoPair(Hand h)
  {
    int count = 0;
    int index = 0;
    int temp;

    while(index < 4)
    {
      if(h.c[index++].value == h.c[index].value)
      {
        if(h.p1 == 0)
          h.p1 = h.c[index].value;
        else
          h.p2 = h.c[index].value;
        index++;
        count++;
      }
    }
    if(h.p2 > h.p1)
    {
      temp = h.p1;
      h.p1 = h.p2;
      h.p2 = temp;
    }
    return (count == 2);
  }

  private boolean fullHouse(Hand h)
  {
    return threeOfAKind(h) && pair(h);
  }
  
  private boolean straightFlush(Hand h)
  {
    return straight(h) && flush(h);
  }

  private boolean winner()
  {
    for(int i = 4; i >= 0; i--)
    {
      if(h1.c[i].value > h2.c[i].value)
        return true;
      else if(h1.c[i].value < h2.c[i].value)
        return false;
    }
    return false;
  }
}
