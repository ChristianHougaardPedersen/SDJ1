
public class DiscordLesson extends OnlineLesson
{
  private String channelName;

  public DiscordLesson(String topic, Date date, Time start, Time end,
      Resource[] res, boolean camera, String channel)
  {
    super(topic, date, start, end, res, camera);

    if (channel.equals(""))
    {
      throw new IllegalArgumentException("Channel Name should not be empty");
    }
    else
    {
      this.channelName = channel;
    }
  }

  public String getChannelName()
  {
    return channelName;
  }

  public String nameOfSoftware()
  {
    return "Discord";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof DiscordLesson))
    {
      return false;
    }
    DiscordLesson other = (DiscordLesson) obj;
    return super.equals(obj) && channelName.equals(other.channelName);
  }

  public String toString()
  {
    return "\nDiscord Lesson:\n" + super.toString() + "\nChannel: " + channelName;
  }
}
