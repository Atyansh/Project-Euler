import java.util.Arrays;

class Euler24
{
  public static void main(String arg[])
  {
    String a = "0123456789";

    char[] arr = a.toCharArray();

    for(int i = 1; i < 1000000; i++)
      Euler24.next(arr, 9);
    
    System.out.println(new String(arr));
  }


  public static void next(char[] arr, int index)
  {
    if(index == 0)
      return;
    if(arr[index] <= arr[index - 1])
      next(arr, index-1);
    else
    {
      int min = Integer.MAX_VALUE;
      int i2 = Integer.MAX_VALUE;
      
      for(int i = index; i < arr.length; i++)
        if(arr[i] - arr[index-1] < min && arr[i] - arr[index-1] > 0)
        {
            min = arr[i] - arr[index-1];
            i2 = i;
        }
        if(i2 != Integer.MAX_VALUE)
        {
          arr[index-1] += min;
          arr[i2] -= min;
        }
        else
          next(arr, index-1);

      Arrays.sort(arr, index, arr.length);
    }
          
  }
}

