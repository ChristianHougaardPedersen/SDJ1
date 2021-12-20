import java.time.LocalDate;

public class Date
{
  private int day, month, year;

  // CHECK WIP!!
  public Date(int day, int month, int year)
  {
    if (year < 0)
    {
      year = -year;
    }
    if (month < 1)
    {
      month = 1;
    }
    else if (month > 12)
    {
      month = 12;
    }
    if (day < 1)
    {
      day = 1;
    }
    else if (day > daysInMonth())
    {
      day = daysInMonth();
    }
    this.day = day;
    this.month = month;
    this.year = year;

    /*          WIP - MIGHT NOT BE USED
    if (year > 0)
    {
      this.year = year;
    }
    else
    {
      throw new IllegalArgumentException("Year should not be be less than 0");
    }

    if (month > 0)
    {
      if (month <= 12)
      {
        this.month = month;
      }
      else
      {
        this.year += month / 12;
        this.month = month % 12;
      }
    }
    else
    {
      throw new IllegalArgumentException("Month number should be at least 1");
    }

    if (day > 0)
    {
      if (day <= daysInMonth())
      {
        this.day = day;
      }
      else
      {
        if (this.month + day / daysInMonth() >= 12)
        {
          this.year += (this.month + (day/daysInMonth())) / 12;
          this.month =
        }
        else
        {

        }
        this.month += day / daysInMonth();
        this.day = day % daysInMonth();
      }
    }
    else
    {
      throw new IllegalArgumentException("Day number should be at least 0");
    }

     */

  }

  public boolean isBefore(Date date2)
  {
    return year < date2.year || year == date2.year && month < date2.month
        || year == date2.year && month == date2.month && day < date2.day;
  }

  public boolean isLeapYear()
  {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  public int daysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  public void nextDay()
  {
    if (this.day < daysInMonth())
    {
      this.day++;
    }
    else if (this.month < 12)
    {
      this.day = 1;
      this.month++;
    }
    else
    {
      this.day = 1;
      this.month = 1;
      this.year++;
    }
  }

  public int numberOfDaysUntil(Date date2)
  {
    int counter = 0;
    while (this.isBefore(date2))
    {
      nextDay();
      counter++;
    }

    return counter;
  }

  public static Date today()
  {
    return new Date(LocalDate.now().getDayOfMonth(),
        LocalDate.now().getMonthValue(), LocalDate.now().getYear());
  }

  public Date copy()
  {
    return new Date(this.day, this.month, this.year);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date) obj;
    return day == other.day && month == other.month && year == other.year;
  }

  public String toString()
  {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

  public static void main(String[] args)
  {
    /*    WIP TEST
    Date d2 = new Date(800, 18, 2021);
    System.out.println(d2);
     */


    Date d1 = new Date(1, 1, 2021);
    Date d3 = new Date(2,1,2021);
    Date d4 = new Date(31,12,2021);
    Date leapYearTest = new Date(1,1,2024);
    System.out.println(d1);
    System.out.println("Should return false: " + d1.isBefore(today()));
    System.out.println(today());
    System.out.println("Should be true: " + leapYearTest.isLeapYear());
    System.out.println("Should be false: " + d1.isLeapYear());

    /*
    d1.nextDay();
    d3.nextDay();
    d4.nextDay();
    System.out.println("d1: " + d1);
    System.out.println("d3: " + d3 );
    System.out.println("d4: " + d4);
    System.out.println(d4.copy());
     */

    System.out.println("d1: " + d1);
    System.out.println("d3: " + d3 );
    System.out.println("d4: " + d4);
    System.out.println(d1.numberOfDaysUntil(d1.copy()));



  }

}
