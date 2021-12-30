public class EmployeeList
{
  private int size;
  private Employee[] employees;

  public EmployeeList(int maxNumberOfEmployees)
  {
    this.size = size;
    this.employees = new Employee[size];
  }

  public void addEmployee(Employee employee)
  {
    for (int i = 0; i < size; i++)
    {
      if (employees[i] == null)
      {
        employees[i] = employee;
      }
    }

    throw new IllegalArgumentException("No vacant spaces for employee.");
  }

  public void removeEmployee(Employee employee)
  {
    int shift = -1;
    for (int i = 0; i < size; i++)
    {
      if (employees[i].equals(employee))
      {
        employees[i] = null;
        shift = i;
        break;
      }
    }

    for (int i = shift; i < size - 1; i++)
    {
      employees[i] = employees[i + 1];
    }
  }

  public int getNumberOfEmployees()
  {
    int counter = 0;
    for (Employee i : employees)
    {
      if (!(i == (null)))
      {
        counter++;
      }
    }

    return counter;
  }

  public Employee[] getAllEmployees()
  {
    int addCounter = 0;
    Employee[] allEmployees = new Employee[getNumberOfEmployees()];
    for (int i = 0; i < size; i++)
    {
      if (!(employees[i] == null))
      {
        allEmployees[addCounter] = employees[i];
        addCounter++;
      }
    }
    return allEmployees;
  }

  public double getTotalEarningsPerWeek()
  {
    double totalEarningPerWeek = 0;
    for (Employee i : getAllEmployees())
    {
      totalEarningPerWeek += i.earningsPerWeek();
    }

    return totalEarningPerWeek;
  }
}
//TODO FINISH THIS