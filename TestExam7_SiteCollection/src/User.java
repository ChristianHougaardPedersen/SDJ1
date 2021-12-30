public class User
{
  private String name;
  private SiteCollection siteCollection;

  public User(String name)
  {
    this.name = name;
    //this.siteCollection = siteCollection;
  }

  public String getName()
  {
    return name;
  }

  public SiteCollection getSiteCollection()
  {
    return siteCollection;
  }

  public SiteCollection getAccessibleSites()
  {
    SiteCollection accessibleSites = new SiteCollection();
    for (int i = 0; i < siteCollection.getNumberOfSites(); i++)
    {
      if (siteCollection.getSite(i).hasAccess())
      {
        accessibleSites.addSite(siteCollection.getSite(i));
      }
    }

    return accessibleSites;
  }

}
