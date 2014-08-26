class Euler19 {
  public static void main(String arg[]) {
    int date = 1;
    int month = 1;
    int year = 1901;
    int day = 2;  //Tuesday

    int count = 0;

    while(year != 2001) {
      if(date == 1 && day == 0)
        count++;
      
      date++;
      day = (day + 1) % 7;

      if((date == 29 && month == 2 && (!(leap(year)))) ||
         (date == 30 && month == 2) ||
         (date == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) ||
         (date == 32)) {
        date = 1;
	      month++;
      }
      
      if(month == 13) {
        month = 1;
        year++;
      }
    }
    
    System.out.println(count);
  }

  public static boolean leap(int year) {
    if(year % 400 == 0)
      return true;

    if(year % 100 == 0)
      return false;
    
    return (year % 4 == 0);
  }
}
