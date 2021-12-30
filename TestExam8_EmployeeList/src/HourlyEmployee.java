public class HourlyEmployee extends Employee
{
  private double wagePerHour, hoursWorkedPerWeek;

  public HourlyEmployee(String name, Date birthday, double wagePerHour,
      double hoursWorkedPerWeek)
  {
    super(name, birthday);
    setWagePerHour(wagePerHour);
    setHoursWorkedPerWeek(hoursWorkedPerWeek);
  }

  public void setWagePerHour(double wagePerHour)
  {
    this.wagePerHour = wagePerHour;
  }

  public double getWagePerHour()
  {
    return wagePerHour;
  }

  public void setHoursWorkedPerWeek(double hoursWorkedPerWeek)
  {
    this.hoursWorkedPerWeek = hoursWorkedPerWeek;
  }

  public double getHoursWorkedPerWeek()
  {
    return hoursWorkedPerWeek;
  }

  public double earningsPerWeek()
  {
    return hoursWorkedPerWeek * wagePerHour;
  }

  public String toString()
  {
    return super.toString() + ", Weekly pay: " + earningsPerWeek();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof HourlyEmployee))
    {return false;}
    HourlyEmployee other = (HourlyEmployee) obj;
    return super.equals(obj) && wagePerHour == other.wagePerHour && hoursWorkedPerWeek == other.hoursWorkedPerWeek;
  }

}
