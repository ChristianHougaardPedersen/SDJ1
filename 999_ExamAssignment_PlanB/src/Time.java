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
          "Seconds should be value between 0-59, and cannot be a negative value");
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
    return time2.convertToSeconds() > this.convertToSeconds();
  }

  public Time timeUntil(Time time2)
  {
    if (this.isBefore(time2))
    {
      return new Time(time2.convertToSeconds() - this.convertToSeconds());
    }
    else
      throw new IllegalArgumentException(
          "Time 2 should not be before current time");
  }

  public Time copy()
  {
    return new Time(this.convertToSeconds());
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }
    Time other = (Time) obj;
    return convertToSeconds() == other.convertToSeconds();
  }

  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }

  // toString - Manual version
  public String toStringManual()
  {
    String s = "";
    if (hour < 10)
    {
      s += "0";
    }
    s += hour + ":";
    if (minute < 10)
    {
      s += "0";
    }
    s += minute + ":";
    if (second < 10)
    {
      s += "0";
    }
  s+= second;

    return s;
  }
}


