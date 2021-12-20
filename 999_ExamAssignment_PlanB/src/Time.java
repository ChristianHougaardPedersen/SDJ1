public class Time
{
  private int hour, minute, second;

  public Time(int h, int m, int s)
  {
    if (h >= 0 && h <= 23)
    {
      this.hour = h;
    }
    else if (h > 23)
    {
      this.hour = h % 24;
    }
    else
    {
      throw new IllegalArgumentException("Hour cannot be negative number!");
    }

    if (m >= 0 && m <= 59)
    {
      this.minute = m;
    }
    else if (m < 59)
    {
      this.hour += m / 60;
      this.minute = m % 60;
    }
    else
    {
      throw new IllegalArgumentException("Minute should be value between 0-59");
    }

    if (s >= 0 && s <= 59)
    {
      this.second = s;
    }
    else if (s < 59)
    {
      this.minute += s / 60;
      this.second = s % 60;
    }
    else
    {
      throw new IllegalArgumentException(
          "Seconds should be value between 0-59");
    }
  }

  public Time(int totalTimeInSeconds)
  {
    this.hour = totalTimeInSeconds / 3600;
    this.minute = (totalTimeInSeconds % 3600) / 60;
    this.second = (totalTimeInSeconds % 3600) % 60;
  }

  public int convertToSeconds()
  {
    return (hour * 3600) + (minute * 60) + second;
  }

  public boolean isBefore(Time time2)
  {
    return time2.convertToSeconds()>this.convertToSeconds();
  }

  public Time timeUntil(Time time2)
  {
    return new Time(time2.convertToSeconds()-this.convertToSeconds());
  }

  public Time copy()
  {
    return new Time(this.convertToSeconds());
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {return false;}
    Time other = (Time) obj;
    return convertToSeconds() == other.convertToSeconds();
  }

  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }

  public static void main(String[] args)
  {
    Time t1 = new Time(12, 34, 5);
    Time t2 = new Time(23,0,0);
    Time t3 = new Time (8,0,0);
    System.out.println("Should be true: " + t1.isBefore(t2));
    System.out.println("Should be false: " + t1.isBefore(t3));
    System.out.println(t1);
    System.out.println(t1.timeUntil(t2));
    System.out.println("Should be true: " + t2.copy().equals(t2));

    System.out.println(t1.copy());

  }
}
