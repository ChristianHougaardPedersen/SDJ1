public class WebSite
{
  private String url;
  private boolean userAccess;

  public WebSite(String url, boolean access)
  {
    this.url = url;
    setAccess(access);
  }

  public String getUrl()
  {
    return url;
  }

  public void setAccess(boolean access)
  {
    this.userAccess = access;
  }

  public boolean hasAccess()
  {
    return userAccess;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof WebSite))
    {
      return false;
    }
    WebSite other = (WebSite) obj;
    return url.equals(other.url) && userAccess == other.userAccess;
  }
}
