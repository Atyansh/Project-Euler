class Euler68 {
  public static void main(String[] arg) {
    int ringVertices = 5;
    int ringSize = ringVertices * 2;

    long answer = 0;

    char[] ring = new char[ringSize];

    String prev = "";

    for(int i = 0, j = 48; i < ringSize; i++, j++)
      ring[i] = (char) (j);

a:  while(!prev.equals(new String(ring))) {
      prev = new String(ring);
      Euler24.next(ring, ringSize - 1);

      int smallIndex = smallIndex(ring);

      if(incorrectDigits(ring))
        continue;

      int sum = 0;
      String combination = "";

      sum = getSum(ring, smallIndex);
      combination = combination + getCombination(ring, smallIndex);

      for(int i = smallIndex + 1; i != smallIndex; i++) {
        if(i == ringSize)
          i = ringSize/2;
        
        if(i == smallIndex)
          break;

        if(getSum(ring, i) != sum)
          continue a;

        combination = combination + getCombination(ring, i);
      }

      long value = Long.parseLong(combination);

      if(value > answer)
        answer = value;
    }

    answer = parse(answer);
    System.out.println(answer);
  }

  public static int smallIndex(char[] arr) {
    int index = arr.length/2;

    for(int i = index + 1; i < arr.length; i++)
      if(arr[i] < arr[index])
        index = i;

    return index;
  }

  public static boolean incorrectDigits(char[] arr) {
    for(int i = arr.length/2; i < arr.length; i++)
      if(arr[i] == '9')
        return false;
    return true;
  }

  public static int getSum(char[] arr, int i) {
    if(i == arr.length - 1)
      return (arr[i] + arr[arr.length/2 - 1] + arr[0]);
    return (arr[i] + arr[i - arr.length/2] + arr[i + 1 - arr.length/2]);
  }

  public static String getCombination(char[] arr, int i) {
    if(i == arr.length - 1)
      return ("" + arr[i] + arr[arr.length/2 - 1] + arr[0]);
    return ("" + arr[i] + arr[i - arr.length/2] + arr[i + 1 - arr.length/2]);
  }

  public static long parse(long n) {
    char[] arr = ("" + n).toCharArray();
    String str = "";

    for(int i = 0; i < arr.length; i++)
      str += (arr[i] == '9') ? "10" : ( (char) (arr[i] + 1));

    return Long.parseLong(str);
  }
}
