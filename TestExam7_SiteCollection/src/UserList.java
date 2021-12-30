import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> userList;

  public UserList()
  {
    userList = new ArrayList<>();
  }

  public int getNumberOfUsers()
  {
    return userList.size();
  }

  public void addUser(User user)
  {
    userList.add(user);
  }

  public User getUser(int index)
  {
    return userList.get(index);
  }

  public User findAUserWithAccessTo(WebSite site)
  {
    if (site.hasAccess())
    {
      return getUser(0);
    }
    else
    {
      for (User i : userList)
      {
        if (i instanceof Administrator)
        {
          return i;
        }
      }
    }

    throw new IllegalArgumentException("No users with access to site.");
  }

  public Administrator findFirstAdministrator()
  {
    for (User i : userList)
    {
      if (i instanceof Administrator)
      {
        return (Administrator) i;
      }
    }

    throw new IllegalArgumentException("No administrators in list");
  }
}
