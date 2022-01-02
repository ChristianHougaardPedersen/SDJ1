import java.time.LocalDate;

public class Date
{
  private int day, month, year;

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


}
