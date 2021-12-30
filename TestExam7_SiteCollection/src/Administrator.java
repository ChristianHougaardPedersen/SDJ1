public class Administrator extends User
{
  private String name;

  public Administrator(String name)
  {
    super(name);
  }

  public void setUserAccessForSite(WebSite site)
  {
    if (getAccessibleSites().contains(site))
    {
      throw new IllegalArgumentException("Site already has user access!");
    }
    else
    {
      for (int i = 0; i < getSiteCollection().getNumberOfSites(); i++)
      {
        if (getSiteCollection().getSite(i).equals(site))
        {
          getSiteCollection().getSite(i).setAccess(true);
        }
      }
    }
  }

  public Administrator createAdministrator(User user)
  {
    Administrator newAdmin = (Administrator) user;
    return newAdmin;
  }
}
