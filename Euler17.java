class Euler17
{
  
  String word;
  int count;
  int freq;
  

  public Euler17(String word, int count, int freq)
  {
    this.word = word;
    this.count = count;
    this.freq = freq;
  }
  
  public static void main(String arg[])
  {
    int and = 3;
    int numAnd = 99*9*and;

    Euler17[] words = new Euler17[30];

    Euler17.initializeWords(words);

    long count = 0;

    for(int i = 0; i < words.length; i++)
    {
      count += (words[i].freq * words[i].count);
    }

    System.out.println(count);

  }


  public static void initializeWords(Euler17[] words)
  {
   
    words[0] = new Euler17("one",         3,  9*10+101);
    words[1] = new Euler17("two",         3,  9*10+100);
    words[2] = new Euler17("three",       5,  9*10+100);
    words[3] = new Euler17("four",        4,  9*10+100);
    words[4] = new Euler17("five",        4,  9*10+100);
    words[5] = new Euler17("six",         3,  9*10+100);
    words[6] = new Euler17("seven",       5,  9*10+100);
    words[7] = new Euler17("eight",       5,  9*10+100);
    words[8] = new Euler17("nine",        4,  9*10+100);
    words[9] = new Euler17("ten",         3,  10);
    words[10] = new Euler17("eleven",     6,  10);
    words[11] = new Euler17("twelve",     6,  10);
    words[12] = new Euler17("thirteen",   8,  10);
    words[13] = new Euler17("fourteen",   8,  10);
    words[14] = new Euler17("fifteen",    7,  10);
    words[15] = new Euler17("sixteen",    7,  10);
    words[16] = new Euler17("seventeen",  9,  10);
    words[17] = new Euler17("eighteen",   8,  10);
    words[18] = new Euler17("nineteen",   8,  10);
    words[19] = new Euler17("twenty",     6,  100);
    words[20] = new Euler17("thirty",     6,  100);
    words[21] = new Euler17("forty",      5,  100);
    words[22] = new Euler17("fifty",      5,  100);
    words[23] = new Euler17("sixty",      5,  100);
    words[24] = new Euler17("seventy",    7,  100);
    words[25] = new Euler17("eighty",     6,  100);
    words[26] = new Euler17("ninety",     6,  100);
    words[27] = new Euler17("hundred",    7,  900);
    words[28] = new Euler17("thousand",   8,  1);
    words[29] = new Euler17("and",        3,  99*9);
  }
}
