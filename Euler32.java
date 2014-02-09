import java.util.*;

class Euler32
{
  public static void main(String[] arg)
  {
    TreeSet<Integer> digits;
    TreeSet<Integer> products = new TreeSet<Integer>();
    
    int product, I, J;
    long sum = 0;
    
    for(int i = 1; i < 10000; i++)
    {
a:    for(int j = 1; j < 10000; j++)
      {
        if( i * j > 10000 || i * j < 100)
          continue;
        
        digits = new TreeSet<Integer>();

        product = i * j;
        I = i; J = j;

        for(int k = 0; k < 9;)
        { 
          if(product == 0 && I == 0 & J == 0)
            continue a;
          
          if(product != 0)
          {
            if(!digits.add(product % 10))
              continue a;
            k++;
            product /= 10;
          }

          if(k == 9)
            break;

          if(I != 0)
          {
            if(!digits.add(I % 10))
              continue a;
            k++;
            I /= 10;
          }

          if(k == 9)
            break;

          if(J != 0)
          {
            if(!digits.add(J % 10))
              continue a;
            k++;
            J /= 10;
          }
        }
 
        if(product == 0 && I == 0 & J == 0 && !digits.contains(0) && products.add(i*j))
          sum += i*j;
      }
    }

    System.out.println(sum);
  }
}
