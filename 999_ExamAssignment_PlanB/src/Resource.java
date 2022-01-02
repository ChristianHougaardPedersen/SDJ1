public class Resource
{
  private String fileName, extension;

  public Resource(String fileName, String extension)
  {
    this.fileName = fileName;
    this.extension = extension;
  }

  public boolean isPDF()
  {
    return extension.equals("PDF") || extension.equals("pdf");
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Resource))
    {
      return false;
    }
    Resource other = (Resource) obj;
    return fileName.equals(other.fileName) && extension.equals(other.extension);
  }

  public String toString()
  {
    return fileName + "." + extension;
  }

}

