import java.util.*;

public class Euler87 {
  public static void main(String[] arg) {
    int answer = 0;
    int limit = 50000000;

    Set<Integer> set = new HashSet<Integer>();
    List<Integer> list = PrimeGenerator.generate(7072);
  
    Iterator<Integer> it1 = list.iterator();
    
    while(it1.hasNext()) {
      int a = it1.next();
      int aSum = a * a;

      if(aSum > limit)
        break;
      
      Iterator<Integer> it2 = list.iterator();

      while(it2.hasNext()) {
        int b = it2.next();
        int bSum = aSum + b*b*b; 

        if(bSum > limit)
          break;

        Iterator<Integer> it3 = list.iterator();

        while(it3.hasNext()) {
          int c = it3.next();
          int cSum = bSum + c*c*c*c;

          if(cSum > limit)
            break;
          
          if(set.add(cSum))
            answer++;
        }
      }
    }

    System.out.println(answer);
  }
}
