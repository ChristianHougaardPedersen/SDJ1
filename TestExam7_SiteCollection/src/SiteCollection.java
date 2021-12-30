import java.util.ArrayList;

public class SiteCollection
{
  private int size;
  private static final int MAX_SITES = 25;
  private ArrayList<WebSite> sites;

  public SiteCollection()
  {
    this.sites = new ArrayList<>();
  }

  public int getNumberOfSites()
  {
    this.size = sites.size();
    return size;
  }

  public void addSite(WebSite site)
  {
    if (getNumberOfSites() <= MAX_SITES)
    {
      sites.add(site);
      size++;
    }
    else
      throw new IllegalArgumentException("Maximum number of sites is 25.");
  }

  public void removeSite(String url)
  {
    for (WebSite i : sites)
    {
      if (i.getUrl().equals(url))
      {
        sites.remove(i);
      }
    }
  }

  public WebSite getSite(int index)
  {
    return sites.get(index);
  }

  public boolean contains(WebSite site)
  {
    for (WebSite i : sites)
    {
      if (i.equals(site))
      {
        return true;
      }
    }
    return false;
  }

}
