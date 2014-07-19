import java.util.*;

class Euler61
{
  @SuppressWarnings("unchecked")
  public static void main(String[] arg)
  {
   Set<Integer>[] polygons = (Set<Integer>[]) new Set[6];

    for(int i = 0; i < polygons.length; i++)
      polygons[i] = new HashSet<Integer>();
    
    for(int n = 1; n*(n+1)/2 < 10000; n++)
    {
      if(n*(n+1)/2 > 1000 && (n*(n+1)/2 < 10000))
        polygons[0].add(n*(n+1)/2);

      if(n*n > 1000 && n*n < 10000)
        polygons[1].add(n*n);

      if(n*(3*n-1)/2 > 1000 && n*(3*n-1)/2 < 10000)
        polygons[2].add(n*(3*n-1)/2);

      if(n*(2*n-1) > 1000 && n*(2*n-1) < 10000)
        polygons[3].add(n*(2*n-1));

      if(n*(5*n-3)/2 > 1000 && n*(5*n-3)/2 < 10000)
        polygons[4].add(n*(5*n-3)/2);

      if(n*(3*n-2) > 1000 && n*(3*n-2) < 10000)
        polygons[5].add(n*(3*n-2));
    }
    
    char[] arr = {'0', '1', '2', '3', '4', '5'};

    for(int i = 1; i < 720; i++)
    {
      Euler24.next(arr, 5);
      if(check(polygons, arr))
        break;
    }
  }

  public static boolean check(Set<Integer>[] polygons, char[] indices)
  {
    for(int a : polygons[indices[0]-48])
    {
      for(int b : polygons[indices[1]-48])
      {
        if(b / 100 != a % 100)
          continue;

        for(int c : polygons[indices[2]-48])
        {
          if(c / 100 != b % 100)
            continue;

          for(int d : polygons[indices[3]-48])
          {
            if(d / 100 != c % 100)
              continue;
            
            for(int e : polygons[indices[4]-48])
            {
              if(e / 100 != d % 100)
                continue;

              for(int f : polygons[indices[5]-48])
              {
                if(f / 100 != e % 100)
                  continue;

                if(f % 100 != a / 100)
                  continue;

                System.out.println(a+b+c+d+e+f);
                return true;
              }
            }
          }
        }
      }
    }
    return false;
    
  }
}
