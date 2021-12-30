public class School extends Education
{
  private String type;
  public static final String INFANT_SCHOOL = "Infant school";
  public static final String JUNIOR_SCHOOL = "Junior School";
  public static final String SECONDARY_SCHOOL = "Secondary School";
  public static final String HIGH_SCHOOL = "High School";

  public School(String code, String title, String type)
  {
    super(code, title);
    switch (type)
    {
      case "infant":
        this.type = INFANT_SCHOOL; break;
      case "junior":
        this.type = JUNIOR_SCHOOL; break;
      case "secondary":
        this.type = SECONDARY_SCHOOL; break;
      case "high":
        this.type = HIGH_SCHOOL; break;
      default:
        throw new IllegalArgumentException(
            "Type must be: infant, junior, secondary or high");
    }
  }

  public String getSchoolType()
  {
    return type;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof School))
    {
      return false;
    }
    School other = (School) obj;
    return super.equals(obj) && type.equals(other.type);
  }

  public String toString()
  {
    return super.toString() + " Type: " + type;
  }

}
