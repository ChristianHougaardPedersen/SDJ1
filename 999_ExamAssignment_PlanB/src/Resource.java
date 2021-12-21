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


  //TESTING
  public static void main(String[] args)
  {
    Resource r1 = new Resource("testRes", "PDF");
    Resource r2 = new Resource("testRes", "PDF");
    Resource r3 = new Resource("testRes", "pdf");
    Resource i1 = new Resource("testRes", "jpg");
    System.out.println("Should be true: " + r1.isPDF());
    System.out.println("Should be false: " + i1.isPDF());
    System.out.println("Should be false: " + r1.equals(i1));
    System.out.println("Should be true: " + r1.equals(r2));
    System.out.println("Should be true: " + r3.isPDF());
    System.out.println("Should be false: " + r2.equals(r3));

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(i1);
    System.out.println(r3);
  }

}

