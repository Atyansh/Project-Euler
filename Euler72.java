import java.util.*;

class Tuple {
  public int value;
  public boolean even;

  public Tuple() {
    this.value = 1;
    this.even = true;
  }

  public String toString() {
    return "(" + value + ", " + even + ")";
  }
}

class Euler72 {
  public static void main(String[] arg) {
    long answer = 0;

    for(int i = 2; i <= 1000000; i++){
      //System.out.println(i);
      int num = i;
      int p = 2;

      Map<Integer, Integer> map = new HashMap<>();

      while(num % p == 0) {
        num /= p;
        if(map.containsKey(p))
          map.put(p, map.get(p) + 1);
        else
          map.put(p, 1);
      }

      p = 3;

      while(num > 1) {
        while(num % p == 0) {
          num /= p;
          if(map.containsKey(p))
            map.put(p, map.get(p) + 1);
          else
            map.put(p, 1);
        }

        p += 2;
      }

      //System.out.println(map);
      List<Tuple> tuples = calculate(map.keySet());

      int simple = productPrime(map.keySet());
      int count = simple;

      for(Tuple tuple : tuples) {
        if(tuple.even)
          count += simple/tuple.value;
        else
          count -= simple/tuple.value;
      }
      
      for(Integer factor : map.keySet()) {
        count *= ((int) Math.pow(factor, map.get(factor) - 1));
      }
    
      if(count < 0)
        throw new RuntimeException("Count was negative. count : " + count + " for i: " + i);

      answer += count;
    }

    System.out.println(answer);
  }

  public static List<Tuple> calculate(Set<Integer> set) {
    List<Integer> list = new ArrayList<>();
    list.addAll(set);
    //System.out.println(list);

    List<Tuple> tuples = new LinkedList<>();

    int pivots = (int) Math.pow(2, list.size());

    for(int i = 1; i < pivots; i++) {
      String bin = Integer.toBinaryString(i);

      List<Integer> arr = new ArrayList<>(bin.length());

      for(int j = bin.length()-1, k = 0; j >= 0; j--, k++) {
        if(bin.charAt(j) == '1')
          arr.add(k);
      }

      Tuple tuple = new Tuple();

      for(Integer index : arr){
        tuple.value *= list.get(index);
        tuple.even = !tuple.even;
      }

      tuples.add(tuple);
    }

    //System.out.println(tuples);

    return tuples;
  }

  public static int productPrime(Set<Integer> set) {
    int answer = 1;

    for(Integer factor : set) {
      answer *= factor;
    }

    return answer;
  }
}
