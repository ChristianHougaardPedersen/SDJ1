public class CoronaPassport
{
  private String reason;
  private Date date;

  /* //TODO MAYBE DELETE THIS??
  public static final String VACCINATED = "Vaccinated";
  public static final String TESTED = "Tested";
  public static final String INFECTED = "Infected";

   */

  public CoronaPassport(String reason, Date date)
  {
    this.date = date.copy();
    if (!(reason.equals("Vaccinated")) && !(reason.equals("Tested")) && !(reason.equals("Infected")))
    {
      throw new IllegalArgumentException("Reason must be: Vaccinated, Tested or Infected");
    }
    this.reason = reason;
  }

  public String getReason()
  {
    return reason;
  }

  public Date getDate()
  {
    return date.copy();
  }

  public String toString()
  {
    return "Corona Passport:\n" + date + "\n" + reason;
  }


  //TODO TEST THIS CLASS

}
